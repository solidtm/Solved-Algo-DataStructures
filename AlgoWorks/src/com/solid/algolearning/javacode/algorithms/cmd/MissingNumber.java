package com.solid.algolearning.javacode.algorithms.cmd;

import java.util.HashSet;
import java.util.Set;

public class MissingNumber {

    static int missingNumber(int[] arr){
        if(arr.length < 1){
            return -1;
        }

        int l = arr.length;
        int result = 0;

        Set<Integer> set = new HashSet<>(l + 1);

        for(int i : arr){
            set.add(i);
        }

        for(int i = 0; i <= l; i++){
            if(!set.contains(i)) result = i;
        }

        return result;
    }
    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{0, 1}));
    }
}
