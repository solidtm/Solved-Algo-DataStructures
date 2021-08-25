package com.solid.algolearning.javacode.sorting;

import java.util.Arrays;

public class SelectionSort {

//    Selection sort implementation
    public static void main(String[] args) {
        int[] numbers = {64, 25, 12, 22, 11};

        selectSort(numbers, numbers.length);

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
