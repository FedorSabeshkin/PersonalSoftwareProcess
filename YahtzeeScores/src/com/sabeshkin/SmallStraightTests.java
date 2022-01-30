package com.sabeshkin;
import static org.junit.Assert.*;
import org.junit.Test;

public class SmallStraightTests {

    @Test
    public void Count_SmallStraight_30() {
        assertEquals(
                30,
                YahtzeeCounter.count("smallStraight", new int[]{1,2,3,4,1}));
    }

    @Test
    public void Count_SmallStraight_From_Two_30() {
        assertEquals(
                30,
                YahtzeeCounter.count("smallStraight", new int[]{2,3,4,5,6}));
    }

    @Test
    public void Count_SmallStraight_0() {
        assertEquals(
                0,
                YahtzeeCounter.count("smallStraight", new int[]{1,4,3,4,1}));
    }
}
