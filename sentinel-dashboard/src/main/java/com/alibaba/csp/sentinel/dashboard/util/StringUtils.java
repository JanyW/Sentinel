package com.alibaba.csp.sentinel.dashboard.util;

/**
 *
 * @author: rooot
 * @date: 2019-04-10
 */
public final class StringUtils {

	public static String getAppName(String app, String ip, Integer port) {
		if ("0".equals(ip)) {
			return app;
		}
		return String.format("%s-%s:%d", app, ip, port);
	}
}
