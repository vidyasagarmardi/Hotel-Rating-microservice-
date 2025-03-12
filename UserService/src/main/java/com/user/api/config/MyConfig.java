package com.user.api.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class MyConfig {
	
	@Bean
	@LoadBalanced
	RestTemplate restTepmplate() {
		return new RestTemplate();
	}
	
	@Bean
	ObjectMapper objectMapper() {
		return new ObjectMapper();
	}

}
