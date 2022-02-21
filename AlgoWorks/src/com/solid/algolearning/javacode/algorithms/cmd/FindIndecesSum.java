package com.solid.algolearning.javacode.algorithms.cmd;

import java.util.Arrays;

public class FindIndecesSum {
    public static void main(String[] args) {

//        [1,5,3,1,5, 2, 2] -> 4
//
//                [1,1,2,2,3, 5, 5] -> start = 0; end. = n - 1,
//
//                result = [[0, 4], [1, 4], [2, 3]]


       int[] arr = {1,5,3,1,5, 2, 2};
       int key = 4;

        System.out.println(Arrays.deepToString(findIndicesSum(arr, key)));
    }

    static int[][] findIndicesSum(int[] arr, int key){
      Arrays.sort(arr);   //O(nlogn)  //quicksort {1,5,3,1,5, 2, 2};  -> [1,1,2,2,3,5,5] -> start = 2, end = 3, i = 1
      int n = arr.length, i = 0;
      int[][] result = new int[3][2];   // result =[[0 , 4], [1 , 4], [2 , 3], [], []...]     -> currentIndices = [2 , 3]

      int start = 0;
      int end = arr.length - 1;

        while(start != end){
            int sum = arr[start] + arr[end];
            if(sum > key){ // if the sum is greater than the key
                end--;
            }
            else if(sum <= key){
                int[] currentIndices = new int[2];
                currentIndices[0] = start;
                currentIndices[1] = end;

                result[i] = currentIndices;
                i++;
                start++;
            }
        }

        return result;
    }


}
