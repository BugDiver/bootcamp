package com.bootcamp.wizards;

public class Ball {
    private Colour colour;

    public Ball(Colour colour) {

        this.colour = colour;
    }

    public boolean isColourOf(Colour colour) {
        return this.colour.equals(colour);
    }
}
