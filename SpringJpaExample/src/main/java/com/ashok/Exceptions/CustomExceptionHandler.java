package com.ashok.Exceptions;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ashok.entity.ErrorMessage;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
	

	@ExceptionHandler(NESLException.class)
	public ResponseEntity<ErrorMessage> handleNSELException(NESLException ex,WebRequest request1,final HttpServletRequest request){
		ErrorMessage errMsg=new ErrorMessage();
		errMsg.setMessage(ex.getLocalizedMessage());
		errMsg.setTime( LocalDateTime.now().toString());
		errMsg.setUrl(request.getRequestURI());
		return new ResponseEntity<ErrorMessage>(errMsg, HttpStatus.NOT_FOUND);
		
	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorMessage> handleNSELException1(Exception ex,WebRequest request){
		ErrorMessage errMsg=new ErrorMessage();
		errMsg.setMessage(ex.getLocalizedMessage());
		errMsg.setTime( LocalDateTime.now().toString());
		errMsg.setUrl(request.getContextPath());
		return new ResponseEntity<ErrorMessage>(errMsg, HttpStatus.NOT_FOUND);
		
	}

}
