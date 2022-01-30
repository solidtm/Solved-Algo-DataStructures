package com.solid.algolearning.javacode.algorithms.prep_problems;

public class FindTotalDistanceTravelled {

  /*You have a city where streets and avenues are perpendicular to each other.

  There are number of friends who are all located on various intersections.

  Given a target point (X, Y), find the total distance that every friend must travel to get to that point.

  Example 1
  # Points = [[1, 1], [3, 3], [6, 1]]  A=> [1,1], B=>[3,3] C=>[6,1]
  # Target [5, 5] -> 17
  # Target [6, 6] -> 21

  Example 2
  # Points = [[1, 2], [4, 5], [5, 5], [20, 10]]
  # Target [5, 5] -> 28
  # Target [6, 6] -> 32

  # Points = [[200, 40], [4, 5], [1, 2], [100, 20], [5, 8]]
  # Target [5, 5] -> 351
  # Target [6, 6] -> 351
  */

    public static int findTotalDistanceTravelled(int[][] arr, int[] target) {
        //algorithm
        // have a sum variable
        // loop through the list -> check for each index, the diff from target [simplified, since they are only 2 points]
        //sum the differences
        // assign the sum of the differences to the sum variable
        //return the cumulative sum.

        int sum = 0;
        for (int[] temp : arr) {
            //get the difference
            int diffX = Math.abs(target[0] - temp[0]);
            int diffY = Math.abs(target[1] - temp[1]);
            sum += diffX + diffY;
        }

        return sum;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,1}, {3,3}, {6, 1}};
        System.out.println(findTotalDistanceTravelled(arr, new int[]{5, 5}));
    }
}
