package com.solid.algolearning.javacode.algorithms.patterns.two_pointer;

//same as triple sum equal to zero, difference is that y + z = -x here,
// so we are looking for y and z that will give -x
import java.util.*;
public class TripleSumEqualToTarget {
    public static int searchTriplet(int[] arr, int targetSum) {
        if(arr == null || arr.length < 3){
            throw new IllegalArgumentException();
        }
        //we first sort the array
        Arrays.sort(arr);
        int smallestDiff = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length - 2; i++){
            int left = i + 1, right = arr.length - 1;

            while(left < right){
                int targetDiff = targetSum - (arr[i] + arr[left] + arr[right]);

                if(targetDiff == 0){// if the difference is 0, we have found an exact sum
                    return targetSum;  //return the sum of all numbers
                }
                //if not, then we need to do some work.
                //we handle the smallest sum when we have more than one solution
                if(Math.abs(targetDiff) < Math.abs(smallestDiff) || Math.abs(targetDiff) == Math.abs(smallestDiff)
                        && targetDiff > smallestDiff){
                    smallestDiff = targetDiff;
                }

                if(targetDiff > 0){
                    left++; //we need triplet with bigger sum
                }  else right--;  //we need triplet with smaller sum;

            }
        }
        return targetSum - smallestDiff;
    }


    public static void main(String[] args) {
        System.out.println(searchTriplet(new int[] { -2, 0, 1, 2 }, 2));
        System.out.println(searchTriplet(new int[] { -3, -1, 1, 2 }, 1));
        System.out.println(searchTriplet(new int[] { 1, 0, 1, 1 }, 100));
    }
}
