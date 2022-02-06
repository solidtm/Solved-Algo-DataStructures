package com.solid.algolearning.javacode.algorithms.patterns.fast_slow_pointers;
//Cycle in a Circular Array (hard)#
//        We are given an array containing positive and negative numbers.
//        Suppose the array contains a number ‘M’ at a particular index.
//        Now, if ‘M’ is positive we will move forward ‘M’ indices and if ‘M’ is negative move backwards ‘M’ indices.
//        You should assume that the array is circular which means two things:
//
//        1. If, while moving forward, we reach the end of the array, we will jump to the first element to continue the movement.
//        2. If, while moving backward, we reach the beginning of the array, we will jump to the last element to continue the movement.
//
//        Write a method to determine if the array has a cycle.
//        The cycle should have more than one element and should follow one direction which means
//        the cycle should not contain both forward and backward movements.
//        Example 1:
//
//        Input: [1, 2, -1, 2, 2]
//        Output: true
//        Explanation: The array has a cycle among indices: 0 -> 1 -> 3 -> 0

//        Example 2:
//        Input: [2, 2, -1, 2]
//        Output: true
//        Explanation: The array has a cycle among indices: 1 -> 3 -> 1

//        Example 3:
//        Input: [2, 1, -1, -2]
//        Output: false
//        Explanation: The array does not have any cycle.



//Solution:
// conditions are:
// 1. values represent jumps it makes
// 2. Only 2 possible directions, forward/backward
// 3. cycle sgould be in only one direction
// 4. origin can be any point in the array
// 5. cycle should contain more than one element


// stopping condition to find cycle is:
// we can use fast-slow pointer approach to achieve this with conditions ->
// fast will be used to make the directional changes.
// if fast == slow, we have found loop
public class CycleInArray {

    public static boolean loopExists(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean isForward = arr[i] >= 0; // if we are moving forward or not
            int slow = i, fast = i;

            // if slow or fast becomes '-1' this means we can't find cycle for this number
            do {
                slow = findNextIndex(arr, isForward, slow); // move one step for slow pointer

                fast = findNextIndex(arr, isForward, fast); // move one step for fast pointer
                if (fast != -1)
                    fast = findNextIndex(arr, isForward, fast);// move another step for fast pointer

            } while (slow != -1 && fast != -1 && slow != fast);

            if (slow != -1 && slow == fast)
                return true;
        }

        return false;
    }

    private static int findNextIndex(int[] arr, boolean isForward, int currentIndex) {
        boolean direction = arr[currentIndex] >= 0;
        if (isForward != direction)
            return -1; // change in direction, return -1

        int nextIndex = (currentIndex + arr[currentIndex]) % arr.length;

        if (nextIndex < 0)
            nextIndex += arr.length; // wrap around for negative numbers

        // one element cycle, return -1
        if (nextIndex == currentIndex)
            nextIndex = -1;

        return nextIndex;
    }

    public static void main(String[] args) {
        System.out.println(loopExists(new int[] { 1, 2, -1, 2, 2 }));
        System.out.println(loopExists(new int[] { 2, 2, -1, 2 }));
        System.out.println(loopExists(new int[] { 2, 1, -1, -2 }));
    }
}
