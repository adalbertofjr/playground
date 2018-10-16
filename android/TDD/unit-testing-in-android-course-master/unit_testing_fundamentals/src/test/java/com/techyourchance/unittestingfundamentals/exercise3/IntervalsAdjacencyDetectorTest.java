package com.techyourchance.unittestingfundamentals.exercise3;

import com.techyourchance.unittestingfundamentals.example3.Interval;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class IntervalsAdjacencyDetectorTest {

    IntervalsAdjacencyDetector SUT;


    @Before
    public void setUp() throws Exception {
        SUT = new IntervalsAdjacencyDetector();
    }

    @Test
    public void isAdjacent_interval1ContainsInterval2_falseReturned() throws Exception {
        Interval interval1 = new Interval(1, 4);
        Interval interval2 = new Interval(3, 8);

        boolean result = SUT.isAdjacent(interval1, interval2);

        assertThat(result, is(false));
    }

    @Test
    public void isAdjacent_interval1BeforeInterval2_trueReturned() throws Exception {
        Interval interval1 = new Interval(1, 4);
        Interval interval2 = new Interval(5, 8);
        boolean result = SUT.isAdjacent(interval1, interval2);

        assertThat(result, is(true));
    }

    @Test
    public void isAdjacent_interval1AfterInterval2_falseReturned() throws Exception {
        Interval interval1 = new Interval(5, 8);
        Interval interval2 = new Interval(1, 4);
        boolean result = SUT.isAdjacent(interval1, interval2);

        assertThat(result, is(false));
    }

    @Test
    public void isAdjacent_interval1SameInterval2_falseReturned() throws Exception {
        Interval interval1 = new Interval(1, 4);
        Interval interval2 = new Interval(1, 4);
        boolean result = SUT.isAdjacent(interval1, interval2);

        assertThat(result, is(false));
    }

    @Test
    public void isAdjacent_interval1NotAdjacentInterval2_falseReturned() throws Exception {
        Interval interval1 = new Interval(1, 4);
        Interval interval2 = new Interval(6, 8);
        boolean result = SUT.isAdjacent(interval1, interval2);

        assertThat(result, is(false));
    }
}