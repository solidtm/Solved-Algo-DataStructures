package com.solid.algolearning.javacode.algorithms.patterns.two_pointer;
// Problem Statement#
// Given an array of sorted numbers and a target sum, find a pair in the array whose sum is equal to the given target.

// Write a function to return the indices of the two numbers (i.e. the pair) such that they add up to the given target.

// Example 1:
// Input: [1, 2, 3, 4, 6], target=6
// Output: [1, 3]
// Explanation: The numbers at index 1 and 3 add up to 6: 2+4=6

// Example 2:
// Input: [2, 5, 9, 11], target=11
// Output: [0, 2]
// Explanation: The numbers at index 0 and 2 add up to 11: 2+9=11

// Solution#
// Since the given array is sorted,
// a brute-force solution could be to iterate through the array,
// taking one number at a time and searching for the second number through Binary Search.
// The time complexity of this algorithm will be O(N*logN)O(N∗logN). Can we do better than this?

// We can follow the Two Pointers approach.
// We will start with one pointer pointing to the beginning of the array and another pointing at the end.
// At every step, we will see if the numbers pointed by the two pointers add up to the target sum.
// If they do, we have found our pair; otherwise, we will do one of two things:

// If the sum of the two numbers pointed by the two pointers is greater than the target sum,
// this means that we need a pair with a smaller sum. So, to try more pairs, we can decrement the end-pointer.
// If the sum of the two numbers pointed by the two pointers is smaller than the target sum,
// this means that we need a pair with a larger sum. So, to try more pairs, we can increment the start-pointer.

public class TwoSum {
    public static int[] search(int[] arr, int targetSum) {
        int start = 0, end = arr.length - 1;

        while(start < end){
            if(arr[start] + arr[end] < targetSum){
                start++;
            }else if(arr[start] + arr[end] > targetSum){
                end--;
            }else{
                return new int[]{start, end};
            }
        }
        return new int[] { -1, -1 };
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}
