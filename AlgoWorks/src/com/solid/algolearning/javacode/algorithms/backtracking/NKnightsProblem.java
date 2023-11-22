package com.solid.algolearning.javacode.algorithms.backtracking;

public class NKnightsProblem {
    public static void main(String[] args) {
        int n = 3;
      boolean[][] board = new boolean[n][n];

      placeKnights(board, 0, 0, n);
    }


    static void placeKnights(boolean[][] board, int row, int col, int knights){
       if(knights == 0){
           display(board);
           System.out.println();
           return;
       }

        if(row == board.length - 1 && col == board.length){
            return;
        }

       if(col == board.length){ //if we hit the end of the column we return from the call
           placeKnights(board, row + 1, 0, knights);  //and check the next row
           return;
       }


       if(isSafe(board, row, col)){ //if it is safe to place knight
           board[row][col] = true;   //place knight
           placeKnights(board, row, col + 1, knights - 1);  // check for the next column
           board[row][col] = false;  //backtrack
       }

       placeKnights(board, row, col + 1, knights); //recursively check the next columns for remaining knights
    }


    //method to check if actually we are not out of bounds befopre checking if it is safe to place the knight
    private static  boolean isValid(boolean[][] board, int row, int col){
       if(row >= 0 && row < board.length && col >= 0 && col < board.length) {
           return true;
       }
       return false;  // return true if we are not out of bounds, else false
    }


    private static boolean isSafe(boolean[][] board, int row, int col){
       if(isValid(board, row, col)){ //if we are not out of bounds
           if(board[row][col]){ //check if a knight is available there or not
               return false;
           }
       }

       //check for going up and left
        if(isValid(board, row - 2, col - 1)){ //if we are not out of bounds
            if(board[row - 2][col - 1]){ //check if a knight is available there or not
                return false;
            }
        }

        //check for going left and up
        if(isValid(board, row - 1, col - 2)){ //if we are not out of bounds
            if(board[row - 1][col - 2]){ //check if a knight is available there or not
                return false;
            }
        }

        //check for going up and right
        if(isValid(board, row - 2, col + 1)){ //if we are not out of bounds
            if(board[row - 2][col + 1]){ //check if a knight is available there or not
                return false;
            }
        }

        //check for going right and up
        if(isValid(board, row - 1, col + 2)){ //if we are not out of bounds
            if(board[row - 1][col + 2]){ //check if a knight is available there or not
                return false;
            }
        }

        return true;
    }



    private static void display(boolean[][] board) {
        for(boolean[] row : board){
            for(boolean element : row){
                if(element) System.out.print("K ");
                else System.out.print("X ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
