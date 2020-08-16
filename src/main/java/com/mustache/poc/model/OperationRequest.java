package com.mustache.poc.model;

import lombok.Data;

@Data
public class OperationRequest {
   private String campaignId;
   private String fieldName;
   private String operation;
}
