package com.bootcamp.wizards.rules;

import com.bootcamp.exceptions.OutOfColourSpaceException;
import com.bootcamp.wizards.ball.Ball;
import com.bootcamp.wizards.ball.Balls;
import com.bootcamp.wizards.ball.Colour;

public class GreenBallRule implements Rule {

    @Override
    public boolean canBeAdded(Ball ball, Balls balls) throws OutOfColourSpaceException {
        if(ball.isColourOf(Colour.GREEN) && balls.ballsOfColour(Colour.GREEN) == 3)
            throw new OutOfColourSpaceException(Colour.GREEN);
        return true;
    }
}
