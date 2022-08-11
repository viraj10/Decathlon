package com.decathlon.exceptions;

public class FileWriteException extends RuntimeException {
    public FileWriteException(String message) {
        super(message);
    }
}
