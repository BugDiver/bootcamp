import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RectangleTest {
    @Test
    public void testRectangleShouldAbleToRetriveItsArea(){
        Rectangle rectangle = new Rectangle(2,5);
        assertEquals(10 ,rectangle.area(),0.0);
    }

    @Test
    public void testRectangleShouldAbleToRetriveItsPerimeter(){
        Rectangle rectangle = new Rectangle(2,5);
        assertEquals(14 ,rectangle.perimeter(),0.0);
    }

}
