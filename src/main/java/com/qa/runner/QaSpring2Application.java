package com.qa.runner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class QaSpring2Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(QaSpring2Application.class, args);

		System.out.println(context.getBean("starter").toString());
		System.out.println(context.getBean("starter").toString());

		ExampleService es = context.getBean(ExampleService.class);
		System.out.println(es.getDateBean());

	}

}
