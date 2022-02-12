package com.sabeshkin;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzTest {
    @Test
    @DisplayName("Check divisibility 2 by 5")
    void isFiveDivided_2_By_5_False() {
        assertEquals(false, FizzBuzz.isFiveDivided(2));
    }

    @Test
    @DisplayName("Check divisibility 5 by 5")
    void isFiveDivided_5_By_5_True() {
        assertEquals(true, FizzBuzz.isFiveDivided(5));
    }

    @Test
    @DisplayName("Check divisibility 1 by 5")
    void isFiveDivided_1_By_5_False() {
        assertEquals(false, FizzBuzz.isFiveDivided(1));
    }

    @Test
    @DisplayName("Check Entirely Divide dividend by 3")
    void isEntirelyDivided_12_By_3_True() {
        assertEquals(true, FizzBuzz.isEntirelyDivided(FizzBuzz.THREE, 12));
    }


}