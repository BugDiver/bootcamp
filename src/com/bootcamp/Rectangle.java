/*
 * perform all methods which implies length and width of rectangle
 */


package com.bootcamp;

import com.bootcamp.exceptions.NonPositiveArgumentException;

public class Rectangle implements Shape {
    private final double length;
    private final double width;

    private Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public static Rectangle create(double length, double width) throws NonPositiveArgumentException {
        if(length<1||width<1){
            double nonPositive = (length < 1) ? length : width;
            throw new NonPositiveArgumentException(nonPositive);
        }
        return new Rectangle(length,width);
    }

    @Override
    public double calculateArea() {
        return length * width;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (length + width);
    }

}