import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class RectangleTest {
    @Test
    public void calculateArea_gives_the_area_of_the_rectangle_for_integer_measurements() throws Exception {
        Rectangle plot = new Rectangle(12,4);
        double actualArea = plot.calculateArea();
        double expectedArea = 48;
        assertEquals(actualArea, expectedArea,.0);
    }

    @Test
    public void calculateArea_gives_the_area_of_the_rectangle_for_single_decimal_measurements() throws Exception {
        Rectangle plot = new Rectangle(12.4,4.5);
        double actualArea = plot.calculateArea();
        double expectedArea = 55.8;
        assertEquals(actualArea, expectedArea,.01);
    }

    @Test
    public void calculatePerimeter_gives_the_perimeter_of_the_rectangle_with_int_measurements() throws Exception {
        Rectangle plot = new Rectangle(12,4);
        double actualPerimeter = plot.calculatePerimeter();
        double expectedPerimeter = 32;
        assertEquals(actualPerimeter,expectedPerimeter,.0);
    }
    @Test
    public void calculatePerimeter_gives_the_perimeter_of_the_rectangle_for_single_decimal_measurements() throws Exception {

        Rectangle plot = new Rectangle(12.4,4.8);
        double actualPerimeter = plot.calculatePerimeter();
        double expectedPerimeter = 34.4;
        assertEquals(actualPerimeter,expectedPerimeter,.01);
    }
    @Test
    public void calculatePerimeter_gives_the_perimeter_of_the_rectangle_for_more_decimal_measurements() throws Exception {
        Rectangle plot = new Rectangle(12.44,4.89);
        double actualPerimeter = plot.calculatePerimeter();
        double expectedPerimeter = 34.66;
        assertEquals(actualPerimeter,expectedPerimeter,.001);
    }

}