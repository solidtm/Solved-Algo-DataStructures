package com.solid.algolearning.javacode.algorithms.searching;

public class findKeyBS {
    public static void main(String[] args) {
        int[] input1 = {4, 6, 10}; int key1 = 10;
        int[] input2 = {1, 2, 3, 4, 5, 6, 7}; int key2 = 5;
        int[] input3 = {10, 6, 4}; int key3 = 10;

//        int[] array = {6, 13, 14, 25, 33, 43, 51, 64, 72, 84, 93, 95, 96, 97, 99};
//        int[] arr = {51, 33, 33, 13, 12, 9, 4, 3, 1, 0};
//        int key = 33;
        System.out.println(findKey(input1, key1));
        System.out.println(findKey(input2, key2));
        System.out.println(findKey(input3, key3));
    }

    public static int findKey(int[] input, int key) {
        if (input.length == 1 && input[0] == key) {
            return 0;
        } else if (input.length < 1) {
            return -1;
        }

        // check sort order
        int start = 0;
        int end = input.length - 1;
        if (input[start] < input[end]) {
            return handleAscending(input, key);
        } else {
            return handleDescending(input, key);
        }
    }


    public static int handleAscending(int[] input, int key) {
        //it's ascending array
        int start = 0;
        int end = input.length - 1;

//      1.   {4, 6, 10}, key = 10 --> start = 0, end = 2, mid = 0 + (2-0) / 2 = 1 , input[1] < key
//      2.   therefore --> start = mid + 1 = 2, mid = 2 + {2-2}/ 2= 2, and input[2]== key <<-->> return mid

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (key > input[mid]) {
                start = mid + 1;
            } else if (key < input[mid]) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static int handleDescending(int[] input, int key) {
        int start = 0;
        int end = input.length - 1;
        //its descending array
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (key > input[mid]) {
                end = mid - 1;
            } else if (key < input[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

}
