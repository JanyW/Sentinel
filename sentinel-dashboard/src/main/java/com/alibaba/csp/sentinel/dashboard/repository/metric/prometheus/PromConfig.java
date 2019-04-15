package com.alibaba.csp.sentinel.dashboard.repository.metric.prometheus;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * PromConfig
 * @author: rooot
 * @date: 2019-04-12
 */
@EnableAsync
@Configuration
public class PromConfig implements AsyncConfigurer {

	@Override
	public Executor getAsyncExecutor() {
		//使用Spring内置线程池任务对象
		ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
		//设置线程池参数
		taskExecutor.setCorePoolSize(5);
		taskExecutor.setMaxPoolSize(10);
		taskExecutor.setQueueCapacity(25);
		taskExecutor.initialize();
		return taskExecutor;
	}

	@Bean
	public PromPush promPush() {
		return new PromPush();
	}
}
