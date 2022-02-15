package com.solid.algolearning.javacode.algorithms.recursion.arrays;

public class RotatedBinarySearch {
    public static void main(String[] args) {
      int[] arr = {5,6,7,8,9,1,2,3,4};
        System.out.println(search(arr, 9, 0, arr.length - 1));
    }

    static int search(int[] arr, int target, int start, int end){
        if(start > end) return - 1; //we cannot find it

        int mid = start + (end - start) / 2;

        if (arr[mid] == target){  //found answer
            return mid;
        }

        //case 1
        if(arr[start] < arr[mid]){ //meand that perof the array is sorted
            if(target >= arr[start] && target <= arr[mid]){  // if target is in left space, we can reduce the search space here to search
                return search(arr, target, start, mid - 1);
            }else{ // selse search in the right space it cannot be in the one above
                return search(arr, target, mid + 1, end);
            }
        }

        //case 2
        if(target >= arr[mid] && target >=arr[end]){ //if the value is in right space, we reduce and search
            return search(arr, target, mid + 1, end);
        }

        //final case
        return search(arr, target, start, mid - 1); // else search in the left space, it cannot be in the right.
    }
}
