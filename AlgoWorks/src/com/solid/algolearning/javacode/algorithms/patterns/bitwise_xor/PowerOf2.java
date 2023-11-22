package com.solid.algolearning.javacode.algorithms.patterns.bitwise_xor;
//you are given a number and asked to checkif it is a power of 2 or not

public class PowerOf2 {
    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(-8));
    }

    //this function fails at having a -ve large numbers find out why (hint = signed and unsigned bits)
    static boolean isPowerOfTwo(int n){
        if(n == 0) return false;

       return (n & (n - 1)) == 0;
    }
}
