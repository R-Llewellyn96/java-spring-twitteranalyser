package com.springboot.javaspringtwitteranalyser.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Handle a not found exception, in case any resource e.g. (a table value) cannot be found,
 * Throw the exception message to a Response Entity for debugging in Postman.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends Exception{

    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(String message){
        super(message);
    }
}