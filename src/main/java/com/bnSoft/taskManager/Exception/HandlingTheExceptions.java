package com.bnSoft.taskManager.Exception;

import java.text.ParseException;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HandlingTheExceptions {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ExceptionError> handling(Exception e) {
		if (e instanceof ParseException) {
			return ResponseEntity.badRequest().body(new ExceptionError(e.getMessage()));

		}
		if (e instanceof HttpMessageNotReadableException) {
			return ResponseEntity.badRequest()
					.body(new ExceptionError("date Parse Exception your entring date format most be YYYY-DD-MM"));
		} else {
			return ResponseEntity.internalServerError().body(new ExceptionError("Internal Server Error"));
		}
	}
}
