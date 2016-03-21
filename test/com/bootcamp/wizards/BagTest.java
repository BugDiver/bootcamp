package com.bootcamp.wizards;

import com.bootcamp.exceptions.BrokenRulesException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class BagTest {
    @Rule
    public ExpectedException thrown  = ExpectedException.none();

    @Test
    public void bag_should_be_able_to_add_a_ball_in_it() throws Exception {
        Bag bag= new Bag(2);
        Ball ball = new Ball(Colour.GREEN);
        assertEquals( true,bag.add(ball));
    }

    @Test
    public void should_throw_exception_in_condition_to_add_ball_out_of_size() throws Exception{
        thrown.expect(BrokenRulesException.class);
        thrown.expectMessage("You are not supposed to break the placement rules.");
        Bag bag = new Bag(1);
        Ball greenBall1 = new Ball(Colour.GREEN);
        Ball greenBall2 = new Ball(Colour.GREEN);
        bag.add(greenBall1);
        bag.add(greenBall2);

    }

    @Test
    public void should_throw_exception_in_addition_of_more_than_three_green_balls() throws Exception{
        thrown.expect(BrokenRulesException.class);
        thrown.expectMessage("You are not supposed to break the placement rules.");
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
        thrown.expect(BrokenRulesException.class);
        thrown.expectMessage("You are not supposed to break the placement rules.");
        Bag bag = new Bag(12);

        Ball redBall1 = new Ball(Colour.RED);
        bag.add(redBall1);
    }

    @Test
    public void should_throw_exception_in_addition_of_red_balls_more_than_double_of_green() throws Exception{
        thrown.expect(BrokenRulesException.class);
        thrown.expectMessage("You are not supposed to break the placement rules.");
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
        assertEquals( true ,bag.add(new Ball(Colour.BLUE)));
    }
}
