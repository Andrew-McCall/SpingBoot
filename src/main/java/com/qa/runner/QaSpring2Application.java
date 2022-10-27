package com.qa.runner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
// Scans not needed if in parent package
@ComponentScan("com.qa")
@EnableJpaRepositories("com.qa.repos")
@EntityScan("com.qa.models")
public class QaSpring2Application {

	public static void main(String[] args) {
		SpringApplication.run(QaSpring2Application.class, args);
	}

}
