package com.solid.algolearning.javacode.algorithms.patterns.cyclic_sort;
//
//You have a set of integers s, which originally contains all the numbers from 1 to n.
//        Unfortunately, due to some error, one of the numbers in s got duplicated to another number in the set,
//        which results in repetition of one number and loss of another number.
//
//        You are given an integer array nums representing the data status of this set after the error.
//
//        Find the number that occurs twice and the number that is missing and return them in the form of an array.
//
//
//
//        Example 1:
//
//        Input: nums = [1,2,2,4]
//        Output: [2,3]
//        Example 2:
//
//        Input: nums = [1,1]
//        Output: [1,2]

import java.util.Arrays;

public class SetMismatch {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findErrorNums(new int[]{1, 2, 2, 4})));
        System.out.println(Arrays.toString(findErrorNums(new int[]{1,1})));
        System.out.println(Arrays.toString(findErrorNums(new int[]{3,2,2})));
    }

    public static int[] findErrorNums(int[] nums) {
        int i = 0;
        int[] ans = new int[2];

        while( i < nums.length ) {
            int correct = nums[i] - 1;
            if( nums[i] != nums[correct] ){
                swap(nums, i, correct);
            }
            else {
                i++;
            }
        }

        for(int k = 0; k < nums.length; k++){
            if(nums[k] != k + 1){
                ans[1] = k + 1;
                ans[0] = nums[k];
            }
        }
        return ans;
    }

    public static void swap(int[] nums, int first, int second){
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}
