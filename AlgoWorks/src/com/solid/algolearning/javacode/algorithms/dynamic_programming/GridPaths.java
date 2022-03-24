package com.solid.algolearning.javacode.algorithms.dynamic_programming;

//https://cses.fi/problemset/task/1638

public class GridPaths {

    public static void main(String[] args) {
        System.out.println(gridPaths(new int[][] {{0,0,0}, {0,1,0}, {0,0,0}}));
    }

    //Here we have 2 options, either we go right, or we go down.
    //we are trying to go from 1,1 cell to n,n cell
    //and, we will avoid all the obstacles
    static int gridPaths(int[][] grid){

        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        return helper(0, 0 , m, n, grid, dp);
    }

    private static int helper(int row, int col, int m, int n, int[][] grid, int[][] dp) {
        if(row == m || col == n || grid[row][col] == 1) return 0;

        if(row == m - 1 && col == n - 1){
            if (grid[row][col] == 1) return 0;
            return 1;
        }

        if(dp[row][col] != 0) return dp[row][col];

        int down = helper(row + 1, col, m, n, grid, dp);
        int right = helper(row, col + 1, m, n, grid, dp);

        return dp[row][col] = down + right;
    }
}
