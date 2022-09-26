package com.solid.algolearning.javacode.algorithms.dynamic_programming.dp_problems;

//Problem: https://cses.fi/problemset/task/1633

import java.util.ArrayList;

public class DiceThrow {
    public static void main(String[] args) {
        System.out.println(diceCombinations("", 3));
        System.out.println(diceCombinationsReturn( 3));


        //
        int nums = 3;
        int n = 6;
        int[] dp = new int[nums + 1];
        dp[0] = 1;

        for (int i = 1; i <= nums; i++) {
            for (int j = 1; j <= n; j++) {
                if (i - j >= 0){
                    dp[i] = dp[i] + dp[i - j];
                }
            }
        }

        System.out.println(dp[nums]);
    }

    static ArrayList<String> diceCombinations(String p, int target){
        if(target == 0){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList<String> ans = new ArrayList<>();
        for(int i = 1; i <= target; i++){
            ans.addAll(diceCombinations(p + i, target - i));
        }

        return ans;
    }


    static int diceCombinationsReturn(int target){
        if(target == 0) return 1;
        if(target < 0) return 0;

        int ans = 0;
        for(int i = 1; i <= 6; i++){
            ans += diceCombinationsReturn(target - i);
        }

        return ans;
    }
}
