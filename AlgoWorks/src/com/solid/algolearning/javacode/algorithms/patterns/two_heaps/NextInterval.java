package com.solid.algolearning.javacode.algorithms.patterns.two_heaps;

// Next Interval (hard)#
//        Given an array of intervals, find the next interval of each interval. In a list of intervals, for an interval ‘i’ its next interval ‘j’ will have the smallest ‘start’ greater than or equal to the ‘end’ of ‘i’.
//
//        Write a function to return an array containing indices of the next interval of each input interval. If there is no next interval of a given interval, return -1. It is given that none of the intervals have the same start point.
//
//        Example 1:
//
//        Input: Intervals [[2,3], [3,4], [5,6]]
//        Output: [1, 2, -1]
//        Explanation: The next interval of [2,3] is [3,4] having index ‘1’. Similarly, the next interval of [3,4] is [5,6] having index ‘2’. There is no next interval for [5,6] hence we have ‘-1’.
//
//        Example 2:
//
//        Input: Intervals [[3,4], [1,5], [4,6]]
//        Output: [2, -1, -1]
//        Explanation: The next interval of [3,4] is [4,6] which has index ‘2’. There is no next interval for [1,5] and [4,6].


// Solution#
//        A brute force solution could be to take one interval at a time and go through all the other intervals to find the next interval.
//        This algorithm will take O(N^2) where N is the total number of intervals. Can we do better than that?
//
//        We can utilize the Two Heaps approach. We can push all intervals into two heaps: one heap to sort the intervals on maximum start time (let’s call it maxStartHeap) and the other on maximum end time (let’s call it maxEndHeap). We can then iterate through all intervals of the maxEndHeap to find their next interval. Our algorithm will have the following steps:
//
//        Take out the top (having the highest end) interval from the maxEndHeap to find its next interval. Let’s call this interval topEnd.
//        Find an interval in the maxStartHeap with the closest start greater than or equal to the start of topEnd. Since maxStartHeap is sorted by ‘start’ of intervals, it is easy to find the interval with the highest ‘start’. Let’s call this interval topStart.
//        Add the index of topStart in the result array as the next interval of topEnd. If we can’t find the next interval, add ‘-1’ in the result array.
//        Put the topStart back in the maxStartHeap, as it could be the next interval of other intervals.
//        Repeat steps 1-4 until we have no intervals left in maxEndHeap.
//        Code#
//        Here is what our algorithm will look like:

import java.util.*;
public class NextInterval {

    static class Interval {
        int start;
        int end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static int[] findNextInterval(Interval[] intervals) {
        int n = intervals.length;
        // heap for finding the maximum start
        PriorityQueue<Integer> maxStartHeap = new PriorityQueue<>(n, (i1, i2) -> intervals[i2].start - intervals[i1].start);
        // heap for finding the minimum end
        PriorityQueue<Integer> maxEndHeap = new PriorityQueue<>(n, (i1, i2) -> intervals[i2].end - intervals[i1].end);
        int[] result = new int[n];
        for (int i = 0; i < intervals.length; i++) {
            maxStartHeap.offer(i);
            maxEndHeap.offer(i);
        }

        // go through all the intervals to find each interval's next interval
        for (int i = 0; i < n; i++) {
            int topEnd = maxEndHeap.poll(); // let's find the next interval of the interval which has the highest 'end'
            result[topEnd] = -1; // defaults to -1
            if (intervals[maxStartHeap.peek()].start >= intervals[topEnd].end) {
                int topStart = maxStartHeap.poll();
                // find the interval that has the closest 'start'
                while (!maxStartHeap.isEmpty() && intervals[maxStartHeap.peek()].start >= intervals[topEnd].end) {
                    topStart = maxStartHeap.poll();
                }
                result[topEnd] = topStart;
                maxStartHeap.add(topStart); // put the interval back as it could be the next interval of other intervals
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Interval[] intervals = new Interval[] { new Interval(2, 3), new Interval(3, 4), new Interval(5, 6) };
        int[] result = findNextInterval(intervals);
        System.out.print("Next interval indices are: ");
        for (int index : result)
            System.out.print(index + " ");
        System.out.println();

        intervals = new Interval[] { new Interval(3, 4), new Interval(1, 5), new Interval(4, 6) };
        result = findNextInterval(intervals);
        System.out.print("Next interval indices are: ");
        for (int index : result)
            System.out.print(index + " ");
    }

//    Time complexity#
//    The time complexity of our algorithm will be O(NlogN),O(NlogN), where NN is the total number of intervals.
//
//    Space complexity#
//    The space complexity will be O(N)O(N) because we will be storing all the intervals in the heaps.
}
