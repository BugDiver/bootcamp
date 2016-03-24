package com.bootcamp.wizards.rules;

import com.bootcamp.exceptions.OutOfColourSpaceException;
import com.bootcamp.wizards.ball.Ball;
import com.bootcamp.wizards.ball.Balls;

import java.util.ArrayList;

public class Rules {
    private final ArrayList<Rule> listOfRules = new ArrayList<Rule>();

    public boolean canBeAdded(Ball ball , Balls balls) throws OutOfColourSpaceException {
        for (Rule rule : listOfRules) {
            rule.canBeAdded(ball, balls);
        }
        return true;
    }

    public boolean add(Rule rule) {
        return listOfRules.add(rule);
    }
}