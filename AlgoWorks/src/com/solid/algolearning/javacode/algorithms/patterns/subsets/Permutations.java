package com.solid.algolearning.javacode.algorithms.patterns.subsets;
import java.util.*;

public class Permutations {
    public static void main(String[] args) {
        System.out.println(findPermutations(new int[]{1, 3, 5}));
    }

    public static List<List<Integer>> findPermutations(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<List<Integer>> permutations = new LinkedList<>();
        permutations.add(new ArrayList<>());

        for(int currNum : nums){
            int n = permutations.size();

            for(int i = 0; i < n; i++){
                List<Integer> oldPermutations = permutations.poll();
                int size = oldPermutations.size();

                for(int j = 0; j <= size; j++){
                    List<Integer> newPermutation = new ArrayList<>(oldPermutations);
                    newPermutation.add(j, currNum);

                    if (newPermutation.size() == nums.length) result.add(newPermutation);
                    else permutations.add(newPermutation);
                }
            }
        }

        return result;
    }
}
