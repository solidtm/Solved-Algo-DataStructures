package com.solid.algolearning.javacode.algorithms.blind_75;

//Leetcode 15

import java.util.*;
public class _9_3Sum {
    public static void main(String[] args) {

    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);  //sort the array

        for (int i = 0; i < nums.length; i++) {
            int left = i + 1, right = nums.length - 1;

            if(i > 0 && nums[i] == nums[i - 1]){ //we do not want to repeat the same number in the result
                continue;  //so we move on
            }

            while(left < right){
                int tripleSum = nums[i] + nums[left] + nums[right];

                if(tripleSum > 0){
                    right--;
                }else if(tripleSum < 0){
                    left++;
                }else{
                    ArrayList<Integer> values = new ArrayList<>();
                    values.add(nums[i]);
                    values.add(nums[left]);
                    values.add(nums[right]);
                    result.add(values);

                //we don't want to repeat the same number for left or right too
                    //but our condition above handles for right, so we work for left
                    left++;
                    while(nums[left] == nums[left - 1] && left < right){
                        left += 1;
                    }
                }
            }
        }
        return result;
    }
}
