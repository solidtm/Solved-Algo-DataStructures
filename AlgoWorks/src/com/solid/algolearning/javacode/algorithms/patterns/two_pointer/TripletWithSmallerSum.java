package com.solid.algolearning.javacode.algorithms.patterns.two_pointer;

import java.util.*;
public class TripletWithSmallerSum {
    public static int searchTriplets(int[] arr, int target) {
        int count = 0;

        Arrays.sort(arr);
        for(int i = 0; i < arr.length - 2; i++){
            count += searchPairs(arr, target - arr[i], i);
        }
        return count;
    }

    //[-1, 4, 2, 1, 3] , 3 -> [-1,1,2,3,4] ->
    public static int searchPairs(int[] arr, int targetSum, int first){
        int count = 0;
        int left = first + 1, right = arr.length - 1;

        while(left < right){
            int sum = arr[right] + arr[left];

            if(sum < targetSum){ //we have found the sum.
                count += right - left;
                left++;
            }else right--; //we need sum less than target
        }
        return count;
    }


    public static void main(String[] args) {
        System.out.println(searchTriplets(new int[] { -1, 0, 2, 3 }, 3));
        System.out.println(searchTriplets(new int[] { -1, 4, 2, 1, 3 }, 5));
    }
}
