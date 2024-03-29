package com.solid.algolearning.javacode.algorithms.patterns.k_way_merge;

//K Pairs with Largest Sums (Hard)#
//        Given two sorted arrays in descending order, find ‘K’ pairs with the largest sum where
//        each pair consists of numbers from both the arrays.
//
//        Example 1:
//
//        Input: L1=[9, 8, 2], L2=[6, 3, 1], K=3
//        Output: [9, 3], [9, 6], [8, 6]
//        Explanation: These 3 pairs have the largest sum. No other pair has a sum larger than any of these.
//        Example 2:
//
//        Input: L1=[5, 2, 1], L2=[2, -1], K=3
//        Output: [5, 2], [5, -1], [2, 2]

import java.util.*;
public class KPairsWithLargestSum {
    public static List<int[]> findKLargestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>((p1, p2) -> (p1[0] + p1[1]) - (p2[0] + p2[1]));
        for (int i = 0; i < nums1.length && i < k; i++) {
            for (int j = 0; j < nums2.length && j < k; j++) {
                if (minHeap.size() < k) {
                    minHeap.add(new int[] { nums1[i], nums2[j]});
                } else {
                    // if the sum of the two numbers from the two arrays is smaller than the smallest (top) element of
                    // the heap, we can 'break' here. Since the arrays are sorted in the descending order, we'll not be
                    // able to find a pair with a higher sum moving forward.
                    if (nums1[i] + nums2[j] < minHeap.peek()[0] + minHeap.peek()[1]) {
                        break;
                    } else { // else: we have a pair with a larger sum, remove top and insert this pair in the heap
                        minHeap.poll();
                        minHeap.add(new int[] { nums1[i], nums2[j] });
                    }
                }
            }
        }
        return new ArrayList<>(minHeap);
    }

    public static void main(String[] args) {
        int[] l1 = new int[] { 9, 8, 2 };
        int[] l2 = new int[] { 6, 3, 1 };
        List<int[]> result = findKLargestPairs(l1, l2, 3);
        System.out.print("Pairs with largest sum are: ");
        for (int[] pair : result)
            System.out.print("[" + pair[0] + ", " + pair[1] + "] ");
    }
}
