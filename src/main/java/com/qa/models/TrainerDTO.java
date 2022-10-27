package com.qa.models;

public class TrainerDTO {

	private String firstName;
	private String email;

	public TrainerDTO(String firstName, String email) {
		this.firstName = firstName;
		this.email = email;
	}

	public TrainerDTO(Trainer trainer) {
		this.firstName = trainer.getFirstName();
		this.email = trainer.getEmail();
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
