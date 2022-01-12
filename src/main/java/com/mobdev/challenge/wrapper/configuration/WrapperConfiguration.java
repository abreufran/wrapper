package com.mobdev.challenge.wrapper.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class WrapperConfiguration {
	@Bean
	public RestTemplate restTemplate(){
		RestTemplate restTemplate = new RestTemplate();

		return restTemplate;
	}
}
