package com.solid.algolearning.javacode.algorithms.patterns.two_heaps;

import java.util.*;
public class KClosestElementsToX {
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        int xIndex = findElement(arr, x);

        int lowerBound = Math.max(xIndex - k, 0);
        int upperBound = Math.min(xIndex + k, arr.length - 1);

        while(lowerBound + k <= upperBound) {
            if(Math.abs(arr[lowerBound] - x) <= Math.abs(arr[upperBound] - x)) {
                upperBound--;
            } else {
                lowerBound++;
            }
        }

        List<Integer> result = new LinkedList<>();
        for (int i = lowerBound; i <= upperBound; i++) {
            result.add(arr[i]);
        }

        return result;
    }

    public static int findElement(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while(left + 1 < right) {
            int mid = left + (right - left) /2;

            if(arr[mid] == target) {
                return mid;
            } else if(arr[mid] > target) {
                right = mid;
            } else {
                left = mid;
            }
        }

        if (Math.abs(arr[left] - target) > Math.abs(arr[right] - target)){
            return right;
        } else {
            return left;
        }
    }

    public static void main(String[] args) {

    }
}
