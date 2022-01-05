package com.sabeshkin;


import static org.junit.Assert.*;
import org.junit.Test;

public class IsDeuceTest {
    @Test
    public void isDeuce_False() {
        boolean isDeuce = Tennis.isDeuce(1,2);
        assertEquals(
                false,isDeuce);
    }

    @Test
    public void isDeuce_True() {
        boolean isDeuce = Tennis.isDeuce(1,1);
        assertEquals(
                true,isDeuce);
    }

    @Test
    public void isDeuce_False_Both_Is_More_Thousand() {
        boolean isDeuce = Tennis.isDeuce(1000,1001);
        assertEquals(
                false,isDeuce);
    }

    @Test
    public void isDeuce_True_Both_Is_More_Thousand() {
        boolean isDeuce = Tennis.isDeuce(1000,1000);
        assertEquals(
                true,isDeuce);
    }
}
