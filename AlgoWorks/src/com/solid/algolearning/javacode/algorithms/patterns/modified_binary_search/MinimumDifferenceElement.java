package com.solid.algolearning.javacode.algorithms.patterns.modified_binary_search;

//Problem Statement#
//        Given an array of numbers sorted in ascending order, find the element in the array that has the minimum difference with the given ‘key’.
//
//        Example 1:
//        Input: [4, 6, 10], key = 7
//        Output: 6
//        Explanation: The difference between the key '7' and '6' is minimum than any other number in the array

//        Example 2:
//        Input: [4, 6, 10], key = 4
//        Output: 4

//        Example 3:
//        Input: [1, 3, 8, 10, 15], key = 12
//        Output: 10

//        Example 4:
//        Input: [4, 6, 10], key = 17
//        Output: 10

//Solution#
//        The problem follows the Binary Search pattern.
//        Since Binary Search helps us find a number in a sorted array efficiently,
//        we can use a modified version of the Binary Search to find the number that has the minimum difference with the given ‘key’.
//
//        We can use a similar approach as discussed in Order-agnostic Binary Search. We will try to search for the ‘key’
//        in the given array. If we find the ‘key’ we will return it as the minimum difference number. If we can’t find the ‘key’,
//        (at the end of the loop) we can find the differences between the ‘key’ and the numbers pointed out by indices start and end, as these two numbers will be closest to the ‘key’.
//        The number that gives minimum difference will be our required number.

public class MinimumDifferenceElement {
    public static int searchMinDiffElement(int[] arr, int key) {
        if (key < arr[0])    //edge cases
            return arr[0];
        if (key > arr[arr.length - 1])
            return arr[arr.length - 1];

        int start = 0, end = arr.length - 1;
        //perform normal binary search to find the key.
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (key < arr[mid]) {
                end = mid - 1;
            } else if (key > arr[mid]) {
                start = mid + 1;
            } else { //key is equal to the middle valus
                return arr[mid];
            }
        }

        // at the end of the while loop, 'start == end+1'
        // we are not able to find the element in the given array
        // return the element which is closest to the 'key'
        if ((arr[start] - key) < (key - arr[end]))
            return arr[start];
        return arr[end];
    }

    public static void main(String[] args) {
        System.out.println(searchMinDiffElement(new int[] { 4, 6, 10 }, 7));
        System.out.println(searchMinDiffElement(new int[] { 4, 6, 10 }, 4));
        System.out.println(searchMinDiffElement(new int[] { 1, 3, 8, 10, 15 }, 12));
        System.out.println(searchMinDiffElement(new int[] { 4, 6, 10 }, 17));
    }

//    Time complexity#
//    Since, we are reducing the search range by half at every step,
//    this means the time complexity of our algorithm will be O(logN) where ‘N’ is the total elements in the given array.
//
//    Space complexity#
//    The algorithm runs in constant space O(1).
}
