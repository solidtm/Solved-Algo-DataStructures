package com.solid.algolearning.javacode.algorithms.recursion.permutations;

import java.util.ArrayList;

// If you are at the start of a 3 x 3 maze/grid, how many possible ways can you go from a point to a target in the maze
// Follow-up question is to actually print the paths to the target point in the maze

public class Maze {
    public static void main(String[] args) {
        System.out.println(maze(3, 3));
        mazePaths("", 3, 3);
        System.out.println(mazePathsReturn("", 3, 3));
        System.out.println(mazePathsReturnWithDiagonal("", 3, 3));

        boolean[][] maze = {
                {true, true, true},
                {true, false, true},
                {true, true, true},
        };

        mazePathWithObstacle("", maze, 0, 0);
    }

    //Getting the number of possible ways
    static int maze(int row, int col) {
        if (row == 1 || col == 1) return 1; //base condition

        int left = maze(row - 1, col);
        int right = maze(row, col - 1);

        return left + right;
    }


    //If we are asked to print the actual paths to the target point in the maze

    static void mazePaths(String p, int row, int col) {
        if (row == 1 && col == 1) {
            System.out.println(p);
            return;
        }

        if (row > 1) {
            mazePaths(p + 'D', row - 1, col);
        }

        if (col > 1) {
            mazePaths(p + 'R', row, col - 1);
        }
    }


    //If we are asked to get the actual paths to the target point in the maze and return it in an arraylist
    static ArrayList<String> mazePathsReturn(String p, int row, int col) {
        if (row == 1 && col == 1) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList<String> ans = new ArrayList<>();
        if (row > 1) {
            ans.addAll(mazePathsReturn(p + 'D', row - 1, col));
        }

        if (col > 1) {
            ans.addAll(mazePathsReturn(p + 'R', row, col - 1));
        }

        return ans;
    }

    //What If we were told that we could go both down, right, and diagonal?
    static ArrayList<String> mazePathsReturnWithDiagonal(String p, int hor, int ver) {
        if (hor == 1 && ver == 1) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList<String> ans = new ArrayList<>();
        if (hor > 1 && ver > 1) {
            ans.addAll(mazePathsReturnWithDiagonal(p + 'D', hor - 1, ver - 1));
        }

        if (hor > 1) {
            ans.addAll(mazePathsReturnWithDiagonal(p + 'H', hor - 1, ver));
        }

        if (ver > 1) {
            ans.addAll(mazePathsReturnWithDiagonal(p + 'V', hor, ver - 1));
        }

        return ans;
    }

    //What if we were told that we had a river at (1, 1) in the matrix, and this time we are going from (0, 0) no longer (3, 3)
    // we want to print all the possible paths to the target at (2, 2), since we are moving from (0, 0)

    static void mazePathWithObstacle(String p, boolean[][] maze, int row, int col) {
        if (row == maze.length - 1 && col == maze[0].length - 1) {  //if the row n col hit the end of the matrix we return.
            System.out.println(p);
            return;
        } //base condition

        if(!maze[row][col]){
           return;
        }//base condition for the encounter of the river/obstacle, the matrix is a grid of boolean values(true/false)

        if (row < maze.length - 1) {
            mazePathWithObstacle(p + 'D', maze, row + 1, col); //move down OR
        }

        if (col < maze[0].length - 1) {
            mazePathWithObstacle(p + 'R', maze, row, col + 1);  // move right
        }
    }
}














