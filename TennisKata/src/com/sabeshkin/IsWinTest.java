package com.sabeshkin;
import static org.junit.Assert.*;
import org.junit.Test;


public class IsWinTest {
    @Test
    public void isWinTest_False() {
        boolean isWin = Tennis.isWin(2,1);
        assertEquals(
                false,isWin);
    }

    @Test
    public void isWinTest_After_Deuce_False() {
        boolean isWin = Tennis.isWin(3,4);
        assertEquals(
                false,isWin);
    }

    @Test
    public void isWinTest_After_Several_Deuce_False() {
        boolean isWin = Tennis.isWin(5,6);
        assertEquals(
                false,isWin);
    }

    @Test
    public void isWinTest_After_Deuce_True() {
        boolean isWin = Tennis.isWin(3,5);
        assertEquals(
                true,isWin);
    }

    @Test
    public void isWinTest_Without_Deuce_True() {
        boolean isWin = Tennis.isWin(1,4);
        assertEquals(
                true,isWin);
    }

    @Test
    public void isWinTest_After_Several_Deuce_True() {
        boolean isWin = Tennis.isWin(5,7);
        assertEquals(
                true,isWin);
    }
}
