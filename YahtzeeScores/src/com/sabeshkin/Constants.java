package com.sabeshkin;

import java.util.HashMap;

public class Constants {
    final public static HashMap<String, Integer> combination = new HashMap<String, Integer>();

    static {
        combination.put("ones", 1);
        combination.put("twos", 2);
        combination.put("threes", 3);
        combination.put("fours", 4);
        combination.put("fives", 5);
        combination.put("sixes", 6);
    }

    final public static int maxDice = 6;
}
