package com.solid.algolearning.javacode.algorithms.codility;

//https://app.codility.com/programmers/lessons/3-time_complexity/tape_equilibrium/

public class TimeComp {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 1, 2, 4, 3}));
    }

    public static int solution(int[] arr) {
        int sum = 0, maxDiff = Integer.MAX_VALUE;

        for(int num : arr){
            sum += num;
        }

        int num = 0;
        for(int start = 0; start < arr.length - 1; start++){
            num += arr[start];
            sum -= arr[start];
            maxDiff = Math.min(maxDiff, Math.abs(sum - num));
        }

        return maxDiff;
    }

//    public int solution(int x, int[] arr) {
//        int index = -1;
//        for(int i = 0; i < arr.length; i++){
//            if(arr[i] == x){
//                index = i;
//            }
//        }
//
//        return index;
//    }
}
