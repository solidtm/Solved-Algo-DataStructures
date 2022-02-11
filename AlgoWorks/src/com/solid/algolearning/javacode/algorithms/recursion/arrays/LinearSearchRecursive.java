package com.solid.algolearning.javacode.algorithms.recursion.arrays;

//Given an array, find if a target number is in the array and return the index of the number or true, if it is in the array
//else return false
//Follow-up: If the array has repeated values, return all the indices of the value of the target in the array.
//Solve this recursively.

import java.util.ArrayList;

public class LinearSearchRecursive {

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 3, 5};
        int[] arr2 = {1, 2, 2, 2, 4, 3, 2, 2, 5};
        System.out.println(linearSearchRecursive(arr, 5, 0));
        System.out.println(linearSearchRecursed(arr, 22, 0));
        linearSearchRecursiveAllIndices(arr2, 2, 0);
        System.out.println(list);
        linearSearchRecursiveAllIndices2(arr2, 2, 0, new ArrayList<>());
        System.out.println(list);
    }

    static int linearSearchRecursive(int[] arr, int target, int index){
        if(index > arr.length - 1) return -1;   //base case

        if(arr[index] == target) return index;
        else return linearSearchRecursive(arr, target, index + 1);
    }


    static boolean linearSearchRecursed(int[] arr, int target, int index){
        if(index > arr.length - 1) return false;   //base case


      return (arr[index] == target) && linearSearchRecursed(arr, target, index + 1);
    }


    static ArrayList<Integer> list = new ArrayList<>();
    static void linearSearchRecursiveAllIndices(int[] arr, int target, int index){
        if(index > arr.length - 1) return;   //base case

        if(arr[index] == target) list.add(index);
        linearSearchRecursiveAllIndices(arr, target, index + 1);
    }

    static ArrayList<Integer> linearSearchRecursiveAllIndices2(int[] arr, int target, int index, ArrayList<Integer> list){
        if(index > arr.length - 1) return list;   //base case

        if(arr[index] == target) list.add(index);

        return linearSearchRecursiveAllIndices2(arr, target, index + 1, list);
    }
}
