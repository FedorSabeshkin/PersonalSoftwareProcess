package com.sabeshkin;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ChanceTest {
    @Test
    public void Count_Chance_5() {
        assertEquals(
                5,
                YahtzeeCounter.count("chance", new int[]{1,1,1,1,1}));
    }
}
