package com.solid.algolearning.javacode.algorithms.patterns.modified_binary_search.bs_matrix;

import java.util.Arrays;

public class SortedMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        System.out.println(Arrays.toString(search(matrix, 6)));
        System.out.println(Arrays.toString(search(matrix, 49)));
        System.out.println(Arrays.toString(search(matrix, 9)));
    }

    //binary search on 2d array
    static int[] search(int[][] matrix, int target){
        //it may be possible that the array is of one dimension so:
        int row = matrix.length;
        int col = matrix[0].length;  //be cautious over here, matrix may be empty, so put the check for it.

        if(row == 1){ //we have only one element
            return binarySearch(matrix, 0, 0, col, target); //just do bs on the one row/col we have
        }

        int rowStart = 0;
        int rowEnd = row - 1;    // end of row because of 0-indexing
        int colMid = col / 2;   //total column divided by 2 to get the middle column

        //run the loop till two rows are remaining
        while (rowStart < (rowEnd - 1)){ //while this is true, it will have more than 2 rows
            int mid = rowStart + (rowEnd - rowStart) / 2;
            if(matrix[mid][colMid] == target){ //we have found the target, return it
                return new int[]{mid, colMid};
            }

            if(matrix[mid][colMid] < target){ //ignore the above rows
                rowStart = mid;
            }else{
                rowEnd = mid;
            }
        }

        //now we have 2 rows left;
        //check wheteher the target is in the column of the 2 rows
        if(matrix[rowStart][colMid] == target){ //for row 1
            return new int[]{rowStart, colMid};
        }

        if(matrix[rowStart + 1][colMid] == target){ //for row 2
            return new int[]{rowStart + 1, colMid};
        }

        //Other-wise search in 1st, 2nd 3rd and 4th half
        //search in 1st half
        if(target <= matrix[rowStart][colMid - 1]){
            return binarySearch(matrix, rowStart, 0, colMid - 1, target);
        }
        //search in second half
        if(target >= matrix[rowStart][colMid + 1] && (target <= matrix[rowStart][col - 1])){ // put check that the target is not greater than the value at the last colindex for rowStart
            return binarySearch(matrix, rowStart, colMid + 1, col - 1, target);
        }
        //search in third half
        if(target <= matrix[rowStart + 1][colMid - 1]){
            return binarySearch(matrix, rowStart + 1, 0, colMid - 1, target);
        }else{//search in 4th half
            return binarySearch(matrix, rowStart + 1, colMid + 1, col - 1, target);
        }
        //search in 4th half
//        if(target >= matrix[rowStart + 1][colMid + 1]){
//
//        }
    }


    //this is the binary search function we will use to perform binary search on the rows
    //search in the row provided between the columns provided.
    static int[] binarySearch(int[][] matrix, int row, int colStart, int colEnd, int target){
        while(colStart <= colEnd){
            int mid = colStart + (colEnd - colStart) / 2;

            if(matrix[row][mid] == target){
                return new int[]{row, mid};
            }

            if(matrix[row][mid] < target){
               colStart = mid + 1;
            }else{
                colEnd = mid - 1;
            }
        }

        return new int[]{-1, -1};
    }
}
