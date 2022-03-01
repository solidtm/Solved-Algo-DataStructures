package com.solid.algolearning.javacode.algorithms.blind_75;

//leetcode problem 217
import java.util.*;
public class _3_ContainsDuplicate {

    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{1,2,3,1}));
    }


    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < nums.length; i++){
            if(set.contains(nums[i])) return true;

            set.add(nums[i]);
        }

        return false;
    }
}
