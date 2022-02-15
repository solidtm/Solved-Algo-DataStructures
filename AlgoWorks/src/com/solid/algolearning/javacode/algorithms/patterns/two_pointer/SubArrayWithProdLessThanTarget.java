package com.solid.algolearning.javacode.algorithms.patterns.two_pointer;

//Problem Statement#
       /* Given an array with positive numbers and a positive target number, find all of its contiguous subarrays whose product is less than the target number.


        Example 1:

        Input: [2, 5, 3, 10], target=30
        Output: [2], [5], [2, 5], [3], [5, 3], [10]
        Explanation: There are six contiguous subarrays whose product is less than the target.
        Example 2:

        Input: [8, 2, 6, 5], target=50
        Output: [8], [2], [8, 2], [6], [2, 6], [5], [6, 5]
        Explanation: There are seven contiguous subarrays whose product is less than the target.
*/

import java.util.*;
public class SubArrayWithProdLessThanTarget {

    public static List<List<Integer>> findSubarrays(int[] arr, int target) {
        List<List<Integer>> result = new ArrayList<>();
        double product = 1;
        int left = 0;

        for (int right = 0; right < arr.length; right++) {
            product *= arr[right];
            while (product >= target && left < arr.length)
                product /= arr[left++];
            // since the product of all numbers from left to right is less than the target therefore,
            // all subarrays from left to right will have a product less than the target too; to avoid
            // duplicates, we will start with a subarray containing only arr[right] and then extend it
            List<Integer> tempList = new LinkedList<>();
            for (int i = right; i >= left; i--) {
                tempList.add(0, arr[i]);
                result.add(new ArrayList<>(tempList));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findSubarrays(new int[] { 2, 5, 3, 10 }, 30));
        System.out.println(findSubarrays(new int[] { 8, 2, 6, 5 }, 50));
    }
}
