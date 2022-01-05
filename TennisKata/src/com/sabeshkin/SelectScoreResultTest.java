package com.sabeshkin;

import static org.junit.Assert.*;

import org.junit.Test;

public class SelectScoreResultTest {

    @Test
    public void selectScoreResultTest_Love_Love() {
        Tennis tennis = new Tennis();
        String scoreResult = tennis.selectScoreResult(0,0);
        assertEquals(
                "First player: love\n" +
                        "Second player: love",
                scoreResult);
    }

    @Test
    public void selectScoreResultTest_Love_Fiveteen() {
        Tennis tennis = new Tennis();
        String scoreResult = tennis.selectScoreResult(0,1);
        assertEquals(
                "First player: love\n" +
                        "Second player: 15",
                scoreResult);
    }

    @Test
    public void selectScoreResultTest_Fiveteen_Fiveteen() {
        Tennis tennis = new Tennis();
        String scoreResult = tennis.selectScoreResult(1,1);
        assertEquals(
                "First player: 15\n" +
                        "Second player: 15",
                scoreResult);
    }

    @Test
    public void selectScoreResultTest_Fiveteen_Thrity() {
        Tennis tennis = new Tennis();
        String scoreResult = tennis.selectScoreResult(1,2);
        assertEquals(
                "First player: 15\n" +
                        "Second player: 30",
                scoreResult);
    }

    @Test
    public void selectScoreResultTest_Thrity_Thrity() {
        Tennis tennis = new Tennis();
        String scoreResult = tennis.selectScoreResult(2,2);
        assertEquals(
                "First player: 30\n" +
                        "Second player: 30",
                scoreResult);
    }

    @Test
    public void selectScoreResultTest_Fourty_Thrity() {
        Tennis tennis = new Tennis();
        String scoreResult = tennis.selectScoreResult(3,2);
        assertEquals(
                "First player: 40\n" +
                        "Second player: 30",
                scoreResult);
    }

    @Test
    public void selectScoreResultTest_Fourty_Fourty_Deuce() {
        Tennis tennis = new Tennis();
        String scoreResult = tennis.selectScoreResult(3,3);
        assertEquals(
                "Deuce",
                scoreResult);
    }



    @Test
    public void selectScoreResultTest_Second_Advantage() {
        Tennis tennis = new Tennis();
        String scoreResult = tennis.selectScoreResult(3,4);
        assertEquals(
                "Second player has an advantage.",scoreResult);
    }

    @Test
    public void selectScoreResultTest_First_Advantage() {
        Tennis tennis = new Tennis();
        String scoreResult = tennis.selectScoreResult(4,3);
        assertEquals(
                "First player has an advantage.",scoreResult);
    }

    @Test
    public void selectScoreResultTest_Win_Second() {
        Tennis tennis = new Tennis();
        String scoreResult = tennis.selectScoreResult(3,5);
        assertEquals(
                "Win Second!",scoreResult);
    }

    @Test
    public void selectScoreResultTest_Win_First() {
        Tennis tennis = new Tennis();
        String scoreResult = tennis.selectScoreResult(5,3);
        assertEquals(
                "Win First!",scoreResult);
    }

    @Test
    public void selectScoreResultTest_Deuce() {
        Tennis tennis = new Tennis();
        String scoreResult = tennis.selectScoreResult(4,4);
        assertEquals(
                "Deuce",scoreResult);
    }
}
