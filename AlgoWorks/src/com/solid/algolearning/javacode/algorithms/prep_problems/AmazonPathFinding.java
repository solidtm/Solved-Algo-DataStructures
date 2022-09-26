package com.solid.algolearning.javacode.algorithms.prep_problems;

public class AmazonPathFinding {
    public static void main(String[] args) {
        int[][] obstacleGrid = new int[][]{{0,0,0,0,0,0,0,0,0,0},
                                           {0,0,0,0,0,0,0,0,0,0},
                                           {0,0,0,0,0,0,0,0,0,0},
                                           {0,0,0,0,0,0,0,0,0,0},
                                           {0,0,0,0,0,0,0,0,0,0},
                                           {0,0,0,0,0,0,0,0,0,0},
                                           {0,0,0,0,0,0,0,0,0,0},
                                           {0,0,0,0,0,0,0,1,1,1},
                                           {0,0,0,0,0,0,0,1,0,0},
                                           {0,0,0,0,0,0,0,0,0,0}};

        validPathWithObstacles(obstacleGrid);
    }

    public static void validPathWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int res = 0;

        int[][] dp = new int[row][col];
        if (obstacleGrid[0][0] == 0){
            res =  helper(0, 0, row, col, obstacleGrid, dp);
        }

        if (res == 0){
            System.out.println("Unable to reach delivery point");
        }

        System.out.println("Number of steps: " + res);
    }

    public static int helper(int r, int c, int row, int col, int[][] obstacleGrid, int[][] dp){
        //check if we have exceeded boundaries or the value we are looking at is an obstacle, return 0
        if(r < 0 || c < 0 || r == row || c == col || obstacleGrid[r][c] == 1) return 0;

        System.out.println("(" + r + ", " + c + ")");
        //if we have reached the target space, check if the there is obstacle there, and return 0
        //cos we cannot have an obstacle at the goal point
        if(r == row - 1 && c == col - 1){
            if(obstacleGrid[r][c] == 1){
                return 0;
            }
            System.out.println();
            return 1;
        }

        if(dp[r][c] > 0){ //if we have something stored for the space we are on in memo, return it.
            return dp[r][c];
        }

        obstacleGrid[r][c] = 1;
        int down = helper(r + 1, c, row, col, obstacleGrid, dp); //move down
        int right = helper(r, c + 1 , row, col, obstacleGrid, dp);//move right
        int up = helper(r - 1, c, row, col, obstacleGrid, dp); //move down
        int left = helper(r, c - 1 , row, col, obstacleGrid, dp);//move right
        int diag = helper(r + 1, c + 1, row, col, obstacleGrid, dp); //move diagonal

        return dp[r][c] = down + right + up + left + diag;
    }
}