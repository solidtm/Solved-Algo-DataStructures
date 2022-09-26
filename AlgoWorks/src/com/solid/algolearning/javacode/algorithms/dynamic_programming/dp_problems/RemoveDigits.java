package com.solid.algolearning.javacode.algorithms.dynamic_programming.dp_problems;

//https://cses.fi/problemset/task/1637

public class RemoveDigits {
    public static void main(String[] args) {
        System.out.println(getMinSteps(27));
    }


    //Using a bottom up approach
   static int getMinSteps(int num){
        int[] dp = new int[num + 1];     //create the memo
       for (int i = 1; i < dp.length; i++) {
           dp[i] = Integer.MAX_VALUE - 1;     //set every value to infinity
       }
       dp[0] = 0;                       //initialize the 0 bcos it takes nothing to get to 0

        for (int value = 1; value <= num; value++) {
            int temp = value;

            while(temp > 0){
                int digit = temp % 10;
                dp[value] = Math.min(dp[value], dp[value - digit] + 1);
                temp /= 10;
            }
        }

        return dp[num];
    }
}
