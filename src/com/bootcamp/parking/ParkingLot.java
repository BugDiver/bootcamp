package com.bootcamp.parking;

import java.util.ArrayList;

/*
    Job:- ParkingLot handles the spaces for parking cars
 */

public class ParkingLot {
    private final ArrayList<Car> space;
    private final int capacity;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.space = new ArrayList<>(capacity);
    }

    public boolean park(Car car){
        return !isFull() && this.space.add(car);
    }

    public boolean isFull() {
        return space.size() == capacity;
    }
}
