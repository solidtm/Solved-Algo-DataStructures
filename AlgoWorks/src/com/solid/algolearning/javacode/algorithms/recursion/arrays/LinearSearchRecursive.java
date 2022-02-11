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

        System.out.println(linearSearchRecursiveAllIndices3(arr, 2, 0));
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


    //returning all indices list outside the function
    static ArrayList<Integer> list = new ArrayList<>();
    static void linearSearchRecursiveAllIndices(int[] arr, int target, int index){
        if(index > arr.length - 1) return;   //base case

        if(arr[index] == target) list.add(index);
        linearSearchRecursiveAllIndices(arr, target, index + 1);
    }

    //returning all indices list within the parameter of the function
    static ArrayList<Integer> linearSearchRecursiveAllIndices2(int[] arr, int target, int index, ArrayList<Integer> list){
        if(index > arr.length - 1) return list;   //base case

        if(arr[index] == target) list.add(index);

        return linearSearchRecursiveAllIndices2(arr, target, index + 1, list);
    }

    //returning all indices list within the body of the function
    static ArrayList<Integer> linearSearchRecursiveAllIndices3(int[] arr, int target, int index){
        ArrayList<Integer> list = new ArrayList<>(); //this list is created in below function calls

        if(index == arr.length) return list;   //base case

        if(arr[index] == target) list.add(index); //found target index

        ArrayList<Integer> ansFromBelowCalls =  linearSearchRecursiveAllIndices3(arr, target, index + 1); //all answer from below calls
        list.addAll(ansFromBelowCalls); //add them to the parent array list

        return list;
    }
}
