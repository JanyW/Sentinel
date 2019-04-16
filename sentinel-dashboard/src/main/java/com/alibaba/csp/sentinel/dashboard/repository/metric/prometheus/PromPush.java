package com.alibaba.csp.sentinel.dashboard.repository.metric.prometheus;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.MetricEntity;
import io.prometheus.client.CollectorRegistry;
import io.prometheus.client.Gauge;
import io.prometheus.client.Histogram;
import io.prometheus.client.exporter.PushGateway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;

import java.io.IOException;

/**
 * PromPush
 * @author: rooot
 * @date: 2019-04-12
 */
public class PromPush implements ApplicationListener<MetricEvent> {

	private static final Logger LOGGER = LoggerFactory.getLogger(PromPush.class);

	private PushGateway pushGateway;

	private CollectorRegistry registry;

	private Gauge gauge;

	private Histogram histogram;

	private String env;

	public PromPush() {
		env = System.getProperty("apollo.api.env");
		String url = System.getProperty("prom.url");
		registry = new CollectorRegistry();
		gauge = Gauge.build().name("sentinel_qps").labelNames("env", "app", "res", "type").help("sentinel_qps").register(registry);
		histogram = Histogram.build().name("sentinel_rt").labelNames("env", "app", "res").help("sentinel_rt").register(registry);
		pushGateway = new PushGateway(url);
	}

	public void push(MetricEntity metric) {
		String app = metric.getApp();
		String res = metric.getResource();
		gauge.labels(env, app, res, "pass").set(metric.getPassQps());
		gauge.labels(env, app, res, "success").set(metric.getSuccessQps());
		gauge.labels(env, app, res, "block").set(metric.getBlockQps());
		gauge.labels(env, app, res, "exception").set(metric.getExceptionQps());
		histogram.labels(env, app, res).observe(metric.getRt());
		try {
			pushGateway.push(registry, "sentinel");
		} catch (IOException e) {
			LOGGER.warn("send push gateway failed: " + e.getMessage());
		}
	}

	@Async
	@Override
	public void onApplicationEvent(MetricEvent metricEvent) {
		metricEvent.getMetrics().forEach(this::push);
	}
}
