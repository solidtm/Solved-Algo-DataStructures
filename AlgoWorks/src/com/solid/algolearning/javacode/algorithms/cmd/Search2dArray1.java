package com.solid.algolearning.javacode.algorithms.cmd;

public class Search2dArray1 {
    static boolean searchMatrix(int[][] matrix, int target) {
        //algorithm
        //i can perform a binary search to approach at O(log(mn))

        // high = l - 1;
        // int start = 0, midpoint = start + (high - start) / 2;
        //row = i / noOfColumns
        // column = i % noOfColumns

        int start = 0; //6
        int l = matrix.length, noOfColumns = matrix[0].length;
        int midpoint = start + (l - start) / 2;


        int row = midpoint / noOfColumns;
        int col = midpoint % noOfColumns;

        return binarySearchMatrix(matrix, row, col, target, midpoint);
    }


    static boolean binarySearchMatrix(int[][] matrix, int row, int col, int target, int midpoint){
        if(matrix[row][col] == target){
            return true;
        }else if(matrix[row][col] < target){
            int l = midpoint - 1;
            midpoint = (l) / 2;
            row = midpoint / matrix[0].length;
            col = midpoint % matrix[0].length;
            return binarySearchMatrix(matrix, row, col - 1, target, midpoint);
        }else{
            int l = midpoint + 1;
            midpoint = (l) / 2;
            row = midpoint / matrix[0].length;
            col = midpoint % matrix[0].length;
            return binarySearchMatrix(matrix, row, col + 1, target, midpoint);
        }
    }

    public static void main(String[] args) {
        System.out.println(searchMatrix(new int[][]{ { 1,3,5,7 }, { 10,11,16,20 }, {23,30,34,60} }, 3));
//        System.out.println(searchMatrix(new int[][]{ { 1,3,5,7 }, { 10,11,16,20 }, {23,30,34,60} }, 13));
    }
}
