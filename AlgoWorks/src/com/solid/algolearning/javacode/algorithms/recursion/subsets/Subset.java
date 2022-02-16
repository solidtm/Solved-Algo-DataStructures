package com.solid.algolearning.javacode.algorithms.recursion.subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Subset {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        List<List<Integer>> answer = subsetIterative(arr);

        System.out.println(answer);

        int[] arr2 = {1,2,2};
        List<List<Integer>> answer2 = subsetIterativeDuplicate(arr2);

        System.out.println(answer2);
    }

    static List<List<Integer>> subsetIterative(int[] arr){
        List<List<Integer>> outer = new ArrayList<>();

        outer.add(new ArrayList<>());  //initially the list has an empty list
        for(int num : arr){//for every number in arr,
            int n = outer.size();  //size of outer list
            for (int i = 0; i < n; i++) { //a new arraylist will be created
                List<Integer> internal = new ArrayList<>(outer.get(i));
                internal.add(num);
                outer.add(internal); ///add individual lists to the main list
            }
        }

        return outer;
    }

    static List<List<Integer>> subsetIterativeDuplicate(int[] arr){
        Arrays.sort(arr);

        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>()); //initially contains empty array.
        int start = 0, end = 0;

        for (int i = 0; i < arr.length; i++) {
//         if current and previous elements are the same, s = e + 1;
           if(i > 0 && arr[i] == arr[i-1]){  //when we hit a duplicate
                start = end + 1;   //do not add that duplicate, shift start
           }
           end = outer.size() - 1;
           int n = outer.size();

            for (int j = start; j < n; j++) { //a new arraylist will be created
                List<Integer> internal = new ArrayList<>(outer.get(j));  //get previous element added
                internal.add(arr[i]);  //and add to it
                outer.add(internal); ///add individual lists to the main list
            }
        }
        return outer;
    }
}
