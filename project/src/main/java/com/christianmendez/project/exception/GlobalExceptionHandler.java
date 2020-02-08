package com.christianmendez.project.exception;

import java.util.logging.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.christianmendez.project.util.ConstantsEnum;

/**
* This ControllerAdvice handles all possible exceptions and return a corresponding message.
*
* @author  Christian Mendez
* @version 1.0
* @since   2020-02-07 
*/

@ControllerAdvice
public class GlobalExceptionHandler {
	
	private final static Logger LOGGER = Logger.getLogger(GlobalExceptionHandler.class.getName());
	
	@ExceptionHandler(InvalidFormatEmailException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public @ResponseBody ExceptionResponse handleInvalidFormatEmailException() {

		LOGGER.warning("Invalid format to email");
		
		ExceptionResponse error = new ExceptionResponse();
		error.setMensaje(ConstantsEnum.INVALIDMAIL.toString());

		return error;
	}
	
	@ExceptionHandler(InvalidFormatPasswordException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public @ResponseBody ExceptionResponse handleInvalidFormatPasswordException() {

		LOGGER.warning("Invalid format to password");
		
		ExceptionResponse error = new ExceptionResponse();
		error.setMensaje(ConstantsEnum.INVALIDPASSWORD.toString());

		return error;
	}
	
	@ExceptionHandler(ExistsEmailException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public @ResponseBody ExceptionResponse handleExistsEmailException() {

		LOGGER.warning("Exists Email");
		
		ExceptionResponse error = new ExceptionResponse();
		error.setMensaje(ConstantsEnum.EXISTSMAIL.toString());

		return error;
	}
	
	@ExceptionHandler(UsernameNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public @ResponseBody ExceptionResponse handleUsernameNotFoundException() {

		LOGGER.warning("User no exists in database");
		
		ExceptionResponse error = new ExceptionResponse();
		error.setMensaje(ConstantsEnum.USERNOTFOUND.toString());

		return error;
	}

}
