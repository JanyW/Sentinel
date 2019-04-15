package com.alibaba.csp.sentinel.dashboard.rule.apollo;

/**
 *
 * @author: rooot
 * @date: 2019-04-10
 */
public enum RuleType {
	FLOW(1, "流控规则"),
	DEGRADE(2, "降级规则"),
	PARAM_FLOW(3, "热点规则"),
	SYSTEM(4, "系统规则"),
	AUTHORITY(5, "系统规则");


	private Integer code;
	private String value;

	RuleType(Integer code, String value) {
		this.code = code;
		this.value = value;
	}

	public Integer getCode() {

		return code;
	}

	public String getValue() {
		return value;
	}
}
