package com.solid.algolearning.javacode.algorithms.patterns.sliding_window;

public class MaxSumSubArrayProblem {

//    Given an array of positive numbers and a positive number ‘k,’
//    find the maximum sum of any contiguous sub-array of size ‘k’.

//    Input: [2, 1, 5, 1, 3, 2], k = 3
//    Output: 9
//    Explanation: Sub-array with maximum sum is [5, 1, 3].

//    Input: [2, 3, 4, 1, 5], k = 2
//    Output: 7
//    Explanation: Sub-array with maximum sum is [3, 4].

    public static int findMaxSumSubArray(int k, int[] arr) {
        //algorithm:
        //using sliding window, we will have variables, windowSum, windowStart, windowEnd

        if(k == 0){  //we have no window size
            return -1;
        }

        if(arr.length == 1){ //we have one element array
            return arr[0];
        }

        int windowSum = 0;
        int result = 0;
        int windowStart = 0;
        int windowEnd;

        for(windowEnd = 0; windowEnd < arr.length; windowEnd++){
            windowSum += arr[windowEnd];  // add the next element

//          slide the window, we don't need to slide if we've not hit the required window size of 'k'
            if(windowEnd >= k - 1){
                result = Math.max(result, windowSum);     // if result is less than windowSum, always set the value to

                windowSum -= arr[windowStart];  // subtract element leaving the window
                windowStart++;    // slide the window ahead
            }
        }
        return result;
    }
}
