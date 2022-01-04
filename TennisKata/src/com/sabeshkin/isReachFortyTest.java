package com.sabeshkin;


import static org.junit.Assert.*;
import org.junit.Test;

public class isReachFortyTest {
    @Test
    public void isReachForty_False() {
        boolean isReachForty = Tennis.isReachForty(1,1);
        assertEquals(
                false,isReachForty);
    }

    @Test
    public void isReachForty_True() {
        boolean isReachForty = Tennis.isReachForty(3,1);
        assertEquals(
                true,isReachForty);
    }

    @Test
    public void isReachForty_True_Both() {
        boolean isReachForty = Tennis.isReachForty(3,3);
        assertEquals(
                true,isReachForty);
    }

    @Test
    public void isReachForty_True_Both_Is_Thousand() {
        boolean isReachForty = Tennis.isReachForty(1000,1001);
        assertEquals(
                true,isReachForty);
    }
}
