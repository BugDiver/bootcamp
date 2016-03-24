package com.bootcamp.wizards;

import com.bootcamp.exceptions.OutOfCapacityException;
import com.bootcamp.exceptions.OutOfColourSpaceException;
import com.bootcamp.wizards.ball.Ball;
import com.bootcamp.wizards.rules.GreenBallRule;
import com.bootcamp.wizards.rules.RedBallRule;
import com.bootcamp.wizards.rules.Rules;
import com.bootcamp.wizards.rules.YellowBallRule;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class BagTest {
    private Rules rules;

    @Before
    public void setUp() throws Exception {
       rules = new Rules();
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void bag_should_be_able_to_add_a_ball_in_it() throws Exception {
        rules.add(new GreenBallRule());
        Bag bag = new Bag(1 ,rules);
        assertEquals(1, bag.add(Ball.createGreenBall()));
    }

    @Test
    public void should_throw_exception_in_condition_to_add_ball_out_of_size() throws Exception {
        thrown.expect(OutOfCapacityException.class);
        thrown.expectMessage("Can't exceed the capacity.");
        Bag bag = new Bag(0 ,rules);
        bag.add(Ball.createGreenBall());

    }

    @Test
    public void should_throw_exception_in_addition_of_more_than_three_green_balls() throws Exception {
        thrown.expect(OutOfColourSpaceException.class);
        thrown.expectMessage("No space for GREEN ball.");

        rules.add(new GreenBallRule());
        Bag bag = new Bag(12 ,rules);

        bag.add(Ball.createGreenBall());
        bag.add(Ball.createGreenBall());
        bag.add(Ball.createGreenBall());
        bag.add(Ball.createGreenBall());

    }

    @Test
    public void should_throw_exception_in_addition_of_red_ball_if_no_any_green_ball_exist_in_bag() throws Exception {
        thrown.expect(OutOfColourSpaceException.class);
        thrown.expectMessage("No space for RED ball.");

        rules.add(new RedBallRule());
        Bag bag = new Bag(12, rules);
        bag.add(Ball.createRedBall());
    }

    @Test
    public void should_throw_exception_in_addition_of_red_balls_more_than_double_of_green() throws Exception {
        thrown.expect(OutOfColourSpaceException.class);
        thrown.expectMessage("No space for RED ball.");
        rules.add(new RedBallRule());

        Bag bag = new Bag(12 ,rules);

        bag.add(Ball.createGreenBall());
        bag.add(Ball.createRedBall());
        bag.add(Ball.createRedBall());

    }

    @Test
    public void should_allow_to_add_as_many_blue_balls_as_the_size_of_bag() throws Exception {
        Bag bag = new Bag(3 ,rules);
        bag.add(Ball.createBlueBall());
        bag.add(Ball.createBlueBall());

        assertEquals(3,bag.add(Ball.createBlueBall()));
    }


    @Test
    public void should_throw_exception_in_addition_of_yellow_balls_if_there_is_no_any_balls() throws Exception {
        thrown.expect(OutOfColourSpaceException.class);
        thrown.expectMessage("No space for YELLOW ball.");
        rules.add(new YellowBallRule());
        Bag bag = new Bag(12 ,rules);
        bag.add(Ball.createYellowBall());
    }

    @Test
    public void should_allow_to_put_yellow_balls_only_40_percent_of_total_balls() throws Exception {
        rules.add(new YellowBallRule());
        Bag bag = new Bag(6 ,rules);

        bag.add(Ball.createGreenBall());
        bag.add(Ball.createGreenBall());
        bag.add(Ball.createGreenBall());
        bag.add(Ball.createRedBall());

        assertEquals(5, bag.add(Ball.createYellowBall()));
    }

}
