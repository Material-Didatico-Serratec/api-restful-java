package org.serratec.musicmanager.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler{
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		ResponseError responseError = new ResponseError();
		responseError.setHoraErro(LocalDateTime.now());
		responseError.setErros(new ArrayList<>());
		
		for(FieldError fieldError :ex.getFieldErrors() ) {
			responseError.getErros().add(new MensagemErro(fieldError.getField(), fieldError.getDefaultMessage()));
		}
		
		
		return super.handleExceptionInternal(ex, responseError, headers, status, request);
	}

}
