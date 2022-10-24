package com.qa.runner;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@SuppressWarnings("unused")
public class Trainer {

	public Trainer(@Size(min = 2, max = 32) String name) {
		this.name = name;
	}

	private String name;

//	@Pattern(regexp = "[0-9]+/[0-9]+/22")
	@Email
	private String email;

	@Min(18)
	private int age;

}
