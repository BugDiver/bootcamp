package com.bootcamp.parking;

import com.bootcamp.parking.exception.NoSpaceException;

import java.util.ArrayList;

/*
    job:- Attendant handles multiple parking lots
          Attendant parks a car in parking lot
 */

public class Attendant {
    private final ArrayList<ParkingLot> parkingLots;

    public Attendant() {
        this.parkingLots = new ArrayList<>();
    }

    public boolean handle(ParkingLot lot){
        return parkingLots.add(lot);
    }

    public int noOfParkingLots() {
        return parkingLots.size();
    }


    public boolean park(Car car) throws NoSpaceException {
        ParkingLot vacantLot = getVacantLot();
        if (vacantLot == null) throw new NoSpaceException();
        return getVacantLot().park(car);
    }


    private ParkingLot getVacantLot() {
        for (ParkingLot parkingLot : parkingLots) {
            if(!parkingLot.isFull()) return parkingLot;
        }
        return null;
    }
}
