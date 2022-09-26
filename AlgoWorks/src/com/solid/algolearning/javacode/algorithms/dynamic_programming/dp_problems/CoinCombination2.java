package com.solid.algolearning.javacode.algorithms.dynamic_programming.dp_problems;

//https://cses.fi/problemset/task/1636
//using dynamic programming bottom up approach.

public class CoinCombination2 {
    public static void main(String[] args) {

        int targetSum = 9;   //sum to get
        int n = 3;   //number of coins
        int[] coins = {2, 3, 5};  //available coins to pick from
        int[]dp = new int[targetSum + 1]; // array to hold the number of combinations to each sum
        dp[0] = 1;                       //initialize dp[0] to 1

        for (int i = 0; i < n; i++) {  //loop though the number of coins
            for (int value = 1; value <= targetSum; value++) { //loop through target sum, from 1 to targetSum inclusive
                if (value - coins[i] >= 0){   //
                    dp[value] = dp[value] + dp[value - coins[i]];
                }
            }
        }

        System.out.println(dp[targetSum]);
    }
}
