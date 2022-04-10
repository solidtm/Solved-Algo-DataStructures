package com.solid.algolearning.javacode.algorithms.prep_problems;

//https://leetcode.com/problems/two-city-scheduling/

import java.util.*;
public class TwoCityScheduling {
    public static void main(String[] args) {
        System.out.println(twoCitySchedCost(new int[][]{{10,20},{30,200},{400,50},{30,20}}));
    }

    public static int twoCitySchedCost(int[][] costs) {
        int ans = 0;
        Arrays.sort(costs, Comparator.comparingInt(a -> (a[0] - a[1])));
        System.out.println(Arrays.deepToString(costs));


        for(int i = 0; i < costs.length / 2; i++){
            ans = ans + costs[i][0];

        }

        for(int i = costs.length / 2; i < costs.length; i++){
            ans = ans + costs[i][1];

        }
        return ans;
    }
}
