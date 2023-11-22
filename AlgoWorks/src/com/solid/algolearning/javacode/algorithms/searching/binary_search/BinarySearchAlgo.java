
package com.solid.algolearning.javacode.algorithms.searching.binary_search;

import com.solid.algolearning.javacode.algorithms.searching.StopWatch;

public class BinarySearchAlgo {
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        int[] array = {6, 13, 14, 25, 33, 43, 51, 64, 72, 84, 93, 95, 96, 97, 99};
        int[] arra = {1,5,6,9,11,13,18,20};
        int[] arr = {51, 33, 33, 13, 12, 9, 4, 3, 1, 0};
        int key = 33;
        System.out.println(binarySearch(arra, key));
//        System.out.println(stopWatch.elapsedTime());

    }


    /*Non-recursive solution for Binary search algorithm
    Here we find index of a key in a sorted array
    Implementation of the binarySearch Algo is such that we first look for the key starting from the middle of the sorted array
    If the key is less than the middle value, then the key is at the right-side of the list, else if it is greater than the mid
    value, then it is at the right hnd half of the list, else it is equal to the list and we repeat this until the value is found
    from the subsets created afterwards.
    */
    public static int binarySearch(int[] a, int key){
        int low = 0, high = a.length -1;

        while (low <= high){
            int middle = low + (high - low) / 2;
            System.out.println(low + "+" + "(" + high + "-" + low + ")" + "/" + "2" );
            System.out.println(middle);    //note this very well, middle is low + (high - low) / 2     (4, 6, 10), key = 10 --> 0 + (2 - 0) / 2 = 1
            if (key  < a[middle]){
                high = middle - 1;
            }else if (key > a[middle]){
                low = middle + 1;
            }else
                return middle;
        }
        return -1;
    }
}
