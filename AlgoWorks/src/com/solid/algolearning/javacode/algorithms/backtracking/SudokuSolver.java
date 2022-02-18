package com.solid.algolearning.javacode.algorithms.backtracking;

public class SudokuSolver {
    public static void main(String[] args) {

       int[][] board = {{5, 3, 0, 0, 7, 0, 0, 0, 0},
                       {6 , 0, 0, 1, 9, 5, 0, 0, 0},
                       {0, 9, 8, 0, 0, 0, 0, 6, 0},
                       {8, 0, 0, 0, 6, 0, 0, 0, 3},
                       {4, 0, 0, 8, 0, 3, 0, 0, 1},
                       {7, 0, 0, 0, 2, 0, 0, 0, 6},
                       {0, 6, 0, 0, 0, 0, 2, 8, 0},
                       {0, 0, 0, 4, 1, 9, 0, 0, 5},
                       {0, 0, 0, 0, 8, 0, 0, 7, 9}};

       if(sudokuSolver(board)){
           display(board);
       }else{
           System.out.println("Cannot solve");
       }

    }

    static boolean sudokuSolver(int[][] board){
        int n = board.length;
        int row = -1;
        int col = -1;

        boolean emptyLeft = true; // variable to check if any empty places are left

        //this is how we are replacing the row and column from arguments
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
              if(board[i][j] == 0){  //we have found one of the possible answers
                  row = i;
                  col = j;
                  emptyLeft = false;
                  break;
              }
            }
            //if you found some empty element in row, then break
            if(!emptyLeft){
                break;
            }
        }

        if (emptyLeft){
            return true; //sudoku is solved
        }

        for (int number = 1; number <= n; number++){
           if(isSafe(board, row, col, number)){
               board[row][col] = number;
               if(sudokuSolver(board)) {
                   return true;  //have found the answer
               }
                 //backtrack
           }else board[row][col] = 0;
        }

        return false;  //this means that sudoku cannot be solved.
    }


    // method to display the board values
    private static void display(int[][] board) {
        for(int[] row : board){
            for(int num : row){
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }



    static boolean isSafe(int[][] board, int row, int col, int num){
        //check the row
        for (int i = 0; i < board.length; i++) {
            if(board[row][col] == num){
                return false;
            }
        }

        //check the column
        for (int[] nums : board) {
            if(nums[col] == num){
                return false;
            }
        }

        //check the grid by getting the starting row and column of the grid
        int sqrt = (int) (Math.sqrt(board.length));
        int rowStart = row - row % sqrt;
        int colStart = col - col % sqrt;

        for (int r = rowStart; r < rowStart + sqrt; r++) { //loop through from start positions
            for (int c = colStart; c < colStart + sqrt; c++) {
                if(board[r][c] == num){  //if the cell is not
                    return false;
                }
            }
        }

        return true;
    }
}
