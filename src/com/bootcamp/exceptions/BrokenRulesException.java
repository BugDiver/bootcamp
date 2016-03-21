package com.bootcamp.exceptions;

public class BrokenRulesException extends Exception{
    public BrokenRulesException() {
        super("You are not supposed to break the placement rules.");
    }
}
