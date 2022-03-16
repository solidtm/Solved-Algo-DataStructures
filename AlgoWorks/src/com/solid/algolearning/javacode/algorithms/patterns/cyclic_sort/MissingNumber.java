package com.solid.algolearning.javacode.algorithms.patterns.cyclic_sort;


//Problem Statement#
//        We are given an array containing n distinct numbers taken from the range 0 to n.
//        Since the array has only n numbers out of the total n+1 numbers, find the missing number.
//
//        Example 1:
//
//        Input: [4, 0, 3, 1]
//        Output: 2
//        Example 2:
//
//        Input: [8, 3, 5, 2, 4, 6, 0, 1]
//        Output: 7


public class MissingNumber {
    public static int findMissingNumber(int[] nums) {
        int i = 0;
        int result = 0;

        while(i < nums.length){
            if(nums[i] < nums.length && nums[i] != nums[nums[i]]){
                swap(nums, i, nums[i]);
            }else i++;
        }

        while(result < nums.length){
            if(nums[result] != result){
                return result;
            }
            result++;
        }
        return nums.length;
    }

    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(findMissingNumber(new int[] { 4, 0, 3, 1 }));
        System.out.println(findMissingNumber(new int[] { 8, 3, 5, 2, 4, 6, 0, 1 }));
    }
}
