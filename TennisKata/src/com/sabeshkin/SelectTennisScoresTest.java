package com.sabeshkin;
import static org.junit.Assert.*;
import org.junit.Test;

public class SelectTennisScoresTest {

    @Test
    public void selectTennisScoresTest_Love() {
        Tennis tennis = new Tennis();
        String tennisScore = tennis.selectTennisScores(0);
        assertEquals(
                "love",tennisScore);
    }

    @Test
    public void selectTennisScoresTest_Fiveteen() {
        Tennis tennis = new Tennis();
        String tennisScore = tennis.selectTennisScores(1);
        assertEquals(
                "15",tennisScore);
    }

    @Test
    public void selectTennisScoresTest_Thirty() {
        Tennis tennis = new Tennis();
        String tennisScore = tennis.selectTennisScores(2);
        assertEquals(
                "30",tennisScore);
    }

    @Test
    public void selectTennisScoresTest_Fourty() {
        Tennis tennis = new Tennis();
        String tennisScore = tennis.selectTennisScores(3);
        assertEquals(
                "40",tennisScore);
    }
}
