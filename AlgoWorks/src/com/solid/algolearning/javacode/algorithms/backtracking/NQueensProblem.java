package com.solid.algolearning.javacode.algorithms.backtracking;
//Problem Statement:
// Given an NxN board, place N chess queens and display the placement of the N queens on the board,
// and also return the number of possible ways to place N quees on the board.
public class NQueensProblem {

    public static void main(String[] args) {
        int n = 5;
        boolean[][] board = new boolean[n][n];

        System.out.println(queens(board, 0));
    }

    static  int queens( boolean[][] board, int row ){ //return the number of ways we can place queens, true means the queen is placed, we are starting col from 0 all the time no neeed to pass it in paaram
      if(row == board.length){  //base case, if we hit the max row
          display(board);
          return 1;
      }

      int count = 0;  //count to hold the number of ways
      //we are now placing the queen and checking for validity for every row and column
        for(int col = 0; col < board.length; col++){ // as we loop through the column
          // place the queen if it is safe
            if(isSafe(board, row, col)){
                board[row][col] = true;    //this row has a queen placed in it.
                count = count + queens(board, row + 1);   //try to see if a queen can be placed in the below rows or not.
                board[row][col] = false;        // when we come out of the recursive function call, change the places visited or placed to not placed (backtrack)
            }
        }

        return count;
    }

    //method to check if it is safe to place a queen in a specific column in a row
    //this method checks for the upper rows of the column it is sitting in to see
    //if queens have been placed in that same column before,
    //then checks for the upper left and right diagonal using the formulars we derived in the notes.
    private static boolean isSafe(boolean[][] board, int row, int col) {
        // check vertical rows upwards for the specific column the queen is trying to be placed
        for (int i = 0; i < row; i++) {
            if(board[i][col]){ //if this is true, it means that there is a queen sitting there.
              return false;    // hence, it is not safe to place it there
            }
        }

        //for left diagonal check
        int maxLeft = Math.min(row, col); // this is the maximum times we have to go back to check if queen is safe to place there left diagonally
        for (int i = 0; i < maxLeft; i++) {
            if(board[row - 1][col - 1]){
                return false;    // hence, it is not safe to place it there
            }
        }

        //for left diagonal check
        int maxRight = Math.min(row, board.length - col - 1); // this is the maximum times we have to go back to check if queen is safe to place there left diagonally
        for (int i = 0; i < maxRight; i++) {
            if(board[row - 1][col + 1]){
                return false;   // hence, it is not safe to place it there
            }
        }

      return true;     //if none of the above returns false, then it is safe to place the queen there.
    }

    //method to diaplay the board when we hit the base case
    private static void display(boolean[][] board) {
        for(boolean[] row : board){
            for(boolean element : row){
                if(element){
                    System.out.print("Q ");
                }else System.out.print("X ");
            }
            System.out.println();
        }
        System.out.println();
    }
}





