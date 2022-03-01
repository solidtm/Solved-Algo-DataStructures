package com.solid.algolearning.javacode.algorithms.cmd;

import java.util.Arrays;

public class TwoSum2 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2,7,11,15}, 9)));
    }

    public static int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int[] result = new int[2];

        while(left < right){
            if(nums[left] + nums[right] == target){
                result[0] = left + 1;
                result[1] = right + 1;
                break;
            }else if(nums[left] + nums[right] > target){
                right --;
            }else {
                left++;
            }
        }

        return result;
    }
}
