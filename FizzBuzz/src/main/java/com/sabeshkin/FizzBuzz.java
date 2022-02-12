package com.sabeshkin;

public class FizzBuzz {
    public static final int FIVE = 5;
    public static final int THREE = 3;

    public static void main(String[] args) {
        // write your code here
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
     * Check Entirely Divide dividend by divider
     * @param divider
     * @param dividend
     * @return is Entirely Divided dividend by divider
     */
    public static boolean isEntirelyDivided(int divider, int dividend) {
        return dividend % divider == 0;
    }


}
