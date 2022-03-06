package com.solid.algolearning.javacode.algorithms.patterns.modified_binary_search.bs_matrix;

import java.util.Arrays;

public class RowColMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {28, 29, 37, 49},
                {33, 34, 38, 50}
        };

        System.out.println(Arrays.toString(search(matrix, 37)));
        System.out.println(Arrays.toString(search(matrix, 49)));
        System.out.println(Arrays.toString(search(matrix, 39)));
    }

    static int[] search(int[][] matrix, int target){
        int row = 0;   //start
        int col = matrix.length -  1;  //end

        while (row <  matrix.length  && col >= 0){
            //if we have actually found the answer return the corresponding row and column
            if(matrix[row][col] == target){
                return new int[]{row, col};
            }

            //if the value is lower than the target, we just increment the row otherwise we decrement the column
            if(matrix[row][col] < target){
                row++;
            }else {
                col--;
            }
        }

        return new int[]{-1, -1};
    }
}
