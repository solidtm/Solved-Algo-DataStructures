package com.solid.algolearning.javacode.algorithms.recursion.easy;

//The GCD of two integers is the largest integer that can fully divide both numbers, without a remainder.
//        Problem Statement#
//        Write a recursive method that computes the GCD of two integers.
//
//        Instructions#
//        The method should take two integers as input. Their GCD is to be computed, as input.
//        The method should return the GCD of the two integers as output.
//        The method should be recursive.
//        Sample Input: 24, 18
//
//        Sample Output: 6

public class GCD {
    public static int gcd(int num1, int num2) {
        // Base case
        if (num1 == num2) {
            return num1;
        }
        // Recursive case
        if (num1 > num2) {
            return gcd(num1 - num2, num2);
        }
        else {
            return gcd(num1, num2 - num1);
        }
    }

    public static void main( String args[] ) {
        int x = 56;
        int y = 42;
        int result = gcd(x, y);
        System.out.println("The GCD of " + x + " and " + y + " is:");
        System.out.println(result);
    }
}
