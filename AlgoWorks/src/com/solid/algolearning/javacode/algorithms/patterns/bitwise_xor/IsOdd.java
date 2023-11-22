package com.solid.algolearning.javacode.algorithms.patterns.bitwise_xor;

//Given a number find if the number is odd or not
public class IsOdd {
    public static void main(String[] args) {
        int number = 68;
        System.out.println(isOdd(number));
        System.out.println(2 << 4);
        System.out.println(Integer.toBinaryString(25 >> 1));
    }

    //method to check if a number is odd or not.
    //just simply use the bitwise AND operator
    private static boolean isOdd(int number){
        return (number & 1) == 1;
    }

    //method to find the position of the rightmost set bit of a given number
    private static boolean findRightmostSetBit(int number){
        return (number & 1) == 1;
    }

    //method to check if a number is +ve or -ve
    private static boolean isPosOrNeg(int number){
        return (number & 1) == 1;
    }
}
























