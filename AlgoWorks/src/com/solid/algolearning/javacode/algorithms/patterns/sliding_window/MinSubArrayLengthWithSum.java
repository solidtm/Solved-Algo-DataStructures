package com.solid.algolearning.javacode.algorithms.patterns.sliding_window;

public class MinSubArrayLengthWithSum {

//    Given an array of positive numbers and a positive number ‘S,’ find the length of the smallest contiguous sub-array whose sum is greater than or equal to ‘S’. Return 0 if no such sub-array exists.
//
//    Example 1:
//    Input: [2, 1, 5, 2, 3, 2], S=7
//    Output: 2
//    Explanation: The smallest sub-arrays with a sum greater than or equal to '7' is [5, 2].
//
//    Example 2:
//    Input: [2, 1, 5, 2, 8], S=7
//    Output: 1
//    Explanation: The smallest sub-arrays with a sum greater than or equal to '7' is [8].
//
//    Example 3:
//    Input: [3, 4, 1, 1, 6], S=8
//    Output: 3
//    Explanation: Smallest sub-arrays with a sum greater than or equal to '8' are [3, 4, 1]

    public static void main(String[] args) {
        System.out.println(findMinSubArray(7, new int[]{2, 1, 5, 2, 3, 2}));
        System.out.println(findMinSubArray(7, new int[]{2, 1, 5, 2, 8}));
        System.out.println(findMinSubArray(8, new int[]{3, 4, 1, 1, 6}));
        System.out.println(findMinSubArray(7, new int[]{7}));
    }

    public static int findMinSubArray(int target, int[] arr) {
        if(arr.length == 1 && arr[0] >= target){
            return arr.length;
        }

        int windowSum = 0, minLength = Integer.MAX_VALUE;
        int windowStart = 0;
        int windowEnd;

        for(windowEnd = 0; windowEnd < arr.length; windowEnd++){
            windowSum += arr[windowEnd];  // add the next elements

            while(windowSum >= target){
                //shrink the window
                minLength = Math.min(minLength, windowEnd - windowStart + 1); //get the minimum window length
                windowSum -= arr[windowStart]; // subtract the element going out
                windowStart++; // slide the window ahead
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
