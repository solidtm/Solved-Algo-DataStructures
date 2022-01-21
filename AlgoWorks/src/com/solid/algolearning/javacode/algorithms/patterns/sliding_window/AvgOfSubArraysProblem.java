package com.solid.algolearning.javacode.algorithms.patterns.sliding_window;

import java.util.Arrays;

public class AvgOfSubArraysProblem {

//    Given an array, find the average of all sub-arrays of ‘K’ contiguous elements in it.
//    For the first 5 numbers (sub-arrays from index 0-4), the average is: (1+3+2+6-1)/5 => 2.2(1+3+2+6−1)/5 => 2.2
//    The average of next 5 numbers (sub-arrays from index 1-5) is: (3+2+6-1+4)/5 => 2.8(3+2+6−1+4)/5 => 2.8
//    For the next 5 numbers (sub-arrays from index 2-6), the average is: (2+6-1+4+1)/5 => 2.4(2+6−1+4+1)/5 => 2.4…
//    Here is the final output containing the averages of all sub-arrays of size 5: Output: [2.2, 2.8, 2.4, 3.6, 2.8]

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findAverages(5, new int[]{1, 3, 2, 6, -1, 4, 1, 8, 2})));
    }

    public static double[] findAverages(int k, int[] arr){
        double[] result = new double[arr.length - k + 1];   // result array to hold all the average of all k sub-arrays
        double windowSum = 0;
        int windowStart = 0;
        int windowEnd;

        for(windowEnd = 0; windowEnd < arr.length; windowEnd++){
            windowSum += arr[windowEnd];   // add the next element

//          slide the window, we don't need to slide if we've not hit the required window size of 'k'
            if (windowEnd >= k - 1){
                result[windowStart] = windowSum / k;   // calculate the average
                windowSum -= arr[windowStart];     // subtract the element going out
                windowStart++;   // slide the window ahead
            }
        }
        return result;
    }
}
