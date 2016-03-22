package com.bootcamp.wizards;

import com.bootcamp.exceptions.OutOfColourSpaceException;
import com.bootcamp.exceptions.OutOfCapacityException;

import java.util.ArrayList;
import java.util.HashMap;

public class Bag {
    private final ArrayList<Ball> balls;
    private final int capacity;

    public Bag(int capacity) {
        this.capacity = capacity;
        this.balls = new ArrayList<>(capacity);
    }


    public int add(Ball ball) throws OutOfCapacityException,OutOfColourSpaceException {
        if (!isVacant())
            throw new OutOfCapacityException();
        if(!isAddable(ball))
            throw new OutOfColourSpaceException(colourOf(ball));
        this.balls.add(ball);
        return balls.size();
    }

    private boolean isAddable(Ball ball) {
        HashMap<Colour,Integer> maxLengths= new HashMap<>(4);
        maxLengths.put(Colour.GREEN ,3);
        maxLengths.put(Colour.RED ,2*ballsOfColour(Colour.GREEN)-1);
        maxLengths.put(Colour.BLUE ,capacity);
        maxLengths.put(Colour.YELLOW ,(balls.size() * 4)/10);
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
        return this.balls.size() < capacity;
    }

    public String overview() {
        StringBuilder sb = new StringBuilder("Bag : ").append(balls.size()).append(" balls").append("\n");
        for (Colour colour:Colour.values()) {
            if(ballsOfColour(colour) >0)
                sb.append(colour.toString()).append(" : ").append(ballsOfColour(colour)).append("\n");
        }
        return sb.toString().trim();
    }

    public String summary() {
        Colour prevColour = colourOf(balls.get(0));
        Integer count = 0;
        StringBuilder sb = new StringBuilder("Bag : ").append(balls.size()).append(" balls").append("\n");
        for (Ball ball:balls) {
            if(prevColour.equals(colourOf(ball)))
                count++;
            else{
                sb.append(count.toString()).append(prevColour.toString().charAt(0)).append(" ");
                prevColour = colourOf(ball);
                count = 1;
            }
        }
        sb.append(count.toString()).append(prevColour.toString().charAt(0)).append(" ");
        return sb.toString().trim();
    }
}
