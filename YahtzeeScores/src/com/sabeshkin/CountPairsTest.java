package com.sabeshkin;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CountPairsTest {
    @Test
    public void MaxAmountDuplicates_3() {
        assertEquals(
                3,
                YahtzeeCounter.maxAmountMatches( new int[]{1,2,1,1,5}));
    }

    @Test
    public void MaxAmountDuplicates_5() {
        assertEquals(
                5,
                YahtzeeCounter.maxAmountMatches( new int[]{1,1,1,1,1}));
    }

    @Test
    public void MaxAmountDuplicates_1() {
        assertEquals(
                1,
                YahtzeeCounter.maxAmountMatches( new int[]{1,2,3,4,5}));
    }

    @Test
    public void MaxAmountDuplicates_4() {
        assertEquals(
                4,
                YahtzeeCounter.maxAmountMatches( new int[]{4,4,3,4,4}));
    }
}
