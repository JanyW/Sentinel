package com.alibaba.csp.sentinel.dashboard.repository.metric.prometheus;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.MetricEntity;
import org.springframework.context.ApplicationEvent;

/**
 * MetricEvent
 * @author: rooot
 * @date: 2019-04-12
 */
public class MetricEvent extends ApplicationEvent {

	private Iterable<MetricEntity> metrics;

	public MetricEvent(Object source, Iterable<MetricEntity> metrics) {
		super(source);
		this.metrics = metrics;
	}

	public Iterable<MetricEntity> getMetrics() {
		return metrics;
	}
}
