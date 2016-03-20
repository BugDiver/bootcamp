package com.bootcamp.measurement;

import com.bootcamp.exceptions.IdiotTeacherException;
import com.bootcamp.exceptions.IllegalComparisonException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static junit.framework.TestCase.assertEquals;

public class MeasurementTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void one_feet_should_be_equalsTo_twelve_inches() throws Exception{
        Measurement feet= new Measurement(2, LengthUnit.FEET);
        Measurement inch = new Measurement(24.0 , LengthUnit.INCH);
        assertEquals(feet.compare(inch) ,true);
    }
    @Test
    public void one_inch_should_be_equalsTo_five_cm() throws Exception{
        Measurement feet= new Measurement(2, LengthUnit.INCH);
        Measurement inch = new Measurement(5 , LengthUnit.CM);
        assertEquals( true,feet.compare(inch));
    }
    @Test
    public void one_cm_should_be_equalsTo_ten_mm() throws Exception{
        Measurement feet= new Measurement(1, LengthUnit.CM);
        Measurement inch = new Measurement(10 , LengthUnit.MM);
        assertEquals( true,feet.compare(inch));
    }

    @Test
    public void one_gallon_should_be_equalsTo_three_point_seven_eight_litres() throws Exception{
        Measurement gallon= new Measurement(1, VolumeUnit.GALLON);
        Measurement  litre= new Measurement(3.78 , VolumeUnit.LITRE);
        assertEquals(true ,gallon.compare(litre));

    }

    @Test
    public void two_inch_added_with_two_inches_gives_four_inches() throws Exception{
        Measurement feet= new Measurement(2, LengthUnit.INCH);
        Measurement inch = new Measurement(2, LengthUnit.INCH);
        Measurement expected = new Measurement(4, LengthUnit.INCH);
        assertEquals(expected ,feet.add(inch));
    }

    @Test
    public void two_inch_added_with_two_and_half_cm_gives_three_inches() throws Exception{
        Measurement feet= new Measurement(2, LengthUnit.INCH);
        Measurement inch = new Measurement(2.5, LengthUnit.CM);
        Measurement expected = new Measurement(3, LengthUnit.INCH);
        assertEquals(expected ,feet.add(inch));
    }

    @Test
    public void should_throw_exception_for_unequal_units_comparison() throws Exception{
        thrown.expect(IllegalComparisonException.class);
        thrown.expectMessage("Can't compare unequal units");

        Measurement inch = new Measurement(1, LengthUnit.INCH);
        Measurement gallon = new Measurement(1, VolumeUnit.GALLON);
        inch.compare(gallon);
    }

    @Test
    public void one_gallon_added_with_one_litre_should_be_equal_to_four_point_seven_eight()throws Exception{
        Measurement gallon= new Measurement(1, VolumeUnit.GALLON);
        Measurement litre = new Measurement(1, VolumeUnit.LITRE);
        Measurement expected = new Measurement(4.78, VolumeUnit.LITRE);
        assertEquals(expected ,gallon.add(litre));
    }


    @Test
    public void should_throw_exception_for_unequal_unit_addition() throws Exception {
        thrown.expect(IdiotTeacherException.class);
        thrown.expectMessage("My Teacher is an idiot");

        Measurement inch = new Measurement(1, LengthUnit.INCH);
        Measurement gallon = new Measurement(1, VolumeUnit.GALLON);
        inch.add(gallon);
    }

}