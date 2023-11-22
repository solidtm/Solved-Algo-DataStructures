package com.solid.algolearning.javacode.algorithms.codility;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermMissingElement {

//    public static int solution(int[] A) {
//
//        for(int i = 0; i < A.length;){
//            int currVal = A[i];
//
//            if(currVal > A.length) i++;
//            else{
//                if((i + 1) == currVal) i++;
//
//                if(currVal != A[currVal - 1]){
//                    swap(A, i, currVal - 1);
//                }
//            }
//        }
//
//        for(int i = 0; i < A.length; i++){
//            if(i + 1 != A[i]) return i+1;
//        }
//
//        return 0;
//    }

    public static int solution(int[] A) {
        Set<Integer> set = new HashSet<>();
        for(int i = 1; i <= A.length + 1; i++){
            set.add(i);
        }

        for (int j : A) {
            set.remove(j);
        }

        return set.iterator().next();
    }


    public static void main(String[] args) {
        System.out.println(solution(new int[]{2,3,1,4,6}));
        System.out.println(solution(new int[]{3,1,4,5}));
    }
}
