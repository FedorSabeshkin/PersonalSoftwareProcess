package com.sabeshkin;

import java.util.HashMap;
import java.util.Map;

public class Tennis {

    private final static int scoreForEnd = 3;
    private static String message = "none";
    private  Map<Integer, String> scoreAliases = new HashMap<>();

    public Tennis() {
        scoreAliases.put(0, "love");
        scoreAliases.put(1, "15");
        scoreAliases.put(2, "30");
        scoreAliases.put(3, "40");
    }

    public static void main(String[] args) {
        if (isNotEqualsScore(3, 4)) {
            message = selectLeadingName(3, 4);
        } else {
            message = "Equals score";
        }
        //print();
        // write your code here
    }

    public static String selectLeadingName(int firstScore, int secondScore) {
        if (firstScore > secondScore) {
            return "First player has an advantage";
        } else {
            return "Second player has an advantage";
        }
    }

    public static boolean isNotEqualsScore(int firstScore, int secondScore) {
        if (firstScore != secondScore) {
            return true;
        } else {
            return false;
        }
    }

    public  String selectTennisScores(int score) {
        return scoreAliases.get(score);
    }

    public static boolean isWin(int firstScore, int secondScore) {
        if (isReachForty(firstScore, secondScore)) {
            if (!isDeuce(firstScore, secondScore)) {
                return isEnoughScoreDiff(firstScore, secondScore);
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public static boolean isEnoughScoreDiff(int firstScore, int secondScore) {
        int scoreDifferent = Math.abs(firstScore - secondScore);
        if (scoreDifferent >= 2) {
            return true;
        } else {
            return false;
        }
    }


    public static void println(String message) {
        System.out.println(message);
    }


    public static boolean isReachForty(int firstScore, int secondScore) {
        if (firstScore >= scoreForEnd || secondScore >= scoreForEnd) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isDeuce(int firstScore, int secondScore) {
        if (firstScore == secondScore) {
            return true;
        } else {
            return false;
        }
    }
}
