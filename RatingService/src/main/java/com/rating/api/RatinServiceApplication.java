package com.rating.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class RatinServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RatinServiceApplication.class, args);
	}

}
