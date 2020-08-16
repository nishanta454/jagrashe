package com.mustache.poc.model;

import java.util.Map;

import lombok.Data;

@Data
public class HtmlRequest {
	private String campaignId;
	private String template;
	private Map<String, Object> data;
}
