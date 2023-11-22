package com.solid.algolearning.javacode.algorithms.patterns.subsets;
import java.util.*;
//Problem Statement#
//        Given a set with distinct elements, find all of its distinct subsets.
//
//        Example 1:
//        Input: [1, 3]
//        Output: [], [1], [3], [1,3]
//        Example 2:
//
//        Input: [1, 5, 3]
//        Output: [], [1], [5], [3], [1,5], [1,3], [5,3], [1,5,3]

public class Subsets {
    public static void main(String[] args) {
        System.out.println(getSubsets(new int[]{1, 3}));
        System.out.println(getSubsets(new int[]{1, 5, 3}));
    }

    public static List<List<Integer>> getSubsets(int[] nums){
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());

        for(int currNum : nums){
            int size = subsets.size();

            for(int i = 0; i < size; i++){
                List<Integer> set = new ArrayList<>(subsets.get(i));
                set.add(currNum);
                subsets.add(set);
            }
        }
        subsets.remove(0);
        return subsets;
    }
}
