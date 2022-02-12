package com.sabeshkin;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SelectValueTest {
    @Test
    @DisplayName("Select Buzz")
    void selectValue_5_Will_Buzz() {
        assertEquals(FizzBuzz.BUZZ, FizzBuzz.selectValue(5));
    }

    @Test
    @DisplayName("Select Fizz")
    void selectValue_3_Will_Fizz() {
        assertEquals(FizzBuzz.FIZZ, FizzBuzz.selectValue(3));
    }

    @Test
    @DisplayName("Select 1")
    void selectValue_1_Will_1() {
        assertEquals("1", FizzBuzz.selectValue(1));
    }

    @Test
    @DisplayName("Select 7")
    void selectValue_7_Will_7() {
        assertEquals("7", FizzBuzz.selectValue(7));
    }

    @Test
    @DisplayName("Select FizzBuzz")
    void selectValue_15_Will_FizzBuzz() {
        assertEquals(FizzBuzz.FIZZ_BUZZ, FizzBuzz.selectValue(15));
    }
}
