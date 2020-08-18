package com.mustache.poc.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.mustache.poc.entity.Operation;
import com.mustache.poc.model.OperationRequest;
import com.mustache.poc.repository.OperationsRepo;
import com.mustache.poc.util.GroovyUtil;

@Service
public class OperationsService {
	@Autowired
	private OperationsRepo operationRepo;

	private boolean modified = Boolean.FALSE;
	
	private Map<String, Function<Object, Object>> functions = null;

	public String add(OperationRequest request) {
		Operation operation = operationRepo.findFirstByName(request.getName());
		if (ObjectUtils.isEmpty(operation)) {
			operation = new Operation();
			operation.setName(request.getName());
		}
		operation.setCode(request.getCode());
		operationRepo.save(operation);
		modified = Boolean.TRUE;
		return operation.getId().toString();
	}

	public Map<String, Function<Object, Object>> getAll() {
		if(ObjectUtils.isEmpty(functions) || modified) {
			init();
		}
		return functions;
	}
	
	@PostConstruct
	public void init()
	{
		functions = new HashMap<>();
		List<Operation> operations = operationRepo.findAll();
		if (!ObjectUtils.isEmpty(operations)) {
			for (Operation operation : operations) {
				functions.put(operation.getName(), new Function<Object, Object>() {
					@Override
					public Object apply(Object t) {
						Map<String, Object> params = new HashMap<>();
						params.put("input", t);
						return GroovyUtil.evaluate(operation.getCode(), params);
					}
				});
			}
		}
	}
}
