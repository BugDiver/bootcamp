package com.bootcamp.exceptions;

import com.bootcamp.wizards.Colour;

public class OutOfColourSpaceException extends Exception{
    public OutOfColourSpaceException(Colour colour) {
        super("No space for "+colour.toString()+" ball.");
    }
}
