package com.bootcamp.wizards;

import com.bootcamp.exceptions.OutOfColourSpaceException;
import com.bootcamp.exceptions.OutOfCapacityException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class BagTest {
    @Rule
    public ExpectedException thrown  = ExpectedException.none();

    @Test
    public void bag_should_be_able_to_add_a_ball_in_it() throws Exception {
        Bag bag= new Bag(1);
        Ball ball = new Ball(Colour.GREEN);
        assertEquals( 1,bag.add(ball));
    }

    @Test
    public void should_throw_exception_in_condition_to_add_ball_out_of_size() throws Exception{
        thrown.expect(OutOfCapacityException.class);
        thrown.expectMessage("Can't exceed the capacity.");
        Bag bag = new Bag(0);

        bag.add(new Ball(Colour.GREEN));

    }

    @Test
    public void should_throw_exception_in_addition_of_more_than_three_green_balls() throws Exception{
        thrown.expect(OutOfColourSpaceException.class);
        thrown.expectMessage("No space for GREEN ball.");
        Bag bag = new Bag(12);

        Ball greenBall1 = new Ball(Colour.GREEN);
        Ball greenBall2 = new Ball(Colour.GREEN);
        Ball greenBall3 = new Ball(Colour.GREEN);
        Ball greenBall4 = new Ball(Colour.GREEN);

        bag.add(greenBall1);
        bag.add(greenBall2);
        bag.add(greenBall3);
        bag.add(greenBall4);

    }
    @Test
    public void should_throw_exception_in_addition_of_red_ball_if_no_any_green_ball_exist_in_bag() throws Exception{
        thrown.expect(OutOfColourSpaceException.class);
        thrown.expectMessage("No space for RED ball.");
        Bag bag = new Bag(12);

        Ball redBall1 = new Ball(Colour.RED);
        bag.add(redBall1);
    }

    @Test
    public void should_throw_exception_in_addition_of_red_balls_more_than_double_of_green() throws Exception{
        thrown.expect(OutOfColourSpaceException.class);
        thrown.expectMessage("No space for RED ball.");
        Bag bag = new Bag(12);

        bag.add(new Ball(Colour.GREEN));

        bag.add(new Ball(Colour.RED));
        bag.add(new Ball(Colour.RED));

    }

    @Test
    public void should_allow_to_add_as_many_blue_balls_as_the_size_of_bag() throws Exception {
        Bag bag = new Bag(3);

        bag.add(new Ball(Colour.BLUE));
        bag.add(new Ball(Colour.BLUE));

        assertEquals( 3 ,bag.add(new Ball(Colour.BLUE)));
    }


    @Test
    public void should_throw_exception_in_addition_of_yellow_balls_if_there_is_no_any_balls() throws Exception{
        thrown.expect(OutOfColourSpaceException.class);
        thrown.expectMessage("No space for YELLOW ball.");

        Bag bag = new Bag(12);
        bag.add(new Ball(Colour.YELLOW));
    }

    @Test
    public void should_allow_to_put_yellow_balls_only_40_percent_of_total_balls() throws Exception {
        Bag bag = new Bag(6);

        bag.add(new Ball(Colour.GREEN));
        bag.add(new Ball(Colour.GREEN));
        bag.add(new Ball(Colour.GREEN));
        bag.add(new Ball(Colour.RED));

        assertEquals( 5 ,bag.add(new Ball(Colour.YELLOW)));
    }
    @Test
    public void should_give_a_overview_of_balls_in_bag() throws Exception{
        Bag bag = new Bag(12);

        bag.add(new Ball(Colour.GREEN));
        bag.add(new Ball(Colour.GREEN));
        bag.add(new Ball(Colour.GREEN));
        bag.add(new Ball(Colour.BLUE));
        bag.add(new Ball(Colour.BLUE));
        bag.add(new Ball(Colour.RED));
        bag.add(new Ball(Colour.RED));
        bag.add(new Ball(Colour.RED));
        bag.add(new Ball(Colour.RED));
        bag.add(new Ball(Colour.BLUE));
        bag.add(new Ball(Colour.BLUE));
        bag.add(new Ball(Colour.BLUE));

        String expected = "Bag : 12 balls\n" +
                          "GREEN : 3\n" +
                          "RED : 4\n" +
                          "BLUE : 5";
        assertEquals(expected ,bag.overview());
    }

    @Test
    public void should_give_a_summary_of__balls_in_bag() throws Exception {

        Bag bag = new Bag(12);
        bag.add(new Ball(Colour.GREEN));
        bag.add(new Ball(Colour.GREEN));
        bag.add(new Ball(Colour.GREEN));
        bag.add(new Ball(Colour.BLUE));
        bag.add(new Ball(Colour.BLUE));
        bag.add(new Ball(Colour.RED));
        bag.add(new Ball(Colour.RED));
        bag.add(new Ball(Colour.RED));
        bag.add(new Ball(Colour.RED));
        bag.add(new Ball(Colour.BLUE));
        bag.add(new Ball(Colour.BLUE));
        bag.add(new Ball(Colour.BLUE));

        String expected = "Bag : 12 balls\n" +
                          "3G 2B 4R 3B";
        assertEquals(expected , bag.summary());

    }
}
