package com.solid.algolearning.javacode.algorithms.codility;

//codility number solitaire problem
//This is a dynamic programming problem

public class NumberSolitaire {
    public static void main(String[] args) {

    }


    public int solution(int[] nums) {
        int[] dp = new int[nums.length];

        for (int i = 0; i < nums.length; i++){  //go through the array
           if(i == 0){   //result at first index is equal to the number at that index cos we are just starting out
               dp[i] = nums[i];
           }else{
             int maxOnThisSquare = Integer.MIN_VALUE;  //this is to get the maximum number on the square while throwing the dice

             for (int j = 1; j <= 6; j++){   //throw the dice
                 if((i - j) >= 0){          // we don't want to go negative to calculate the maximum
                    maxOnThisSquare = Math.max(maxOnThisSquare, dp[i-j] + nums[i]); //get the max value from previous results and add it to the value we are looking at currently
                 }
             }
               dp[i] = maxOnThisSquare;  //assign that value to that index for future use.
           }
        }
        return dp[dp.length - 1];
    }



    //or this way
    public int solution2(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        for (int i = 1; i < nums.length; i++){
            int maxOnThisSquare = Integer.MIN_VALUE;
            for (int j = 1; j <= 6; j++){
                if((i - j) >= 0){
                    maxOnThisSquare = Math.max(maxOnThisSquare, dp[i-j] + nums[i]);
                }
            }
            dp[i] = maxOnThisSquare;
        }
        return dp[dp.length - 1];
    }
}
