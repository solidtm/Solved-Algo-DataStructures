package com.solid.algolearning.javacode.algorithms.dynamic_programming.dp_learning;

public class FibonacciNumbers {
    public static void main(String[] args) {
        System.out.println(findFibNumber(5));
        System.out.println(calculateFibonacci(5));
    }


    /*
    * Top-down with Memoization approach of fibonacci numbers problem.
    * Here we use memoization, solve the bigger problelm first and then
    * Typically recurse down and solve the rest of the smaller sub-problems
    */

    public static int findFibNumber(int n){
        int[] dp = new int[n + 1];

        return calcFibRecursive(dp, n);
    }

    private static int calcFibRecursive(int[] dp, int n) {
        if (n < 2){
            return n;
        }

        if (dp[n] != 0){
            return dp[n];
        }

        dp[n] = calcFibRecursive(dp, n - 1) + calcFibRecursive(dp, n - 2);
        return dp[n];
    }

    /*
     * Bottom-up approach with Tabulation of fibonacci numbers problem.
     * Here we use tabulation, avoiding recursion, but solving the smaller probelms first
     * and then solve the bigger problems adn reach an optimal solution for the main problem.
     */

    public static int calculateFibonacci(int n) {
        if (n == 0) return 0;
        int[] dp = new int[n + 1];

        //base cases
        dp[0] = 0;
        dp[1] = 1;

        for(int i = 2; i <= n; i++)
            dp[i] = dp[i - 1] + dp[i - 2];

        return dp[n];
    }
}
