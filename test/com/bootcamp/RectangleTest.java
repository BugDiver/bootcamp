package com.bootcamp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class RectangleTest {
    @Test
    public void area_of_a_rectangle_should_be_product_of_length_and_width_of_area() throws Exception {
        Rectangle plot = new Rectangle(12,4);
        double actualArea = plot.calculateArea();
        double expectedArea = 48;
        assertEquals(actualArea, expectedArea,.0);
    }

    @Test
    public void perimeter_of_a_rectangle_should_be_two_times_of_sum_of_length_and_width_of_rectangle() throws Exception {
        Rectangle plot = new Rectangle(12,4);
        double actualPerimeter = plot.calculatePerimeter();
        double expectedPerimeter = 32;
        assertEquals(actualPerimeter,expectedPerimeter,.0);
    }
}