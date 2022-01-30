package com.sabeshkin;
import static org.junit.Assert.*;
import org.junit.Test;

public class FourOfKindTest {

    @Test
    public void Count_FourOfKind_0() {
        assertEquals(
                0,
                YahtzeeCounter.count("fourOfKind", new int[]{4,4,4,5,5}));
    }

    @Test
    public void Count_FourOfKind_16() {
        assertEquals(
                16,
                YahtzeeCounter.count("fourOfKind", new int[]{4,4,4,5,4}));
    }

    @Test
    public void Count_FourOfKind_32() {
        assertEquals(
                32,
                YahtzeeCounter.count("fourOfKind", new int[]{4,4,4,4,4}));
    }
}
