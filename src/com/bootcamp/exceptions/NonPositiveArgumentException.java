package com.bootcamp.exceptions;

public class NonPositiveArgumentException extends Exception {
    public NonPositiveArgumentException(double measurement){
        super("Expected positive measurements but got "+measurement);
    }
}
