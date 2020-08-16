package com.mustache.poc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.MustacheFactory;

@Configuration
public class MustacheConfig {

	@Bean
	public MustacheFactory getMustacheFactory() {
		return new DefaultMustacheFactory();
	}
}
