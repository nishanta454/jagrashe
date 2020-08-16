package com.mustache.poc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mustache.poc.model.OperationRequest;
import com.mustache.poc.service.OperationsService;

@RestController
public class OperationsController {

	@Autowired
	private OperationsService operationService;

	@PostMapping("/add-operation")
	public String add(@RequestBody OperationRequest request) {
		return operationService.add(request);
	}
}
