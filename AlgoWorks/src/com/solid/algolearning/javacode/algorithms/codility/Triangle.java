package com.solid.algolearning.javacode.algorithms.codility;

import java.util.*;
public class Triangle {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{10, 2, 5, 1, 8, 20}));
    }

    public static int solution(int[] arr) {
        if (arr.length < 3){
            return 0;
        }
        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 2; i++) {
            if((long) arr[i] + arr[i + 1] > arr[i + 2]){
                return 1;
            }
        }

        return 0;
    }
}
