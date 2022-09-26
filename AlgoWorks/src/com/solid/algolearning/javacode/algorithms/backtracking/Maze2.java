package com.solid.algolearning.javacode.algorithms.backtracking;

import java.util.Arrays;

public class Maze2 {
    public static void main(String[] args) {

        boolean[][] maze = {
                {true, true, true},
                {true, false, false},
                {true, true, true},
        };

        int[][] path = new int[maze.length][maze[0].length];
        allPathsWithAllDirections("", maze, 0, 0);
        System.out.println();
        System.out.println();
        allPathsPrintWithAllDirections("", maze, 0, 0, path, 1);
    }

    //Let us assume we were also told
    // that we can move from (0, 0) to our target,
    // but we can now mive in all directions Up, Down, Left and Right.

    static void allPathsWithAllDirections(String p, boolean[][] maze, int row, int col) {
        if (row == maze.length - 1 && col == maze[0].length - 1) {  //if the row n col hit the end of the matrix we return.
            System.out.println(p);
            return;
        } //base condition

        if(!maze[row][col]){
            return;
        }//base condition for if the cell/block has been visited, the matrix is a grid of boolean values(true/false)

        //else, since the block is not false, it means this block is in my path and I will set it to false
        maze[row][col] = false;


        if (row < maze.length - 1) {
            allPathsWithAllDirections(p + 'D', maze, row + 1, col); //move down OR
        }

        if (col < maze[0].length - 1) {
            allPathsWithAllDirections(p + 'R', maze, row, col + 1);  // move right
        }

        if (row > 0) {
            allPathsWithAllDirections(p + 'U', maze, row - 1, col);  // move up
        }

        if (col > 0) {
            allPathsWithAllDirections(p + 'L', maze, row, col - 1);  // move left
        }

        //this is where the function is returning or is over
        //so before the function gets removed from the function call, also remove the changes that were made by that call.
        //this is what backtracking is all about
        maze[row][col] = true;
    }


//    Here we are trying to print all paths and all the directions moved as a grid itself

    static void allPathsPrintWithAllDirections(String p, boolean[][] maze, int row, int col, int[][] path, int step) {
        if (row == maze.length - 1 && col == maze[0].length - 1) {  //if the row n col hit the end of the matrix we return.
            path[row][col] = step; // the last value is also a path too so add it.
            for(int[] arr : path){
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(p); //print the path itself
            System.out.println();
            return;
        } //base condition

        if(!maze[row][col]){
            return;
        }//base condition for if the cell/block has been visited, the matrix is a grid of boolean values(true/false)

        //else, since the block is not false, it means this block is in my path, and I will set it to false
        maze[row][col] = false; // mark that cell as visited
        path[row][col] = step;  // add the step moved to the path

        if (row < maze.length - 1) {  //moving down
            allPathsPrintWithAllDirections(p + 'D', maze, row + 1, col, path, step + 1); //move down OR
        }

        if (col < maze[0].length - 1) {//moving right
            allPathsPrintWithAllDirections(p + 'R', maze, row, col + 1, path, step + 1);  // move right
        }

        if (row > 0) { //moving up
            allPathsPrintWithAllDirections(p + 'U', maze, row - 1, col, path, step + 1);  // move up
        }

        if (col > 0) { //moving left
            allPathsPrintWithAllDirections(p + 'L', maze, row, col - 1, path, step + 1);  // move left
        }

        //this is where the function is returning or is over
        //so before the function gets removed from the function call, also remove the changes that were made by that call.
        //this is what backtracking is all about
        maze[row][col] = true; //remark the cell as not visited
        path[row][col] = 0;   // set the values for the path to zero since we are going back.
    }
}
