package com.iqoption.repository;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String errorMessage, Throwable e){
        super(errorMessage, e);
    }

    public NotFoundException(String message) {
        super(message);
    }
}
