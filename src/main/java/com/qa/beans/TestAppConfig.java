package com.qa.beans;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;

import com.qa.models.Trainer;

@Configuration
@Profile("test")
public class TestAppConfig {

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
		return 154;
	}

}
