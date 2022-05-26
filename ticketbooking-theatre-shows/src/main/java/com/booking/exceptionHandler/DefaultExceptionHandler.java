package com.booking.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.booking.exception.InvalidDataException;

@ControllerAdvice
public class DefaultExceptionHandler {
	
	@ExceptionHandler(value=InvalidDataException.class)
    public ResponseEntity blogNotFoundException(InvalidDataException invalidException) {
        return new ResponseEntity("Invalid Data Exception. "+ invalidException.getMessage(), HttpStatus.BAD_REQUEST);
    }
   
	@ExceptionHandler(value = Exception.class)
    public ResponseEntity databaseConnectionFailsException(Exception exception) {
        return new ResponseEntity("Something Failed in Application. "+exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
	
}
