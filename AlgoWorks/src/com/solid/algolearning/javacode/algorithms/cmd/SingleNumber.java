package com.solid.algolearning.javacode.algorithms.cmd;

import java.util.Arrays;

public class SingleNumber {
    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{2, 1, 1, 5, 2}));
    }

    public static int singleNumber(int[] nums) {
        if(nums.length == 1){
            return nums[nums.length - 1];
        }

        int result = 0;

        for(int num : nums)
            result ^= num; // [4,1,2,1,2] -> 0 ^ 2 = 2, 2 ^ 2 = 0, 0 ^ 1 = 1
        return result;
    }
}
