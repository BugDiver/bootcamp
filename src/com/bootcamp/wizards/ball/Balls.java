package com.bootcamp.wizards.ball;

import java.util.ArrayList;

public class Balls {
    private ArrayList<Ball> listOfBalls;

    public Balls() {
        this.listOfBalls = new ArrayList<>();
    }

    public void add(Ball ball) {
        listOfBalls.add(ball);
    }

    public int size() {
        return listOfBalls.size();
    }

    public int ballsOfColour(Colour colour) {
        int count = 0;
        for (Ball ball : listOfBalls) {
            if (ball.isColourOf(colour))
                count++;
        }
        return count;
    }
}
