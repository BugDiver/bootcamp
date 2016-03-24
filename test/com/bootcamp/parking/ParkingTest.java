package com.bootcamp.parking;

import com.bootcamp.parking.exception.NoSpaceException;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ParkingTest {
    @Test
    public void shouldBeAbleToParkACarInParkingLot() throws NoSpaceException {
        ParkingLot parkingLot = new ParkingLot(1);
        assertTrue(parkingLot.park(new Car()));
    }

    @Test
    public void shouldGiveFalseIfItCanNotParkACar() throws NoSpaceException {
        ParkingLot parkingLot = new ParkingLot(1);
        assertTrue(parkingLot.park(new Car()));
        assertFalse(parkingLot.park(new Car()));
    }
}