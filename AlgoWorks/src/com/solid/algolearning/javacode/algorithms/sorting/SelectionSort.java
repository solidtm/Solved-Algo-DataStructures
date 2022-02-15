package com.solid.algolearning.javacode.algorithms.sorting;

import java.util.Arrays;

public class SelectionSort {

//    Selection sort implementation
    public static void main(String[] args) {
        int[] numbers = {64, 25, 12, 22, 11};
        selectSort(numbers, numbers.length);
        selectionSortRecursive(numbers, numbers.length - 1, 0, 0);
        System.out.println(Arrays.toString(numbers));

    }

    public static void selectSort(int[] numbers, int n){
        for(int lastUnsortedIndex = n - 1; lastUnsortedIndex > 0; lastUnsortedIndex--){
           int largest = 0;
            for (int i = 1; i <= lastUnsortedIndex; i++){
                if (numbers[i] > numbers[largest]){
                    largest = i;
                }
            }

            swap(numbers, largest, lastUnsortedIndex);
        }

        printOut(numbers);
    }

    static void selectionSortRecursive(int[] arr, int start, int end, int max){
        if(start == 0) return;

        if (end < start){
            if(arr[end] > arr[max]){
                selectionSortRecursive(arr, start, end + 1, end); // change the max value index to that of end
            }else{
                selectionSortRecursive(arr, start, end + 1, max); //else, let max be as it is
            }
        }else {
            swap(arr, start - 1, max);
            selectionSortRecursive(arr, start - 1, 0, 0);
        }
    }

    public static void swap(int[] array, int i, int j){
        if (i == j){
            return;
        }

        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void printOut(int[] array){
        System.out.println(Arrays.toString(array));
    }
}
