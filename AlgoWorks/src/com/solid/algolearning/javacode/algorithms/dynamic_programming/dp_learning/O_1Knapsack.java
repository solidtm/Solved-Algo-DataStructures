package com.solid.algolearning.javacode.algorithms.dynamic_programming.dp_learning;


//Problem Statement#
//        Given two integer arrays to represent weights and profits of ‘N’ items,
//        we need to find a subset of these items which will give us maximum profit
//        such that their cumulative weight is not more than a given number ‘C’.
//
//        Write a function that returns the maximum profit. Each item can only be selected once,
//        which means either we put an item in the knapsack or skip it.

public class O_1Knapsack {

    public static void main(String[] args) {


    }

    public int solveKnapsack(int[] profits, int[] weights, int capacity) {
        Integer[][] dp = new Integer[profits.length][capacity + 1];
        return this.knapsackRecursive(dp, profits, weights, capacity, 0);
    }

    private int knapsackRecursive(Integer[][] dp, int[] profits, int[] weights, int capacity,
                                  int currentIndex) {

        // base checks
        if (capacity <= 0 || currentIndex >= profits.length) return 0;

        // if we have already solved a similar problem, return the result from memory
        if(dp[currentIndex][capacity] != null)
            return dp[currentIndex][capacity];

        // recursive call after choosing the element at the currentIndex
        // if the weight of the element at currentIndex exceeds the capacity, we shouldn't process this
        int profit1 = 0;
        if(weights[currentIndex] <= capacity)
            profit1 = profits[currentIndex] + knapsackRecursive(dp, profits, weights,
                    capacity - weights[currentIndex], currentIndex + 1);

        // recursive call after excluding the element at the currentIndex
        int profit2 = knapsackRecursive(dp, profits, weights, capacity, currentIndex + 1);

        dp[currentIndex][capacity] = Math.max(profit1, profit2);
        return dp[currentIndex][capacity];
    }
}
