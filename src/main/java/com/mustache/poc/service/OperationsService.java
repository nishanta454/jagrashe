package com.mustache.poc.service;

import java.util.HashMap;
import java.util.Map;

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

	public String add(OperationRequest request) {
		Operation operation = operationRepo.findFirstByCampaignIdAndFieldName(request.getCampaignId(), request.getFieldName());
		if (ObjectUtils.isEmpty(operation)) {
			operation = new Operation();
			operation.setCampaignId(request.getCampaignId());
			operation.setFieldName(request.getFieldName());
		}
		operation.setOperation(request.getOperation());
		operationRepo.save(operation);
		return operation.getId().toString();
	}
	
	public void execute(Map<String, Object> data, String campaignId) {
		for(Map.Entry<String, Object> entry: data.entrySet()) {
			Operation operation = operationRepo.findFirstByCampaignIdAndFieldName(campaignId, entry.getKey());
			if (!ObjectUtils.isEmpty(operation)) {
				Map<String, Object> params = new HashMap<>();
				params.put(entry.getKey(), entry.getValue());
				data.put(entry.getKey(), GroovyUtil.evaluate(operation.getOperation(), params));
			}
		}
	}
}
