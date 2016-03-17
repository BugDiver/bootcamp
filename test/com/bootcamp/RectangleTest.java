package com.bootcamp;

import com.bootcamp.exceptions.NonPositiveArgumentException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;


public class RectangleTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void area_of_a_rectangle_should_be_product_of_length_and_width_of_area() throws Exception {
        Rectangle plot = Rectangle.create(12,4);
        double actualArea = plot.calculateArea();
        double expectedArea = 48;
        assertEquals(actualArea, expectedArea,.0);
    }

    @Test
    public void perimeter_of_a_rectangle_should_be_two_times_of_sum_of_length_and_width_of_rectangle() throws Exception {
        Rectangle plot = Rectangle.create(12,4);
        double actualPerimeter = plot.calculatePerimeter();
        double expectedPerimeter = 32;
        assertEquals(actualPerimeter,expectedPerimeter,.0);
    }

    @Test
    public void should_not_be_able_to_create_rectangle_with_non_positive_length() throws Exception {
        thrown.expect(NonPositiveArgumentException.class);
        thrown.expectMessage("Expected positive measurements but got -10");
        Rectangle plot = Rectangle.create(-10, 4);
    }

    @Test
    public void should_not_be_able_to_create_rectangle_with_non_positive_width() throws Exception {
        thrown.expect(NonPositiveArgumentException.class);
        thrown.expectMessage("Expected positive measurements but got -4");
        Rectangle plot2 = Rectangle.create(10, -4);
    }
}