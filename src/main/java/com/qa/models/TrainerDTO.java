package com.qa.models;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class TrainerDTO {

	private String firstName;
	private String email;

	public TrainerDTO(Trainer trainer) {
		this.firstName = trainer.getFirstName();
		this.email = trainer.getEmail();
	}

}
