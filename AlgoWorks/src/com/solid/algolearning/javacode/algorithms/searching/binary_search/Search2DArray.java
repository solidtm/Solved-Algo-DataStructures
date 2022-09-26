package com.solid.algolearning.javacode.algorithms.searching.binary_search;

///Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix.
// This matrix has the following properties:
//
//        Integers in each row are sorted from left to right.
//        The first integer of each row is greater than the last integer of the previous row.
public class Search2DArray {
    public static void main(String[] args) {
        int[][] nums = new int[][]{{1, 2}, {4, 5}};

        System.out.println(searchMatrix(nums, 2));
    }

    // we could think of the array as a linear array since it is all sorted in ascending order
    // then we can perform binary search on it.
    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length; //rows
        int n = matrix[0].length; //cols

        int start = 0, end = m * n - 1;

        while(start <= end)
        {
            int mid = start + (end - start) / 2;

            if(target == matrix[mid / n][mid % n])
                return true;

            if(target > matrix[mid / n][mid % n])
                start = mid + 1;
            else
                end = mid - 1;
        }

        return false;
    }
}
