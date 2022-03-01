package com.solid.algolearning.javacode.algorithms.blind_75;
//leetcode problem

import java.util.*;
public class _1_TwoSum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2,7,11,15}, 9)));
    }

    public static int[] twoSum(int[] nums, int target) {

        if(nums.length == 0){
            return nums;
        }

        Map<Integer, Integer> seen = new HashMap<>();
        int[] result = new int[2];

        for(int i = 0; i < nums.length; i++){
            if(seen.containsKey(nums[i])){
                result[0] = seen.get(nums[i]);
                result[1] = i;
            }else{
                seen.put(target - nums[i], i);
            }
        }

        return result;
    }
}
