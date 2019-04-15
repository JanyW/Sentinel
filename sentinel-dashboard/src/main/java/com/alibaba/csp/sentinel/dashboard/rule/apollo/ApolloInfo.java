package com.alibaba.csp.sentinel.dashboard.rule.apollo;

import org.springframework.beans.factory.annotation.Value;

/**
 *
 * @author: rooot
 * @date: 2019-04-10
 */
public class ApolloInfo {

	@Value("${apollo.api.url:}")
	private String url;

	@Value("${apollo.api.token:}")
	private String token;

	@Value("${apollo.api.appId:}")
	private String appId;

	@Value("${apollo.api.env:}")
	private String env;

	@Value("${apollo.api.cluster:}")
	private String cluster;

	@Value("${apollo.api.namespace:}")
	private String namespace;

	public String getUrl() {
		return url;
	}

	public String getToken() {
		return token;
	}

	public String getAppId() {
		return appId;
	}

	public String getEnv() {
		return env;
	}

	public String getCluster() {
		return cluster;
	}

	public String getNamespace() {
		return namespace;
	}
}
