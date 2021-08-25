package com.solid.algolearning.javacode.sorting;

import java.util.Arrays;

public class InsertionSort {
//    Insertion sort implementation
//    We don't swap elements in this implementation, we shift elements

    public static void main(String[] args) {
        int[] numbers = {20, 35, -15, 7, 55, 1, -22};

        insertSort(numbers, numbers.length);



    }

    private static void insertSort(int[] numbers, int length) {
        for (int firstUnsortedIndex = 1; firstUnsortedIndex < length; firstUnsortedIndex++){
            int newElement = numbers[firstUnsortedIndex];

            int i;
//        This is where the shifting is done
//        loop through the sorted partition with condition that we have not hit the end of the array, and that the number at i-1 is greater than the newElement
            for (i = firstUnsortedIndex; i > 0 && numbers[i - 1] > newElement; i--){
                numbers[i] = numbers[i-1];
            }
//        When we hit the end of the loop or the number is not greater than the newElement, we simply assign that index to the new value
            numbers[i] = newElement;
        }

        printOut(numbers);
    }

    public static void printOut(int[] array){
        System.out.println(Arrays.toString(array));
    }
}
