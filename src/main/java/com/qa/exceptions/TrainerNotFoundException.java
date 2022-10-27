package com.qa.exceptions;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Trainer Not Found!!")
public class TrainerNotFoundException extends EntityNotFoundException {

	private static final long serialVersionUID = 360649056956465884L;

}
