package com.solid.algolearning.javacode.algorithms.patterns.subsets;

import java.util.*;

public class SubsetWithDuplicates {
    public static void main(String[] args) {
        System.out.println(getDupSubset(new int[]{1, 3, 3}));
    }

    public static List<List<Integer>> getDupSubset(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> subsets = new ArrayList<>();

        subsets.add(new ArrayList<>());
        int startIndex, endIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            startIndex = 0;
            // if current and the previous elements are same, create new subsets only from the subsets
            // added in the previous step
            if (i > 0 && nums[i] == nums[i - 1]) startIndex = endIndex + 1;

            endIndex = subsets.size() - 1;

            for (int j = startIndex; j <= endIndex; j++) {
                // create a new subset from the existing subset and add the current element to it
                List<Integer> set = new ArrayList<>(subsets.get(j));
                set.add(nums[i]);
                subsets.add(set);
            }
        }

        subsets.remove(0);
        return subsets;
    }
}
