package com.solid.algolearning.javacode.algorithms.hackerRankChallenges;

import java.util.Arrays;
import java.util.HashMap;

public class SparseArray {
    public static void main(String[] args) {
        String[] strings = {"abc", "abc", "abba", "abc", "dee", "abb", "dee", "abba"};
        String [] query = {"abc", "abba", "dee", "abb"};

//        [3, 2, 2, 1]
        System.out.println(Arrays.toString(computeNumOccur(strings, query)));
    }

    private static int[] computeNumOccur(String[] strings, String[] query) {
//        Check for an empty array
        if (strings.length == 0 || query.length == 0){
            return new int[0];
        }

//        Precompute the actual array before query
        HashMap<String, Integer> stringMap = new HashMap();
        int[] returnArray = new int[query.length];
        for (String inputString : strings) {
            if (stringMap.containsKey(inputString)) {
                stringMap.put(inputString, stringMap.get((inputString) + 1));
            } else {
                stringMap.put(inputString, 1);
            }
        }

        for (int i = 0; i < query.length; i++){
            String value = query[i];
            if (stringMap.containsKey(value)){
                returnArray[i] = stringMap.get(value);
            }
        }

        return returnArray;
    }
}
