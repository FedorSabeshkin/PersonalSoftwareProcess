package com.sabeshkin;

import java.util.stream.IntStream;

public class FizzBuzz {
    public static final int FIVE = 5;
    public static final int THREE = 3;
    public static final String BUZZ = "Buzz";
    public static final String FIZZ = "Fizz";
    public static final String FIZZ_BUZZ = FIZZ + BUZZ;

    public static void main(String[] args) {
        IntStream.rangeClosed(1, 100)
                .forEach(number->printRepresentation(number));
    }

    /**
     * Print number representation to string
     * @param number
     */
    public static void printRepresentation(int number) {
        String representation = selectValue(number);
        System.out.println(representation);
    }

    /**
     * Check divisibility by 5(five)
     *
     * @param dividend
     * @return is five Divided
     */
    public static boolean isFiveDivided(int dividend) {
        return isEntirelyDivided(FIVE, dividend);
    }

    /**
     * Check divisibility by 3(three)
     *
     * @param dividend
     * @return is three Divided
     */
    public static boolean isThreeDivided(int dividend) {
        return isEntirelyDivided(THREE, dividend);
    }

    /**
     * Check divisibility by 3 and 5 same time
     *
     * @param dividend
     * @return is three and five Divided
     */
    public static boolean isThreeAndFiveDivided(int dividend) {
        return isThreeDivided(dividend) && isFiveDivided(dividend);
    }

    /**
     * Check Entirely Divide dividend by divider
     *
     * @param divider
     * @param dividend
     * @return is Entirely Divided dividend by divider
     */
    public static boolean isEntirelyDivided(int divider, int dividend) {
        return dividend % divider == 0;
    }

    /**
     * Select string representation for number
     *
     * @param number
     * @return string representation for number
     */
    public static String selectValue(int number) {
        if (isThreeAndFiveDivided(number)) {
            return FIZZ_BUZZ;
        }
        if (isThreeDivided(number)) {
            return FIZZ;
        }
        if (isFiveDivided(number)) {
            return BUZZ;
        } else {
            return number + "";
        }
    }
}
