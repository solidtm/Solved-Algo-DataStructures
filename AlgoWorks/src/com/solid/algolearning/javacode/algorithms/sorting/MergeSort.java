package com.solid.algolearning.javacode.algorithms.sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] array = new int[]{5, 4, 3, 2, 1};
        int[] arr = {20, 7, 0, 35, -15, 7, 55, 1, -22, 7};
        System.out.println(Arrays.toString(mergeSort(array)));

        mergeSortInPlace(arr, 0, arr.length );
        System.out.println(Arrays.toString(arr));
    }

    public static int[] mergeSort(int[] input){
        if(input.length < 2){
            return input;
        }

        int mid = input.length / 2;

       int[] left = Arrays.copyOfRange(input, 0, mid);
       int[] right = Arrays.copyOfRange(input, mid, input.length);

        return merge(mergeSort(left), mergeSort(right));
    }

    public static int[] merge(int[] left, int[] right){
        int leftIndex = 0;
        int rightIndex = 0;
        int k = 0;
       int[] tempList = new int[left.length + right.length];

        while(leftIndex < left.length && rightIndex < right.length){
            if(left[leftIndex] <= right[rightIndex]){
                tempList[k] = left[leftIndex];
                leftIndex++;
                k++;
            }else if(left[leftIndex] >= right[rightIndex]){
                tempList[k] = right[rightIndex];
                rightIndex++;
                k++;
            }
        }

        while(leftIndex < left.length){
            tempList[k] = left[leftIndex];
            leftIndex++;
            k++;
        }

        while(rightIndex < right.length){
            tempList[k] = right[rightIndex];
            rightIndex++;
            k++;
        }

        return tempList;
    }



    public static void mergeSortInPlace(int[] input, int start, int end){
        if(end - start == 1){
            return;
        }

        int mid = start + (end - start) / 2;

        mergeSortInPlace(input, start, mid);
        mergeSortInPlace(input, mid, end);

        mergeInPlace(input, start, mid, end);
    }

//    In-place implementation of mergeSort:
//    1. pass in both the arr and start and end for the array partition
public static void mergeInPlace(int[] arr, int start, int mid, int end){
    int leftIndex = start;
    int rightIndex = mid;
    int k = 0;

    int[] tempList = new int[end - start];

    while(leftIndex < mid && rightIndex < end){
        if(arr[leftIndex] <= arr[rightIndex]){
            tempList[k++] = arr[leftIndex];
            leftIndex++;
        }else{
            tempList[k++] = arr[rightIndex];
            rightIndex++;
        }
    }

    while(leftIndex < mid){
        tempList[k++] = arr[leftIndex];
        leftIndex++;
    }

    while(rightIndex < end){
        tempList[k++] = arr[rightIndex];
        rightIndex++;
    }

    System.arraycopy(tempList, 0, arr, start, tempList.length);
  }
}
