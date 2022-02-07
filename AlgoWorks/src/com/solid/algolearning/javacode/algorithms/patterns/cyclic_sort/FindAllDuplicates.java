package com.solid.algolearning.javacode.algorithms.patterns.cyclic_sort;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicates {
    public static List<Integer> findNumbers(int[] nums) {
        List<Integer> duplicateNumbers = new ArrayList<>();
        int i = 0;
        while(i < nums.length){
            if(nums[i] != i + 1){
                if(nums[i] != nums[nums[i] - 1]){   //[1, 2, 3, 3, 5, 4]  [1, 4, 3, 4, 2]
                    swap(nums, i, nums[i] - 1);
                }else i++;
            }else i++;
        }

        for(int j = 0; j < nums.length; j++){
            if(nums[j] != j + 1){
                duplicateNumbers.add(nums[j]);
            }
        }
        return duplicateNumbers;
    }

    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        List<Integer> duplicates = findNumbers(new int[]{3, 4, 4, 5, 5});
        System.out.println("Duplicates are: " + duplicates);

        duplicates = findNumbers(new int[]{5, 4, 7, 2, 3, 5, 3});
        System.out.println("Duplicates are: " + duplicates);
    }
}
