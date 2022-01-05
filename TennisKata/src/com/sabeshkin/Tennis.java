package com.sabeshkin;

import java.util.HashMap;
import java.util.Map;

public class Tennis {

    private final static int scoreForEnd = 3;
    private Map<Integer, String> scoreAliases = new HashMap<>();

    public Tennis() {
        scoreAliases.put(0, "love");
        scoreAliases.put(1, "15");
        scoreAliases.put(2, "30");
        scoreAliases.put(3, "40");
    }

    public static void main(String[] args) {
        Tennis tennis = new Tennis();
        tennis.printScoreResult(3,5);
    }

    /**
     * select Score Result in tennis system
     * @param firstScore
     * @param secondScore
     * @return formated score result string
     */
    public String selectScoreResult(int firstScore, int secondScore) {

        boolean isReachForty = isReachForty(firstScore, secondScore);
        if (isReachForty) {
            boolean isWin = isWin(firstScore, secondScore);
            if (isWin) {
                return selectWinnerPlayerName(firstScore, secondScore);
            } else {
                boolean isDeuce = isDeuce(firstScore, secondScore);
                if(isDeuce){
                    return selectDeuce();
                }else{
                    boolean isMoreForty = isMoreForty(firstScore, secondScore);
                    if(isMoreForty){
                        return selectLeadingPlayerName(firstScore, secondScore);
                    }else{
                        return selectTennisScores(firstScore, secondScore);
                    }
                }
            }
        } else {
            return selectTennisScores(firstScore, secondScore);
        }
    }


    /**
     * Print game scores in tennis system to terminal.
     * @param firstScore
     * @param secondScore
     */
    public void printScoreResult(int firstScore, int secondScore) {
        String scoreResult = selectScoreResult(firstScore, secondScore);
        println(scoreResult);
    }

    /**
     * Select "name" leading player
     * @param firstScore
     * @param secondScore
     * @return name of leading player
     */
    public static String selectLeadingName(int firstScore, int secondScore) {
        if (firstScore > secondScore) {
            return "First";
        } else {
            return "Second";
        }
    }


    /**
     *
     * @param score
     * @return score in tennis system
     */
    public String selectTennisScores(int score) {
        return scoreAliases.get(score);
    }

    /**
     * somebady win or not
     * @param firstScore
     * @param secondScore
     * @return
     */
    public static boolean isWin(int firstScore, int secondScore) {
        int scoreDifferent = Math.abs(firstScore - secondScore);
        if (scoreDifferent >= 2) {
            return true;
        } else {
            return false;
        }
    }


    /**
     * Check what somebady already have 40 scores
     * @param firstScore
     * @param secondScore
     * @return
     */
    public static boolean isReachForty(int firstScore, int secondScore) {
        if (firstScore >= scoreForEnd || secondScore >= scoreForEnd) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Check what somebady already have <b>more</b> than 40 scores
     * @param firstScore
     * @param secondScore
     * @return
     */
    public static boolean isMoreForty(int firstScore, int secondScore) {
        if (firstScore > scoreForEnd || secondScore > scoreForEnd) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Check deuce case. We should check isReachForty early.
     * @param firstScore
     * @param secondScore
     * @return
     */
    public static boolean isDeuce(int firstScore, int secondScore) {
        if (firstScore == secondScore) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Aliase for println function. Print line to terminal.
     * @param message
     */
    public static void println(String message) {
        System.out.println(message);
    }



    public String selectWinnerPlayerName(int firstScore, int secondScore) {
        String leadingName = selectLeadingName(firstScore, secondScore);
        return "Win " + leadingName + "!";

    }

    public String selectDeuce() {
        return "Deuce";
    }

    public String selectLeadingPlayerName(int firstScore, int secondScore) {
        String leadingName = selectLeadingName(firstScore, secondScore);
        return leadingName + " player has an advantage.";
    }

    public String selectTennisScores(int firstScore, int secondScore) {
        String tennisScore = selectTennisScores(firstScore);
        String scoreResult = "First player: " + tennisScore + "\n";
        tennisScore = selectTennisScores(secondScore);
        scoreResult += "Second player: " + tennisScore;
        return scoreResult;
    }

}
