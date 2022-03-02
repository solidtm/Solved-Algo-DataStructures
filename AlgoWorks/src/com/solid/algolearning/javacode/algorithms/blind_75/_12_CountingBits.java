package com.solid.algolearning.javacode.algorithms.blind_75;

import java.util.Arrays;

// leetcode problem 338
public class _12_CountingBits {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(2)));
    }

    // a super intuitive method to solve this problem is:
    // to use dynamic programming/memoization
    // what we do here is to use an array to store values of
    // what we have computed before wherein the MSB is at a particular value/index
    //

    static int[] countBits(int n){
        int[] dp = new int[n + 1];
        int offset = 1;

        for (int i = 1; i < n + 1; i++) {
            if(offset * 2 == i){
                offset = i;
            }

            dp[i] = 1 + dp[i - offset];

        }
        
        return dp;
    }
}
