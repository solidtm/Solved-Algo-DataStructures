package com.solid.algolearning.javacode.data_structures.arrays;

public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        System.out.println(findMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1}));
    }

    static int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, result = 0, i = 0;

        while(i < nums.length){
            if(nums[i] == 1){
                max++;
            }else if(nums[i] == 0){
                result = Math.max(result, max);
                max = 0;
            }
            i++;
            result = Math.max(result, max);
        }
        return result;
    }
}
