package com.solid.algolearning.javacode.algorithms.greedy;
import java.util.*;
//Problem statement#
//        Implement a function that calculates the number of thieves that can be caught.
//
//        Input#
//        The input is an array in which each element contains either a police officer (P) or a thief (T).
//
//        Each police officer can catch only one thief, and a police officer cannot catch a thief who is more than k units away from him.
//
//        Output#
//        The output is the maximum number of thieves that can be caught.
//
//        Sample input#
//        policeThiefArray[] = {'P', 'T', 'T', 'P', 'T'},
//        k = 1
//
//        Sample output#
//        2

public class CatchThieves {
    public static void main(String[] args) {
        char[] policeTheifArray = {'P', 'T', 'T', 'P', 'T'};
        char[] policeTheifArray1 = {'T', 'T', 'P', 'P', 'T', 'P'};
        int k = 2;

        System.out.println("Maximum thieves caught for {P, T, T, P, T}: " + policeThief(policeTheifArray, k));
        System.out.println("Maximum thieves caught for {T, T, P, P, T,P}: " + policeThief(policeTheifArray1, k));
    }

    public static int policeThief(char[] arr, int k) {
        int result = 0;
        ArrayList < Integer > thieves = new ArrayList<>();
        ArrayList < Integer > police = new ArrayList<>();
        int n = arr.length;
        //store indices in the respective vector
        for (int i = 0; i < n; i++) {
            if (arr[i] == 'P') {
                police.add(i);
            }
            else if (arr[i] == 'T') {
                thieves.add(i);
            }
        }
        int trackThieves = 0, trackPolice = 0;
        while (trackThieves < thieves.size() && trackPolice < police.size()) {
            //thieves can be caught
            if (Math.abs(thieves.get(trackThieves) - police.get(trackPolice)) <= k) {
                result++;
                trackThieves++;
                trackPolice++;
            }
            //increment the minimum index
            else if (thieves.get(trackThieves) < police.get(trackPolice)) {
                trackThieves++;
            }
            else {
                trackPolice++;
            }
        }
        return result;
    }

}
