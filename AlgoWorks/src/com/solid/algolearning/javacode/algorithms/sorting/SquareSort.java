package com.solid.algolearning.javacode.algorithms.sorting;

import java.util.Arrays;

public class SquareSort {

    public static void main(String[] args) {
        int[] input = {-5, -3, 0, 2, 4, 6};// Expected output --> [0, 4, 9, 16, 25, 36]
        int[] input2 = {-2, -1, 0, 2, 3}; // Expected output --> [0, 1, 4, 4, 9]
        System.out.println(Arrays.toString(squareSort(input)));
    }

//    This approach is in place and uses 2 pointer approach to still meet the target output

    public static int[] squareSort(int[] input){
        int start = 0;
        int end = input.length - 1;
        while(start <= end){
            int leftElement = (int) Math.pow(input[start], 2);
            int rightElement = (int) Math.pow(input[end], 2);

            if(leftElement > rightElement){
                int temp = input[end];
                input[end] = leftElement;
                input[start] = temp;

                int leftCheckValue = (int) Math.pow(input[end - 1], 2);
                if(leftCheckValue > input[end]){
                    temp = input[end];
                    input[end] = leftCheckValue;
                    input[end - 1]= temp;
                    end -= 2;
                }
            }else{
                input[end] = rightElement;
            }
            end--;
        }
        return input;
    }
}
