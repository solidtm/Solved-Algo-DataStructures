package com.solid.algolearning.javacode.algorithms.sorting;

import java.util.Arrays;

public class InsertionSort {
//    Insertion sort implementation
//    We don't swap elements in this implementation, we shift elements

    public static void main(String[] args) {
        int[] numbers = {20, 35, -15, 7, 55, 1, -22};

        insertionSort(numbers, numbers.length);

       printOut(numbers);
    }

//    Insertion sort assumes that the first element in the list is in its correct sorted position and starts from the second to sort,
//    Comparing from then on and inserting in the appropriate position/index

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


//    Insertion sort with recursion
    public static void insertionSort(int[] input, int numItems){
        if(numItems < 2){
            return;
        }

        insertSort(input, numItems - 1);

        int newElement = input[numItems - 1];
        int i;

        for(i = numItems - 1; i > 0 && input[i - 1] > newElement; i--){
            input[i] = input[i - 1];
        }

        input[i] = newElement;

    }
}
