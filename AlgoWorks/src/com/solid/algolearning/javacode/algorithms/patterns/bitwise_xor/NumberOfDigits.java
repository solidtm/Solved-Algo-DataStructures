package com.solid.algolearning.javacode.algorithms.patterns.bitwise_xor;

public class NumberOfDigits {
    public static void main(String[] args) {
       int n = 128;
       int base = 2;

        System.out.println(Integer.toBinaryString(n));
        System.out.println(numberOfDigits(n, base));
        System.out.println(Math.pow(2, 7));
    }

    static int numberOfDigits(int num, int base){
      return (int) (Math.log(num) / Math.log(base)) + 1;
    }
}
