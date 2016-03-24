package com.bootcamp.wizards.rules;

import com.bootcamp.exceptions.OutOfColourSpaceException;
import com.bootcamp.wizards.ball.Ball;
import com.bootcamp.wizards.ball.Balls;
import com.bootcamp.wizards.ball.Colour;

public class RedBallRule implements Rule {
    @Override
    public boolean canBeAdded(Ball ball, Balls balls) throws OutOfColourSpaceException {
        int greenBalls = balls.ballsOfColour(Colour.GREEN);
        int redBalls = balls.ballsOfColour(Colour.RED);
        if(ball.isColourOf(Colour.RED) && (greenBalls == 0 ||  redBalls <= (greenBalls*2) -1))
            throw new OutOfColourSpaceException(Colour.RED);
        return true;
    }
}
