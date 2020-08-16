package com.mustache.poc.service;

import java.io.StringReader;
import java.io.StringWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;
import com.mustache.poc.model.HtmlRequest;

@Service
public class HtmlService {
     @Autowired
     private OperationsService operationsService;
	
     @Autowired
     private MustacheFactory mustacheFactory;
     
     public String html(HtmlRequest request) {
    	 Mustache mustache = mustacheFactory.compile(new StringReader(request.getTemplate()), "todo_template");
    	 StringWriter writer = new StringWriter();
    	 operationsService.execute(request.getData(), request.getCampaignId());
    	 mustache.execute(writer, request.getData());
    	 return writer.toString();
     }
}
