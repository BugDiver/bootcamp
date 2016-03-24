package com.bootcamp.parking;

import com.bootcamp.parking.exception.NoSpaceException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AttendantTest {
    private Attendant attendant;
    private ParkingLot parkingLot;

    @Before
    public void setUp() throws Exception {
        attendant = new Attendant();
        parkingLot = new ParkingLot(10);
    }

    @Test
    public void shouldBeAbleToParkACar() throws NoSpaceException {
        attendant.handle(parkingLot);
        assertTrue(attendant.park(new Car()));
    }

    @Test(expected = NoSpaceException.class)
    public void shouldThrowExceptionWhenAllLotsAreFull() throws NoSpaceException {
        attendant.handle(new ParkingLot(1));
        attendant.handle(new ParkingLot(1));

        attendant.park(new Car());
        attendant.park(new Car());
        attendant.park(new Car());
    }

    @Test
    public void shouldBeAbleToHandleMoreThanOneParkingLot() {
        attendant.handle(parkingLot);
        attendant.handle(parkingLot);

        assertEquals(2, attendant.noOfParkingLots());
    }
}
