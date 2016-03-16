import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RectangleTest {
    @Test
    public void testRectangleShouldAbleToRetriveItsArea(){
        Length length = new Length(2);
        Breadth breadth = new Breadth(5);
        Rectangle rectangle = new Rectangle(length, breadth);
        assertEquals(10 ,rectangle.area());
    }

    @Test
    public void testRectangleShouldAbleToRetriveItsPerimeter(){
        Length length = new Length(2);
        Breadth breadth = new Breadth(5);
        Rectangle rectangle = new Rectangle(length, breadth);
        assertEquals(14 ,rectangle.perimeter());
    }

}
