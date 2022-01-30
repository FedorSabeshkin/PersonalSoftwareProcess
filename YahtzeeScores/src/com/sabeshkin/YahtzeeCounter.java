package com.sabeshkin;

import com.sabeshkin.Constants;

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
        switch (combination){
            case "threeOfKind":{
                return threeOfKind(dices);
            }
            case "fourOfKind":{
                return fourOfKind(dices);
            }
        }
        return 0;
    }

    /**
     * Count scores for different cases (four/three)
     * @param dices
     * @param needAmount
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
     * @param dices
     * @return count scores for four Of Kind
     */
    //TODO: заменить константу на значение из класса Constants
    public static int fourOfKind(int[] dices) {
        return needAmountOfKind(dices, 4);
    }

    /**
     * count scores for three Of Kind
     * @param dices
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
