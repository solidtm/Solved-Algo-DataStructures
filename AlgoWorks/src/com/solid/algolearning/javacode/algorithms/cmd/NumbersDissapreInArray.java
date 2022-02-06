package com.solid.algolearning.javacode.algorithms.cmd;

import java.util.ArrayList;
import java.util.List;

public class NumbersDissapreInArray {

    public static List<Integer> findDisappearedNumbers(int[] arr) {
        if(arr.length == 0 || arr.length == 1) return new ArrayList<>();

        List<Integer> result = new ArrayList<>();

        for(int x : arr){    //set corresponding index of the number to
            int i = Math.abs(x) - 1;   //[-1,3,-2,-3,-4,2,3,1]
            arr[i] = -1 * (Math.abs(i));
        }


        for(int i = 0; i < arr.length; i++){
           if(arr[i] > 0) {
               if (arr[i + 1] < 0) {
                   i += 1;
               }else result.add(i + 1);
           }
        }

        return result;

    }

    public static void main(String[] args) {
        System.out.println(findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1}));
    }
}
