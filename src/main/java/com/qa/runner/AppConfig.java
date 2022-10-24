package com.qa.runner;

import java.time.LocalTime;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

	private Boolean bool = true;

	@Bean
	@Scope("prototype")
	public String starter() {
		bool = !bool;
		if (bool) {
			return "Starter!";
		} else {
			return "Not Starter!";
		}
	}

	@Bean
	public LocalTime getLocalTime() {
		return LocalTime.now();
	}

}
