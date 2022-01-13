package com.solid.algolearning.javacode.sorting;

import java.util.Arrays;

public class SquareSort {
    public static void main(String[] args) {
        int[] input = new int[]{-2, -1, 0, 2, 3}; // {4, 1, 0, 4, 9} --> {0, 1, 4, 4, 9}
        System.out.println(Arrays.toString(squareSort(input)));
    }


    public static int[] squareSort(int[] input){
        if(input.length < 1){
            return new int[]{};
        }

        int a = 0;
        int b = input.length - 1;
        int[] result = new int[input.length];

        for(int i = 0; i < input.length; i++){
            input[i] *= input[i];
        }// here we have all elements squared


        for (int i = 0; i < input.length; i++){
            if (a < b){
                if(input[a] >= input[b]){
                    input[a] = input[a++];
                }else{
                    input[b] = input[b--];
                }
            }
        } // here we have all  elements sorted but in the reversed order


//        int start = 0;      //[9, 4, 4, 1, 0]   start = 0, end = 4
//        int end = result.length - 1;
//            while(start < end){  // 0 < 4 = true
//                int temp = result[start];  //temp = 9
//                result[start] = result[end]; //input[0] = 0
//                result[end] = temp;  //input[4] = 9
//                start++; //start = 1
//                end--;  //end = 3
//            }
//         // at this point we should have the array in correct sort order

        return result;
    }
}
