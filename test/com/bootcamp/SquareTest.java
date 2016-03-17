package com.bootcamp;

import com.bootcamp.exceptions.NonPositiveArgumentException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;


public class SquareTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void area_of_a_square_should_be_product_of_length_and_width_of_area() throws Exception {
        Square plot = Square.create(4);
        double actualArea = plot.calculateArea();
        double expectedArea = 16;
        assertEquals(actualArea, expectedArea, .0);
    }

    @Test
    public void perimeter_of_a_square_should_be_four_times_of_side_of_square() throws Exception {
        Square plot = Square.create(4);
        double actualPerimeter = plot.calculatePerimeter();
        double expectedPerimeter = 16;
        assertEquals(actualPerimeter, expectedPerimeter, .0);
    }

    @Test
    public void should_not_be_able_to_create_square_with_non_positive_side() throws Exception {
        thrown.expect(NonPositiveArgumentException.class);
        thrown.expectMessage("Expected positive measurements but got -10");
        Square plot = Square.create(-10);
    }
}