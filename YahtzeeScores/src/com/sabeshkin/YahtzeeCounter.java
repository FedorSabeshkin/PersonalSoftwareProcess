package com.sabeshkin;
import com.sabeshkin.Constants;
public class YahtzeeCounter {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    public static int count(String combination, int[] dices) {
        if(Constants.combination.containsKey(combination)){
            int amountOfMatch = countMatch(Constants.combination.get(combination), dices);
            return amountOfMatch * Constants.combination.get(combination);
        }
        return 0;
    }

    /**
     * Count max matches any dices in combination
     * @param dices combination
     * @return max matches amount any dices in combination
     */
    public static int maxAmountMatches(int[] dices){
        int maxAmountOfMatch = 0;
        // переписать на stream
        for(int i = 1; i<=Constants.maxDice; i++){
            int amountOfMatch = countMatch(i, dices);
            boolean isNextMax = amountOfMatch>=maxAmountOfMatch;
            maxAmountOfMatch = isNextMax ? amountOfMatch : maxAmountOfMatch;
        }
        return maxAmountOfMatch;
    }

    /**
     * Count values in array, which match with pattern
     * @param pattern  number for match
     * @param dices combination of dices
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
}
