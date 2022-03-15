package com.solid.algolearning.javacode.algorithms.sorting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] numbers = {34, 7, 65, 2, 8, 1, 2};
        quickSort(numbers, 0, numbers.length-1);
        System.out.println(Arrays.toString(numbers));
    }

    static void quickSort(int[] arr, int low, int high){
        if(low >= high) return;

        int start = low;
        int end = high;

        int mid = start + (end - start) / 2;

        int pivot = arr[mid];

        while(start <= end){
            while (arr[start] < pivot){//no violation
                start++;
            }

            while (arr[end] > pivot){ //no violation
                end--;
            }

            if(start <= end){ //met a violation, we check if the pointers have crossed each other yet
                swap(arr, start, end);
                start++;
                end--;
            }
        }

        //now my pivot is at correct position, please sort the two halves
        quickSort(arr, low, end);
        quickSort(arr, start, high);
    }

    static void swap(int[] arr, int start, int end){
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
}
