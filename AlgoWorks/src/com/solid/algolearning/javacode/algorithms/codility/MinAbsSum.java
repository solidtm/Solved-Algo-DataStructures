package com.solid.algolearning.javacode.algorithms.codility;

//codility minAbsSum problem
//Using dynamic programming

import java.util.*;

public class MinAbsSum {
    public static void main(String[] args) {

    }



    //this would pass on accuracy and not in efficiency on codility tests
    public int solution(int[] nums) {
        int sum = 0;    //get the sum of absolute values in the array
        for (int num : nums) {
            int absNum = Math.abs(num);
            sum += absNum;
        }

        float centreVal = sum / 2f;
        int range = (int) Math.floor(centreVal);
        int[] dp = new int[range + 1];
        dp[0] = 1;

        for (int num : nums){
            for (int i = dp.length - 1; i >= 0; i--) {
                if (i - Math.abs(num) >= 0){
                    if (dp[i - Math.abs(num)] == 1){
                        dp[i] = 1;
                    }
                }
            }
        }

        for (int i = range; i >= 0; i--) {
            if (dp[i] == 1){
                return (int) ((centreVal - i) * 2);
            }
        }

        return -1;
    }


    //this works for both correctness and efficiency
    public int solution2(int[] nums) {
        Map<Integer, Integer> valCounts = new HashMap<>();

        int sum = 0;    //get the sum of absolute values in the array
        for (int num : nums) {
            int absNum = Math.abs(num);
            sum += absNum;
            valCounts.put(absNum, valCounts.getOrDefault(absNum, 0) + 1);
        }

        float centreVal = sum / 2f;
        int range = (int) Math.floor(centreVal);
        int[] dp = new int[range + 1];
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
           dp[i] = -1;
        }


        for (int val : valCounts.keySet()){
            int countOfVal = valCounts.get(val);
            dp[0] = countOfVal;

            for (int i = 0; i < dp.length; i++) {
                if (dp[i] >= 0){
                    dp[i] = countOfVal;
                }else{
                    if((i - val) >= 0){
                        dp[i] = dp[i - val] - 1;
                    }
                }
            }
        }

        for (int i = range; i >= 0; i--) {
            if (dp[i] > 0){
                return (int) ((centreVal - i) * 2);
            }
        }

        return -1;
    }
}
