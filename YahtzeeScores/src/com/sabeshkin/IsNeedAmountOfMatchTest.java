package com.sabeshkin;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class IsNeedAmountOfMatchTest {
    @Test
    public void IsNeedAmountOfMatch_2_True() {
        assertTrue(YahtzeeCounter.isNeedAmountOfMatch( new int[]{4,4}, 2));
    }
}
