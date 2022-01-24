package com.solid.algolearning.javacode.algorithms.codility;

import java.util.Arrays;

//An array A consisting of N integers is given. Rotation of the array means that each element is shifted right by one index, and the last element of the array is moved to the first place. For example, the rotation of array A = [3, 8, 9, 7, 6] is [6, 3, 8, 9, 7] (elements are shifted right by one index and 6 is moved to the first place).
//
//        The goal is to rotate array A K times; that is, each element of A will be shifted to the right K times.
//
//        Write a function:
//
//        public int[] solution(int[] A, int K){}
//
//        that, given an array A consisting of N integers and an integer K, returns the array A rotated K times.
//
//        For example, given
//
//        A = [3, 8, 9, 7, 6]
//        K = 3
//        the function should return [9, 7, 6, 3, 8]. Three rotations were made:
//
//        [3, 8, 9, 7, 6] -> [6, 3, 8, 9, 7]
//        [6, 3, 8, 9, 7] -> [7, 6, 3, 8, 9]
//        [7, 6, 3, 8, 9] -> [9, 7, 6, 3, 8]
//        For another example, given
//
//        A = [0, 0, 0]
//        K = 1
//        the function should return [0, 0, 0]
//
//        Given
//
//        A = [1, 2, 3, 4]
//        K = 4
//        the function should return [1, 2, 3, 4]

public class RotateArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{3, 8, 9, 7, 6}, 3)));
    }

    public static int[] solution(int[] arr, int k) {
        if(arr.length == k){  //if we are making full rotations
            return arr;
        }

        if(k == 0){ //if there is no rotations to make
            return arr;
        }

        int[] holderArr = new int[k];
        int start = 0;
        int shiftElement = k - 1;
        int end = arr.length - 1;
        int mid = arr[start + (end + start) / 2];

        while(start < k){    //{3, 8, 9, 7, 6} --> {3, 8, 6, 7, 6} --> {3, 7, 6, 7, 6}

            holderArr[start] = arr[start];
            arr[shiftElement] = arr[end];
            start++;
            end--;
            shiftElement--;
        }

        start = k;
        for (int j : holderArr) {
            arr[start] = j;
            start++;
            if (start == arr.length){
                break;
            }
        }
        arr[0] = mid;
        return arr;
    }
}
