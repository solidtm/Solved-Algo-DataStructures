package com.solid.algolearning.javacode.algorithms.sorting;

import com.sun.org.apache.xpath.internal.objects.XNumber;

import java.util.Arrays;

public class BubbleSort {

//    Bubble sort implementation
    public static void main(String[] args) {
        int[] numbers = {34, 7, 65, 2, 8, 1, 2};

        System.out.println(Arrays.toString(bubbleSortIterative(numbers)));

        bubbleSortRecursive(numbers, 0, 0);
        System.out.println(Arrays.toString(numbers));
    }


    static int[] bubbleSortIterative(int[] numbers){
        for(int i = 0; i < numbers.length; i++){
            for (int j = i + 1; j < numbers.length; j++){
                if (numbers[i] > numbers[j]){
                    swap(numbers, i, j);
                }
            }
        }

        return numbers;
    }



    static void bubbleSortRecursive(int[] arr, int start, int end){
        if(start == 0) return;

        if (end < start){
            if(arr[start] > arr[end]){
                swap(arr, start, end);
            }
            bubbleSortRecursive(arr, start, end + 1);
        }else {
           bubbleSortRecursive(arr, start - 1, end);
        }
    }

    static void swap(int[] arr, int start, int end){
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
}
