package com.qa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExampleService {

	@Autowired
	private int squaredBean;

	public int getSquaredBean() {
		return squaredBean;
	}

}