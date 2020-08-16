package com.mustache.poc.util;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ObjectUtils;

import groovy.lang.GroovyShell;

public class GroovyUtil
{
	private static final Logger logger = LoggerFactory.getLogger(GroovyUtil.class);

	private static final GroovyShell shell = new GroovyShell();

	private GroovyUtil()
	{
		throw new IllegalStateException("Utility Class");
	}

	public static Object evaluate(String script, Map<String, Object> params)
	{
		Object result = null;

		try
		{
			if (!ObjectUtils.isEmpty(params))
			{
				for (Map.Entry<String, Object> param : params.entrySet())
				{
					shell.setVariable(param.getKey(), param.getValue());
				}
			}

			result = shell.evaluate(script);
		} catch (Exception ex)
		{
			logger.error("**** exception while evaluating groovy script {}*****", script, ex);
		}
		return result;
	}
}
