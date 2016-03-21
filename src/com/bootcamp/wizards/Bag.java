package com.bootcamp.wizards;

import com.bootcamp.exceptions.BrokenRulesException;

import java.util.ArrayList;
import java.util.HashMap;

public class Bag {
    private final ArrayList<Ball> balls;
    private final int maxSize;

    public Bag(int size) {
        this.maxSize = size;
        this.balls = new ArrayList<>(size);
    }


    public boolean add(Ball ball) throws BrokenRulesException {
        if (!isSafeToAdd(ball))
            throw new BrokenRulesException();
        this.balls.add(ball);
        return true;
    }

    private boolean isSafeToAdd(Ball ball) {
        return isVacant() && isAddable(ball) ;

    }

    private boolean isAddable(Ball ball) {
        HashMap<Colour,Integer> maxLengths= new HashMap<>(3);
        maxLengths.put(Colour.GREEN ,3);
        maxLengths.put(Colour.RED ,ballsOfColour(Colour.GREEN)-1);
        maxLengths.put(Colour.BLUE ,this.maxSize);
        return ballsOfColour(colourOf(ball)) < maxLengths.get(colourOf(ball));
    }

    private int ballsOfColour(Colour colourToCount) {
        int count = 0;
        for (Ball ball: this.balls) {
            if(ball.isColourOf(colourToCount))
                count++;
        }
        return count;
    }

    private Colour colourOf(Ball ball) {
        for (Colour colour:Colour.values()) {
            if (ball.isColourOf(colour))
                return colour;
        }
        return null;
    }


    private boolean isVacant() {
        return this.balls.size() < maxSize;
    }
}
