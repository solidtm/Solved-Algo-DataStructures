package com.solid.algolearning.javacode.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayInterviewQuestions {
//    Question 1:
//    Create a function that reverses a string:
//    "Hi My name is Andrei"  should be:
//    "ierdnA si eman iH"

//    Question 2:
//    Given two arrays that are sorted, can you merge the two arrays together so that we have one si

    public static void main(String[] args) {
//      Question 1 tests:
        String word = "Hi, My name is ";
        int  word2 = 123;
        String word3 = "I";
        reverse(word);
//        reverse(word2);             //error
        System.out.println();
        reverse(word3);


//      Question 2 tests:
        int[] arr1 = {0, 3, 4, 31};
        int[] arr2 = {4, 6, 30};

        mergeSortedArrays(arr1, arr2);
    }

    //    Question 1 solution:
    public static void reverse(String args) {
//        First thing to do is to always check the inputs:
//        If args is empty, or args is just one letter, there is no need for any reversal simply printout the letter
//        We can also add some input validation to the string to make sure it is an instance of/typeof String class.
//        But in this case its not necessary because the input is always a String
        if (args.isEmpty() || args.length() < 2){
            System.out.println("Hmm, that's not good for reversal");
        }else {
            String[] arr = args.split("");
            for (int i = arr.length - 1; i >= 0; i--) {
                System.out.print(arr[i]);
            }
        }
    }

//    Question 2 solution:
    private static void mergeSortedArrays(int[] arr1, int[] arr2) {
//        First we check for the inputs thus:
//        Ask interviewer if the input arrays will always be sorted and if the input arrays will always be integers
//        if yes we carry on thus:
        if (arr1.length == 0 || arr2.length == 0){
            System.out.println("Invalid array values for merge");
        }else{
            System.out.println(Arrays.toString(mergeArrays(arr1, arr2)));
        }
    }

    private static int[] mergeArrays(int[] arr1, int[] arr2) {
//        create arr3 of size arr1.length + arr2.length
        int i = 0, j = 0, k = 0;
        int l1 = arr1.length, l2 = arr2.length;
        int[] arr3 = new int[l1 + l2];

//        Traverse both arrays
        while(i < l1 && j < l2){
//            Check if current element of first
//            array is smaller than current element
//            of the second array. If yes, store the first array element
//            and increment first array index. Otherwise do same with second array

            if (arr1[i] < arr2[j])
                arr3[k++] = arr1[i++];
            else
                arr3[k++] = arr2[j++];
        }

//        Store remaining elements of first array
        while(i < l1)
            arr3[k++] = arr1[i++];
//        Store remaining elements of second array
        while(j < l2)
            arr3[k++] = arr2[j++];

        return arr3;
    }
}
