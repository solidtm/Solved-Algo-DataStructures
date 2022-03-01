package com.solid.algolearning.javacode.algorithms.blind_75;
//leetcode no 238

import java.util.Arrays;

public class _4_ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1, 2, 3, 4})));
    }

    static int[] productExceptSelf(int[] nums){
        int prefix = 1;
        int postfix = 1;
        int[] result = new int[nums.length];

        //this loop gets the prefix
        for (int i = 0; i < nums.length; i++) {
           result[i] = prefix; //store the prefixes in the result array
           prefix *= nums[i];  //calculate for next prefix
        }

        //this loop will get the postfix
        for (int i = nums.length - 1; i >= 0; i--) {
           result[i] *= postfix;  //we then multiply the postfixes with the values at that index in result and
           postfix *= nums[i];    //we update the postfix
        }

        return result;
    }
}
