package com.solid.algolearning.javacode.algorithms.blind_75;
//Leetcode problem 268

import java.util.HashSet;
import java.util.Set;

public class _13_MissingNumber {
    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{3,0,1}));
    }

    //one method of solving the problem,
    //what we do here is that we are getting the sum of the range
    //of numbers and we
    private static int missingNumber(int[] nums){
        int result = 0;
        int hold = 0;
        int n = nums.length;

        //we can get the sum of this range of numbers using (n * (n - 1)) / 2;
        result = (n * (n + 1)) / 2;

        for (int i = 0; i < n; i++) {
            hold += nums[i];
        }

        return result - hold;
    }

    private static int missingNumber2(int[] nums){
        int res = 0;
        int n = nums.length;
        Set<Integer> set = new HashSet<>(n + 1);

        for(int i : nums){
            set.add(i);
        }

        for(int i = 0; i < n; i++){
            if(!set.contains(i)) return i;
        }

        return - 1;
    }
}
