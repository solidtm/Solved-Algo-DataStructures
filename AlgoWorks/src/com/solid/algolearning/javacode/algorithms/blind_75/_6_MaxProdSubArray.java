package com.solid.algolearning.javacode.algorithms.blind_75;
//leetcode no 152

public class _6_MaxProdSubArray {
    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{2,3,-2,4}));
    }

    static int maxProduct(int[] nums){
        int max = nums[0];
        int min = nums[0];

        int ans = nums[0];

        for(int i = 1; i < nums.length; i++){
            int temp = max;

            max = Math.max(nums[i], Math.max(max * nums[i], min * nums[i]));
            min = Math.min(nums[i], Math.min(min * nums[i], temp*nums[i]));
            ans = Math.max(max, ans);
        }
        return ans;
    }
}
