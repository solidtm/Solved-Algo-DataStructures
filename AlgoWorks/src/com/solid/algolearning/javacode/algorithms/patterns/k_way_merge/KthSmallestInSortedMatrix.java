package com.solid.algolearning.javacode.algorithms.patterns.k_way_merge;
//Problem Statement#
//        Given an N * N
//        N∗N
//        matrix where each row and column is sorted in ascending order, find the Kth smallest element in the matrix.
//
//        Example 1:
//
//        Input: Matrix=[
//        [2, 6, 8],
//        [3, 7, 10],
//        [5, 8, 11]
//        ],
//        K=5
//        Output: 7
//        Explanation: The 5th smallest number in the matrix is 7.

import java.util.*;
public class KthSmallestInSortedMatrix {
    static class Node {
        int row;
        int col;

        Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static int findKthSmallest(int[][] matrix, int k) {
        PriorityQueue<Node> minHeap = new PriorityQueue<>((n1, n2) -> matrix[n1.row][n1.col] - matrix[n2.row][n2.col]);

        // put the 1st element of each row in the min heap
        // we don't need to push more than 'k' elements in the heap
        for (int i = 0; i < matrix.length && i < k; i++)
            minHeap.add(new Node(i, 0));

        // take the smallest (top) element form the min heap, if the running count is equal to k return the number
        // if the row of the top element has more elements, add the next element to the heap
        int numberCount = 0, result = 0;
        while (!minHeap.isEmpty()) {
            Node node = minHeap.poll();
            result = matrix[node.row][node.col];
            if (++numberCount == k) break;
            node.col++;
            if (matrix[0].length > node.col)
                minHeap.add(node);
        }
        return result;
    }

    public static void main(String[] args) {
        int matrix[][] = { { 2, 6, 8 }, { 3, 7, 10 }, { 5, 8, 11 } };
        int result = KthSmallestInSortedMatrix.findKthSmallest(matrix, 5);
        System.out.print("Kth smallest number is: " + result);
    }
}
