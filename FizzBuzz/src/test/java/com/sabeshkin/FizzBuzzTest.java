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
    @DisplayName("Check divisibility 9 by 3")
    void isThreeDivided_9_By_3_False() {
        assertEquals(true, FizzBuzz.isThreeDivided(9));
    }

    @Test
    @DisplayName("Check divisibility 5 by 3")
    void isThreeDivided_5_By_3_False() {
        assertEquals(false, FizzBuzz.isThreeDivided(5));
    }

    @Test
    @DisplayName("Check divisibility 1 by 3")
    void isThreeDivided_1_By_3_False() {
        assertEquals(false, FizzBuzz.isThreeDivided(1));
    }

    @Test
    @DisplayName("Divisibility 1 by 3 and 5")
    void isThreeAndFiveDivided_1_By_3_And_5_False() {
        assertEquals(false, FizzBuzz.isThreeAndFiveDivided(1));
    }

    @Test
    @DisplayName("Divisibility 9 by 3 and 5")
    void isThreeAndFiveDivided_9_By_3_And_5_False() {
        assertEquals(false, FizzBuzz.isThreeAndFiveDivided(9));
    }

    @Test
    @DisplayName("Divisibility 15 by 3 and 5")
    void isThreeAndFiveDivided_15_By_3_And_5_False() {
        assertEquals(true, FizzBuzz.isThreeAndFiveDivided(15));
    }

    @Test
    @DisplayName("Divisibility 50 by 3 and 5")
    void isThreeAndFiveDivided_50_By_3_And_5_False() {
        assertEquals(false, FizzBuzz.isThreeAndFiveDivided(50));
    }

    @Test
    @DisplayName("Check Entirely Divide dividend by 3")
    void isEntirelyDivided_12_By_3_True() {
        assertEquals(true, FizzBuzz.isEntirelyDivided(FizzBuzz.THREE, 12));
    }


}