package com.bnSoft.taskManager.Exception;

public class TaskNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4698536640218955642L;

	TaskNotFoundException(String message) {
		super(message);
	}

}
