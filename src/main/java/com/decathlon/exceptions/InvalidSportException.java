package com.decathlon.exceptions;

public class InvalidSportException extends RuntimeException {
    public InvalidSportException(String message) {
        super(message);
    }
}
