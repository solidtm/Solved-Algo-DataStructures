package com.solid.algolearning.javacode.algorithms.recursion.arrays;

import java.util.*;

public class PermutationsII {
    static Set<List<Integer>> resultSet = new HashSet<>();
    public static List<List<Integer>> permuteUnique(int[] nums) {

        backtrack(nums, new LinkedHashMap<>());

        return new ArrayList<>(resultSet);
    }

    private static void backtrack(int[] nums, LinkedHashMap<Integer, Integer> currentMap) {

        if(nums.length == currentMap.size()) {
            //Set to avoid duplicate lists
            resultSet.add(new ArrayList<>(currentMap.values()));
            return;
        }

        for(int i = 0; i< nums.length; i++) {

            if(!currentMap.containsKey(i)) {
                currentMap.put(i, nums[i]);
                backtrack(nums, currentMap);
                currentMap.remove(i);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(permuteUnique(new int[]{1,1,2}));
    }
}
