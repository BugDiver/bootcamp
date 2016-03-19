package com.bootcamp.measurement;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;


public class MeasurementTest {
    @Test
    public void one_feet_should_be_equalsTo_twelve_inches() throws Exception {
        Measurement length= new Measurement(1, Length.FEET);
        Measurement width = new Measurement(12.0 ,Length.INCH);
        assertEquals(length ,width);
    }
    @Test
    public void one_inch_should_be_equalsTo_five_cm() throws Exception {
        Measurement length= new Measurement(2, Length.INCH);
        Measurement width = new Measurement(5 ,Length.CM);
        assertEquals(length,width);
    }
    @Test
    public void one_cm_should_be_equalsTo_ten_mm() throws Exception {
        Measurement length= new Measurement(1, Length.CM);
        Measurement width = new Measurement(10 ,Length.MM);
        assertEquals(length,width);
    }

    @Test
    public void one_gallon_should_be_equalsTo_three_point_seven_eight_litres() throws Exception {
        Measurement gallon= new Measurement(1,Volume.GALLON);
        Measurement  litre= new Measurement(3.78 ,Volume.LITRE);
        assertEquals(gallon ,litre);

    }

    @Test
    public void two_inch_added_with_two_inches_gives_four_inches() throws Exception {
        Measurement length= new Measurement(2, Length.INCH);
        Measurement width = new Measurement(2,Length.INCH);
        Measurement expected = new Measurement(4,Length.INCH);
        assertEquals(expected ,length.add(width));
    }

    @Test
    public void two_inch_added_with_two_and_half_cm_gives_three_inches() throws Exception {
        Measurement length= new Measurement(2, Length.INCH);
        Measurement width = new Measurement(2.5,Length.CM);
        Measurement expected = new Measurement(3,Length.INCH);
        assertEquals(expected ,length.add(width));
    }
}
