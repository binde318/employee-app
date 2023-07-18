package com.bindecode.binde.exception;

public class EmployeeAlreadyExistException extends RuntimeException{
    public EmployeeAlreadyExistException(String message) {
        super(message);
    }
}
