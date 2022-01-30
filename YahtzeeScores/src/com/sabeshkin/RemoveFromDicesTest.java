package com.sabeshkin;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class RemoveFromDicesTest {
    @Test
    public void removeFromDices_6_Return_1() {
        assertArrayEquals(
                new int[]{1},
                YahtzeeCounter.removeFromDices( new int[]{6,6,1,6,6}, 6));
    }

    @Test
    public void removeFromDices_4_Return_1_2() {
        assertArrayEquals(
                new int[]{1,2},
                YahtzeeCounter.removeFromDices( new int[]{4,4,1,4,2}, 4));
    }
}
