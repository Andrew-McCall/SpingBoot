package com.qa.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;

import lombok.Data;

@Entity
@Data
public class Trainer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "firstName")
	private String firstName;

	@Email
	@Column
	private String email;

	@Min(18)
	@Column()
	private int age;

	public Trainer() {
	}

	public Trainer(Long id, String firstName, @Email String email, @Min(18) int age) {
		this.id = id;
		this.firstName = firstName;
		this.email = email;
		this.age = age;
	}
}
