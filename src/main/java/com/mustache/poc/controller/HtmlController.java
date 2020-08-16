package com.mustache.poc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mustache.poc.model.HtmlRequest;
import com.mustache.poc.model.HtmlResponse;
import com.mustache.poc.service.HtmlService;

@RestController
public class HtmlController {
	
	@Autowired
	private HtmlService htmlService;
	
	@PostMapping("/get-html")
	public HtmlResponse html(@RequestBody HtmlRequest request) {
		HtmlResponse response = new HtmlResponse();
		response.setHtml(htmlService.html(request));
		return response;
	}
}
