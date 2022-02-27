package com.solid.algolearning.javacode.algorithms.patterns.bitwise_xor;

public class CountSetBits {
    public static void main(String[] args) {
        int n = 45;
        System.out.println(Integer.toBinaryString(n));

        System.out.println(countSetBits(n));
    }

    static int countSetBits(int n){
       int count = 0;

    //either this way
//       while(n > 0){
//           //increment count
//           count++;
//
//           n -= (n & -n);
//       }

        //or this way will enable us count the setbits efficiently
        while(n > 0){
            count ++;
            n = n & (n-1);
        }
       return count;
    }
}
