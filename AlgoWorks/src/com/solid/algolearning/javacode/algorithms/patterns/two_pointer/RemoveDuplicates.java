package com.solid.algolearning.javacode.algorithms.patterns.two_pointer;
// Problem Statement#
// Given an array of sorted numbers, remove all duplicates from it. You should not use any extra space; after removing the duplicates in-place return the length of the subarray that has no duplicate in it.

// Example 1:
// Input: [2, 3, 3, 3, 6, 9, 9]
// Output: 4
// Explanation: The first four elements after removing the duplicates will be [2, 3, 6, 9].

// Example 2:
// Input: [2, 2, 2, 11]
// Output: 2
// Explanation: The first two elements after removing the duplicates will be [2, 11].

public class RemoveDuplicates {
    public static int remove(int[] arr) {
        int start = 0, end = start + 1, counter = 1;

        while(end < arr.length){
            if(arr[start] != arr[end]){
                counter++;
                start = end;
                end++;
            }else if(arr[start] == arr[end]){
                end++;
            }
        }

        return counter;
    }


    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}
