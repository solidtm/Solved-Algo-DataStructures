package com.solid.algolearning.javacode.algorithms.sorting;

import java.util.Arrays;

public class BubbleSort {

//    Bubble sort implementation
    public static void main(String[] args) {
        int[] numbers = {34, 7, 65, 2, 8, 1, 2};

        for(int i = 0; i < numbers.length; i++){
            for (int j = i + 1; j < numbers.length; j++){
                if (numbers[i] > numbers[j]){
                    int temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(numbers));
    }
}
