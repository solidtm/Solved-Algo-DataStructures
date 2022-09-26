package com.solid.algolearning.javacode.algorithms.greedy;

//Problem statement#
//        Implement a function that returns the minimum number of platforms that are required for the trains so that none of them wait.
//
//        Input#
//        The input is two arrays that represent the arrival and departure times of trains that stop.
//
//        Output#
//        The output is the minimum number of platforms required.
//
//        Sample input#
//        arrival[] = {900, 940, 950, 1100, 1500, 1800};
//        departure[] = {910, 1200, 1120, 1130, 1900, 2000};
//
//        Sample output#
//        Minimum platforms needed = 3

public class NumberOfPlatforms {
    public static void main(String[] args) {
        System.out.println(findPlatform(new int[]{900, 940, 950, 1100, 1500, 1800},
                                        new int[]{910, 1200, 1120, 1130, 1900, 2000}));
        System.out.println(findPlatform(new int[]{200, 210, 300, 320, 350, 500},
                                        new int[]{230, 240, 320, 430, 400, 520}));
    }

    public static int findPlatform(int[] arrival, int[] departure) {
        if(arrival.length == 0 || departure.length == 0) return 0;

        int i, result = 0;

        for(i = 1; i < arrival.length; i++){
            if(arrival[i] < departure[i - 1]){
                result++;
            }
        }

        return result;
    }
}
