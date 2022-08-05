package com.retailer2customer.errorhandler;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ArgumentNotValidException extends RuntimeException {
	
	final String message;

	public ArgumentNotValidException(String msg) {
		this.message=msg;
	}	

}