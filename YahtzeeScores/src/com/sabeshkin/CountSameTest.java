package com.sabeshkin;
import static org.junit.Assert.*;
import org.junit.Test;

public class CountSameTest {

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
}
