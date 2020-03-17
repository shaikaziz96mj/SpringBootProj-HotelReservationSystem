package com.ss.advice;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class Exception_ErrorHandler {

	@ExceptionHandler(DataAccessException.class)
	public String handleSQL_DBError() {
		return "db_error";
	}
	
	@ExceptionHandler(EmptyResultDataAccessException.class)
	public String handle_DBError() {
		return "db_error";
	}
	
	@ExceptionHandler(Exception.class)
	public String handleAllExceptions() {
		return "all_error";
	}
	
}