/*
 * perform all methods which implies length and width of rectangle
 */

package com.bootcamp.shapes;

import com.bootcamp.exceptions.NonPositiveArgumentException;

public class Rectangle{
    private final double length;
    private final double width;

    protected Rectangle(double length, double width) {
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

    public double calculateArea() {
        return length * width;
    }

    public double calculatePerimeter() {
        return 2 * (length + width);
    }

}