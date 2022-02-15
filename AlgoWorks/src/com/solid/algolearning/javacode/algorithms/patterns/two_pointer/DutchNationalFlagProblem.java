package com.solid.algolearning.javacode.algorithms.patterns.two_pointer;

//Problem Statement#
//        Given an array containing 0s, 1s and 2s, sort the array in-place. You should treat numbers of the array as objects, hence, we can’t count 0s, 1s, and 2s to recreate the array.
//
//        The flag of the Netherlands consists of three colors: red, white and blue; and since our input array also consists of three different numbers that is why it is called Dutch National Flag problem.
//
//        Example 1:
//
//        Input: [1, 0, 2, 1, 0]
//        Output: [0, 0, 1, 1, 2]
//        Example 2:
//
//        Input: [2, 2, 0, 1, 2, 0]
//        Output: [0, 0, 1, 2, 2, 2,]

import java.util.Arrays;

public class DutchNationalFlagProblem {
    public static void sort(int[] arr) {
        int start = 0, end = arr.length - 1;

//put in place for 0s
        for(int i = 0; i <= end;){   //{0, 0, 2, 1, 2, 2, 1, 0}
            if(arr[i] == 0) {
                swap(arr, i, start);
                //increment i and start
                i++;
                start++;
            }
            else if(arr[i] == 1) {
                i++;
            }
            else{ // the case for arr[i] == 2
                swap(arr, i, end);
                end--;      // decrement 'end' only, after the swap the number at index 'i' could be 0, 1 or 2
            }
        }
// after this final swaps, we have the 2s at the end of the array
        System.out.println(Arrays.toString(arr));
    }

    public static void swap(int[] arr, int start, int end){
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }

    public static void main(String[] args) {
        sort(new int[]{0, 0, 2, 1, 2, 2, 1, 2});
    }
}
