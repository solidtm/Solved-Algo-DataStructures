package com.solid.algolearning.javacode.algorithms.dynamic_programming.dp_problems;

public class GridPathsTopDown {
    public static void main(String[] args) {
        int[][] grid = new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};

        System.out.println(findPaths(grid));
    }

    public static int findPaths(int[][] grid){
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];

        return helper(grid, 0, 0, row, col, dp);
    }


    public static int helper(int[][] grid,  int r, int c, int row, int col, int[][] dp){
        if(r == row - 1 || c == col - 1) return 1;

        if(dp[r][c] != 0) return dp[r][c];


        int right = helper(grid, r, c + 1, row, col, dp);  //moving right
        int down = helper(grid, r + 1, c, row, col, dp);  //moving down

        return dp[r][c] = right + down;
    }
}
