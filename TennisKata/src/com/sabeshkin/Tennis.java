package com.sabeshkin;

public class Tennis {

    private final static int scoreForEnd = 3;
    public static void main(String[] args) {
	// write your code here
    }

    public static boolean isReachForty(int firstScore, int secondScore){
        if(firstScore>=scoreForEnd || secondScore>=scoreForEnd){
            return true;
        }else{
            return false;
        }
    }

    public static boolean isDeuce(int firstScore, int secondScore){
        if(firstScore==secondScore){
            return true;
        }else{
            return false;
        }
    }
}
