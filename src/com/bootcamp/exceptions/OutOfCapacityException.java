package com.bootcamp.exceptions;

public class OutOfCapacityException extends Exception {
    public OutOfCapacityException() {
        super("Can't exceed the capacity.");
    }
}
