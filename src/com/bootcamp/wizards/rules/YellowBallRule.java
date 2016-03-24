package com.bootcamp.wizards.rules;

import com.bootcamp.exceptions.OutOfColourSpaceException;
import com.bootcamp.wizards.ball.Ball;
import com.bootcamp.wizards.ball.Balls;
import com.bootcamp.wizards.ball.Colour;

public class YellowBallRule implements Rule {
    @Override
    public boolean canBeAdded(Ball ball, Balls balls) throws OutOfColourSpaceException {
        if(ball.isColourOf(Colour.YELLOW) && balls.ballsOfColour(Colour.YELLOW) >= balls.size()*0.4)
            throw new OutOfColourSpaceException(Colour.YELLOW);
        return true;
    }
}
