package com.retailer2customer.errorhandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomizedExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handle(Exception ex, HttpServletRequest request, HttpServletResponse response) {
        
        List<String> details = new ArrayList<>();
		details.add(ex.getLocalizedMessage());

		return ResponseEntityBuilder.build(new ApiError(LocalDateTime.now(), HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error", details));
    }

	
	@Override
	public ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex, HttpHeaders headers,
			                                                           HttpStatus status, WebRequest request) {

		List<String> details = new ArrayList<>();
		
		details.add(ex.getParameterName());

		return ResponseEntityBuilder.build(new ApiError(LocalDateTime.now(), HttpStatus.BAD_REQUEST, "Missing Parameters", details));
	}
	
	@ExceptionHandler(ArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST) 
	protected ResponseEntity<Object> handleArgumentNotValid(ArgumentNotValidException obj) {

		List<String> details = new ArrayList<>();
		details.add(obj.message);

		return ResponseEntityBuilder.build(new ApiError(LocalDateTime.now(), HttpStatus.BAD_REQUEST, "Not a valid parameter", details));
	}
	
}