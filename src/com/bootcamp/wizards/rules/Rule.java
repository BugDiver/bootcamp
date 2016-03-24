package com.bootcamp.wizards.rules;

import com.bootcamp.exceptions.OutOfColourSpaceException;
import com.bootcamp.wizards.ball.Ball;
import com.bootcamp.wizards.ball.Balls;

public interface Rule {
    boolean canBeAdded(Ball ball, Balls balls) throws OutOfColourSpaceException;
}
