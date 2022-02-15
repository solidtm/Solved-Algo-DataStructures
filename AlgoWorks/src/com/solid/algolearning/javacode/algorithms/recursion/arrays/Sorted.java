package com.solid.algolearning.javacode.algorithms.recursion.arrays;

//Given an array, check whether the array is sorted or not using recursion
//the elements can be repeated.

public class Sorted {

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 3, 5};
        System.out.println(sorted(arr, 0));
    }


    static boolean sorted(int[] arr, int index){
        if(index == arr.length - 1) return true; //because it was able to rech the end, which means its sorted.

        return (arr[index] <= arr[index + 1]) && sorted(arr, index + 1);
    }
}
