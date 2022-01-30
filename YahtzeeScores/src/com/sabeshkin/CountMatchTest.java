package com.sabeshkin;
import static org.junit.Assert.*;
import org.junit.Test;

public class CountMatchTest {

    @Test
    public void Count_Ones_3() {
        assertEquals(
                3,
                YahtzeeCounter.countMatch(1, new int[]{1,2,1,1,5}));
    }

    @Test
    public void Count_Fives_1() {
        assertEquals(
                1,
                YahtzeeCounter.countMatch(5, new int[]{1,2,1,1,5}));
    }

    @Test
    public void Count_Fives_0() {
        assertEquals(
                0,
                YahtzeeCounter.countMatch(5, new int[]{1,2,1,1,6}));
    }

    @Test
    public void Count_Threes_3() {
        assertEquals(
                3,
                YahtzeeCounter.countMatch(3, new int[]{3,3,3}));
    }
}
