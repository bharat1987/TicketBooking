package com.booking.exception;

public class InvalidDataException extends RuntimeException {
   
	private String message;
	
    public InvalidDataException(String message) {
        super(message);
        this.message = message;
    }
    
    public InvalidDataException() {
    	
    }

}
