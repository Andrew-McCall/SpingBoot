package com.qa.exceptions;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Trainer Not Found!!")
public class TrainerNotFoundException extends NotFoundException {

	private static final long serialVersionUID = 360649056956465884L;

}
