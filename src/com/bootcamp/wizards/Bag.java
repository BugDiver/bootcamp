package com.bootcamp.wizards;

import com.bootcamp.exceptions.OutOfCapacityException;
import com.bootcamp.exceptions.OutOfColourSpaceException;
import com.bootcamp.wizards.ball.Ball;
import com.bootcamp.wizards.ball.Balls;
import com.bootcamp.wizards.rules.Rules;

public class Bag {
    private final int capacity;
    private Balls balls;
    private Rules rules;

    public Bag(int capacity ,Rules rules) {
        this.capacity = capacity;
        this.rules = rules;
        this.balls = new Balls();
    }


    public int add(Ball ball) throws OutOfCapacityException, OutOfColourSpaceException {
        if (isFull())
            throw new OutOfCapacityException();
        rules.canBeAdded(ball ,balls);
        this.balls.add(ball);
        return balls.size();
    }

    private boolean isFull() {
        return this.balls.size() == capacity;
    }
}
