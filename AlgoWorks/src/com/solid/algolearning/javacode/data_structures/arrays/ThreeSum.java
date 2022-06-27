package com.solid.algolearning.javacode.data_structures.arrays;

import java.util.*;
import java.io.*;

//Three Sum
//        HIDE QUESTION
//        Have the function ThreeSum(arr) take the array of integers stored in arr, and determine if any three distinct numbers
//        (excluding the first element) in the array can sum up to the first element in the array.
//        For example: if arr is [8, 2, 1, 4, 10, 5, -1, -1] then there are actually three sets of triplets that sum to the number
//        8: [2, 1, 5], [4, 5, -1] and [10, -1, -1]. Your program should return the string true if 3 distinct elements sum to the first element,
//        otherwise your program should return the string false. The input array will always contain at least 4 elements.

class ThreeSum {
    public static String threeSum(int[] arr) {
        int start = 1;
        int end = arr.length - 1;
        String result = "";

        int base = arr[0]; //first element in the array (base element)
        Arrays.sort(arr);  //sort the array so we can use 2 pointers approach

        for (int j : arr) {
            if (j != base) {
                int target = base - j;
                result = findTwoSum(arr, target, start, end);
            }
        }
        return result;
    }

    public static String findTwoSum(int[] arr, int target, int start, int end){
        while(start < end){
            int twoSum = arr[start] + arr[end];

            if(twoSum == target){
                return "true";
            }else if(target < twoSum){
                end--;
            }else start++;
        }

        return "false";
    }

}
