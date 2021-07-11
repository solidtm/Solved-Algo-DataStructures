package com.solid.algolearning.javacode.turingchallenges;

import java.util.Arrays;

public class TuringChallenge2 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};

        rotate(nums, 3);
        System.out.println(Arrays.toString(nums));

    }

    //    rotate array problem to rotate a specified number of elements in a specified order.
    public static void rotate(int[] nums, int k) {        // [5, 6, 7, 1, 2, 3, 4]
        k %= nums.length;
//        reverse the whole array
        reverse(nums, 0, nums.length - 1);
//        reverse the specified number of arrays
        reverse(nums, 0, k - 1);
//        reverse the rest of the array
        reverse(nums, k, nums.length - 1);
    }
    //    Method to reverse the array
    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

}
