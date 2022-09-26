package com.solid.algolearning.javacode.algorithms.backtracking;

public class UniquePaths3 {
    public static void main(String[] args) {

        int[][] grid = new int[][]{{1,0,0,0,0,0,0,0,0,0},
                                    {0,0,0,0,0,0,0,0,0,0},
                                    {0,0,0,0,0,0,0,0,0,0},
                                    {0,0,0,0,0,0,0,0,0,0},
                                    {0,0,0,0,0,0,0,0,0,0},
                                    {0,0,0,0,0,0,0,0,0,0},
                                    {0,0,0,0,0,0,0,0,0,0}, //
                                    {0,0,0,0,0,0,0,-1,-1,-1},
                                    {0,0,0,0,0,0,0,-1,0,0},
                                    {0,0,0,0,0,0,0,0,0,2}};

        int[][] grid2 = new int[][]{{1,-1,-1,-1},
                                    {0,-1,0,0},
                                    {0,0,0,2}};


        System.out.println(uniquePathsIII(grid2));
    }

    public static int uniquePathsIII(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];

//        for(int i = 0; i < row; i++){
//            for(int j = 0; j < col; j++){
//                if(grid[i][j] == 1){
//
//                }
//            }
//        }

        return helper(0, 0, row, col, grid, dp);

//        return 0;
    }


    public static int helper(int r, int c, int row, int col, int[][] grid, int[][] dp) {
        //check if we have exceeded or the value we are looking at is an obstacle, return 0
        if (r < 0 || c < 0 || r == row || c == col || grid[r][c] == -1) return 0;

        //if we have reached the ending space, check if the there is obstacle there, and return 0
        //cos we cannot have an obstacle at the goal point
//        if (grid[r][c] == 2) {
//            if (isValid(grid))
//                return 1;
//            else
//                return 0;
//        }

        System.out.println("(" + r + ", " + c + ")");

        if (r == row - 1 && c == col - 1) {
            if (grid[r][c] == -1)
                return 0;
            else{
                System.out.println();
                return 1;
            }

        }

        if (dp[r][c] > 0) { //if we have something stored for the space we are on in memo, return it.
            return dp[r][c];
        }

        int ans = 0;

        grid[r][c] = -1;
        ans += helper(r + 1, c, row, col, grid, dp); //move down
        ans += helper(r, c + 1, row, col, grid, dp);//move right
        ans += helper(r - 1, c, row, col, grid, dp);//move up
        ans += helper(r, c - 1, row, col, grid, dp);//move left
        grid[r][c] = 0;   //backtrack

        return ans;
    }

//    public static boolean isValid(int[][] grid) {
//        for (int[] ints : grid) {
//            for (int j = 0; j < grid[0].length; j++) {
//                if (ints[j] == 0)
//                    return false;
//            }
//        }
//        return true;
//    }
}
