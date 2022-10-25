package com.qa.runner;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

	private Boolean bool = true;

	@Bean
	public List<Trainer> trainers() {
		return new ArrayList<Trainer>();
	}

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

	@Bean
	@Primary
	public int squared(int n) {
		return n * n;
	}

	@Bean
	@Qualifier
	public int n() {
		return 4;
	}

}
