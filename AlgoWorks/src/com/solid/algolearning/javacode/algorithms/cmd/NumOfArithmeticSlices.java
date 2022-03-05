package com.solid.algolearning.javacode.algorithms.cmd;

public class NumOfArithmeticSlices {
    public static void main(String[] args) {
        System.out.println(numberOfArithmeticSlices(new int[]{1, 2, 3, 4}));
    }

    public static int numberOfArithmeticSlices(int[] nums) {
        if(nums.length < 3) return 0;

        int c = 0;

        for(int i = 2, prev = 0; i<nums.length;i++){
            if(nums[i] - nums[i-1] == nums[i - 1] - nums[i - 2]) {
                prev++;
                c += prev;
            }else{
                prev = 0;
            }
        }
        return c;
    }
}
