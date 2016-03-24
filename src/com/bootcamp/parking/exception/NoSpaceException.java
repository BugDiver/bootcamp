package com.bootcamp.parking.exception;

public class NoSpaceException extends Exception {
    public NoSpaceException() {
        super("No space for parking");
    }
}
