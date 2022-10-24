package com.qa.runner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class QaSpring2Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(QaSpring2Application.class, args);

		String byName = context.getBean("starter").toString();
		String byType = context.getBean("starter2", String.class);
		String byBoth = context.getBean("starter", String.class);

		System.out.println(byName);
		System.out.println(byType);
		System.out.println(byBoth);
	}

	@Bean
	public String starter() {
		return "Hello World!";
	}

}
