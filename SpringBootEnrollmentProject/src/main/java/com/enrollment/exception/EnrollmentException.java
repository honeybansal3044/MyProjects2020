package com.enrollment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Enrollee Not Found")
public class EnrollmentException extends RuntimeException {

	private static final long serialVersionUID = 6809296483545508957L;

	public EnrollmentException(String exception) {
		super(exception);
	}
}
