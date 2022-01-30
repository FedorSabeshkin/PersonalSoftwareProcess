package com.sabeshkin;
import static org.junit.Assert.*;
import org.junit.Test;

public class YahtzeeTest {

    @Test
    public void Count_Yahtzee_50() {
        assertEquals(
                50,
                YahtzeeCounter.count("yahtzee", new int[]{2,2,2,2,2}));
    }

    @Test
    public void Count_Yahtzee_Last_Another_0() {
        assertEquals(
                0,
                YahtzeeCounter.count("yahtzee", new int[]{2,2,2,2,1}));
    }

    @Test
    public void Count_Yahtzee_First_Another_0() {
        assertEquals(
                0,
                YahtzeeCounter.count("yahtzee", new int[]{1,2,2,2,2}));
    }

}
