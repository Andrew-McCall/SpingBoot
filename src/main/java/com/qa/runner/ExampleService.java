package com.qa.runner;

import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExampleService {

	@Autowired
	private LocalTime dateBean;

	public LocalTime getDateBean() {
		return dateBean;
	}

}