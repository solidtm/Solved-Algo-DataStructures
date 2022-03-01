package com.solid.algolearning.javacode.algorithms.blind_75;
//leetcode no 53

public class _5_MaximumSubArray {
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }

    static int maxSubArray(int[] nums){
        int maxSubArray = nums[0];
        int currentSum = 0;


        for (int num : nums) {
            if (currentSum < 0) {
                currentSum = 0;
            }
            currentSum += num;
            maxSubArray = Math.max(maxSubArray, currentSum);
        }

        return maxSubArray;
    }
}
