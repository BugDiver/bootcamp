package com.bootcamp.exceptions;

public class NonPositiveArgumentException extends Exception {
    public NonPositiveArgumentException(double measurement){
        super("expected positive measurement but got "+measurement);
    }
}
