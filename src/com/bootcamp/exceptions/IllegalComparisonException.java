package com.bootcamp.exceptions;

public class IllegalComparisonException extends Exception {
    public IllegalComparisonException() {
        super("Can't compare unequal units");
    }
}
