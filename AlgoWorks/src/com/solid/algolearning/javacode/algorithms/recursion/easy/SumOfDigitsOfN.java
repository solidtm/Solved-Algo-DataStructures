package com.solid.algolearning.javacode.algorithms.recursion.easy;

//given a number n sum all it's digits and return the value of the sum
//we can use recursion thus:

public class SumOfDigitsOfN {
    public static void main(String[] args) {
        System.out.println(sumDigits(1234));
    }

    static int sumDigits(int n){
        if(n % 10 == n) return n;

        int rem = n % 10;
        n = n / 10;

        return sumDigits(n) + rem;
    }
}
