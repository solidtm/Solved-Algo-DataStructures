
package com.solid.algolearning.javacode.algorithms.searching;

public class BinarySearchAlgo {
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        int[] array = {6, 13, 14, 25, 33, 43, 51, 64, 72, 84, 93, 95, 96, 97, 99};
        int key = 72;
        System.out.println(binarySearch(array, key));
        System.out.println(stopWatch.elapsedTime());

    }


    /*Non recursive solution for Binary search algorithm
    Here we find index of a key in a sorted array
    Implementation of the binarySearch Algo is such that we first look for the key starting from the middle of the sorted array
    If the key is less than the middle value, then the key is at the right side of the list, else if it is greater than the mid
    value, then it is at the right hnd half of the list, else it is equal to the list and we repeat this until the value is found
    from the subsets created afterwards.
    */
    public static int binarySearch(int[] a, int key){
        int low = 0, high = a.length -1;

        while (low <= high){
            int middle = low + (high - low) / 2;        //note this very well, middle is low + (high - low) / 2
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
