package com.solid.algolearning.javacode.algorithms.codility;

import java.util.*;
public class FrogRiverOne {
    public static void main(String[] args) {
        System.out.println(solution(5, new int[]{1,3,1,4,2,3,5,4}));
    }

    public static int solution(int x, int[] arr) {

        Set<Integer> numSet = new HashSet<>();

        //add the values from 1 to x in the set
        for (int i = 1; i <= x; i++) {
            numSet.add(i);
        }

//        revove the values from the set
        for(int i = 0; i < arr.length; i++) {
            numSet.remove(arr[i]);

           if(numSet.isEmpty()) return i;
        }

        return -1;
    }
}
