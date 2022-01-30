package com.sabeshkin;

import java.util.Arrays;

public class YahtzeeCounter {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    public static int count(String combination, int[] dices) {
        if (Constants.combination.containsKey(combination)) {
            int amountOfMatch = countMatch(Constants.combination.get(combination), dices);
            return amountOfMatch * Constants.combination.get(combination);
        }
        switch (combination) {
            case "threeOfKind": {
                return threeOfKind(dices);
            }
            case "fourOfKind": {
                return fourOfKind(dices);
            }
            case "fullHouse": {
                return fullHouse(dices);
            }
            case "yahtzee": {
                return yahtzee(dices);
            }
            case "chance": {
                return chance(dices);
            }
            case "smallStraight": {
                return smallStraight(dices);
            }
            case "largeStraight": {
                return largeStraight(dices);
            }
        }
        /**
         *
         * TODO: попробовать убрать это return,
         * и сузить входное название до enum, что бы точно попадало в один из switch
        */
        return 0;
    }

    public static int largeStraight(int[] dices) {
        if (countBiggerThanPrev(dices)==5) {
            return 40;
        } else {
            return 0;
        }
    }


    public static int smallStraight(int[] dices) {
        if (countBiggerThanPrev(dices)>=4) {
            return 30;
        } else {
            return 0;
        }
    }

    /**
     * Count bigger than prev elements
     * @param dices
     * @return amount bigger than prev elements
     */
    public static int countBiggerThanPrev(int[] dices) {
        int amountOfMore = 1;
        // переписать на stream
        for (int i = 1; i < dices.length; i++) {
            boolean isBigger = dices[i] > dices[i-1];
            boolean isOneDiff = (dices[i]-dices[i-1]) == 1;
            if (isBigger && isOneDiff) {
                amountOfMore++;
            }
        }
        return amountOfMore;
    }

    /**
     * Count "chance"
     * @param dices
     * @return scores for "chance"
     */
    public static int chance(int[] dices) {
        return sumOfDices(dices);
    }

    /**
     * Count full house scores
     *
     * @param dices combination of dices
     * @return scores for full house
     */
    public static int fullHouse(int[] dices) {
        for (int i = 1; i <= Constants.maxDice; i++) {
            // можно заменить на isNeedAmountOfMatch(remainDices,3)
            int amountOfMatch = countMatch(i, dices);
            if (amountOfMatch == 3) {

                int[] remainDices = removeFromDices(dices, i);
                boolean isTwoMatches = isNeedAmountOfMatch(remainDices, 2);
                if (isTwoMatches) {
                    return Constants.fullHouseScores;
                }
            }
        }
        return 0;
    }

    public static int yahtzee(int[] dices) {
        if (isNeedAmountOfMatch(dices, 5)) {
            return 50;
        } else {
            return 0;
        }
    }

    /**
     * Remove selected dice from combination of dices
     *
     * @param dices    combination of dices
     * @param diceType dice for remove
     * @return combination of dices without diceType
     */
    public static int[] removeFromDices(int[] dices, int diceType) {
        return Arrays.stream(dices).filter(dice -> dice != diceType).toArray();
    }

    /**
     * Check need amount of match
     *
     * @param dices      combination
     * @param needAmount need amount of match
     * @return reach need amount of match or not
     */
    public static boolean isNeedAmountOfMatch(int[] dices, int needAmount) {
        for (int i = 1; i <= Constants.maxDice; i++) {
            int amountOfMatch = countMatch(i, dices);
            if (amountOfMatch == needAmount) {
                return true;
            }
        }
        return false;
    }

    /**
     * Count scores for different cases (four/three)
     *
     * @param dices      combination
     * @param needAmount need amount of match
     * @return count scores for different cases (four/three)
     */
    //в идеале сюда надо передавать вторым аргументом enum, у которого строго ограничен набор значений
    //так же поможет избавиться от констант в коде
    public static int needAmountOfKind(int[] dices, int needAmount) {
        int maxAmountMatches = maxAmountMatches(dices);
        if (maxAmountMatches >= needAmount) {
            return sumOfDices(dices);
        } else {
            return 0;
        }
    }

    /**
     * count scores for four Of Kind
     *
     * @param dices combination
     * @return count scores for four Of Kind
     */
    //TODO: заменить константу на значение из класса Constants
    public static int fourOfKind(int[] dices) {
        return needAmountOfKind(dices, 4);
    }

    /**
     * count scores for three Of Kind
     *
     * @param dices combination
     * @return count scores for three Of Kind
     */
    //TODO: заменить константу на значение из класса Constants
    public static int threeOfKind(int[] dices) {
        return needAmountOfKind(dices, 3);
    }

    /**
     * Count max matches any dices in combination
     *
     * @param dices combination
     * @return max matches amount any dices in combination
     */
    public static int maxAmountMatches(int[] dices) {
        int maxAmountOfMatch = 0;
        // переписать на stream
        for (int i = 1; i <= Constants.maxDice; i++) {
            int amountOfMatch = countMatch(i, dices);
            boolean isNextMax = amountOfMatch >= maxAmountOfMatch;
            maxAmountOfMatch = isNextMax ? amountOfMatch : maxAmountOfMatch;
        }
        return maxAmountOfMatch;
    }

    /**
     * Count values in array, which match with pattern
     *
     * @param pattern number for match
     * @param dices   combination of dices
     * @return amount of match
     */
    public static int countMatch(int pattern, int[] dices) {
        int amountOfMatch = 0;
        // переписать на stream
        for (int i = 0; i < dices.length; i++) {
            if (dices[i] == pattern) {
                amountOfMatch++;
            }
        }
        return amountOfMatch;
    }

    /**
     * Sum of all dices
     *
     * @param dices
     * @return sum of all dices
     */
    public static int sumOfDices(int[] dices) {
        return Arrays.stream(dices).sum();
    }
}
