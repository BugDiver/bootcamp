package com.bootcamp.wizards.ball;

public class Ball {

    private Colour colour;

    private Ball(Colour colour) {

        this.colour = colour;
    }

    public boolean isColourOf(Colour colour) {
        return this.colour.equals(colour);
    }

    public static Ball createGreenBall() {
        return new Ball(Colour.GREEN);
    }

    public static Ball createRedBall() {
        return new Ball(Colour.RED);
    }

    public static Ball createBlueBall() {
        return new Ball(Colour.BLUE);
    }

    public static Ball createYellowBall() {
        return new Ball(Colour.YELLOW);
    }
}
