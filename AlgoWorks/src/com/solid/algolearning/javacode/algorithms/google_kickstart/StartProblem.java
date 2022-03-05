package com.solid.algolearning.javacode.algorithms.google_kickstart;

import java.util.*;

public class StartProblem {
    public static int remainingCandy(int[] candies,
                                     int numOfKids, int noOfCandyBags) {
        int totalCandies = 0;
        int remainingCandies = 0;

        for (int i = 0; i < candies.length; i++) {
            totalCandies += candies[i];
        }

        remainingCandies = totalCandies % numOfKids;

        return remainingCandies;
    }

//    Sample Input
//                 2
//                7 3
//                1 2 3 4 5 6 7
//                5 10
//                7 7 7 7 7

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int T = in.nextInt();    //enter number of test cases

            for (int t = 1; t <= T; ++t) {
                int bags, kids;
                bags = in.nextInt();    //enter number of bags
                kids = in.nextInt();
                //enter number of kids
                int[] candies = new int[bags];   //number of candies in each bag

                for (int j = 0; j < bags; ++j) {  //loop through each bag and initialize the number of candies for each bag
                    candies[j] = in.nextInt();
                }

                System.out.println(
                        "Case #" + t + ": " + remainingCandy(candies, kids, bags));
            }
        }
    }
}
