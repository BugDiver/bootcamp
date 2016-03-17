package com.bootcamp;

import com.bootcamp.exceptions.NonPositiveArgumentException;

/**
 * job of Square:-
 *      perform all methods which implies side of square
 */

public class Square extends Rectangle {

    private Square(double side) {
        super(side ,side);
    }

    public static Square create(double side) throws NonPositiveArgumentException {
        if (side < 1) {
            throw new NonPositiveArgumentException(side);
        }
        return new Square(side);
    }
}
