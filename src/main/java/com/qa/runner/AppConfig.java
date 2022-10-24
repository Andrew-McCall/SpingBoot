package com.qa.runner;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class AppConfig {

	@Bean
	public String starter2() {
		return ("Goodbye World!");
	}

}
