package com.solid.algolearning.javacode.algorithms.codility;

import java.util.*;

public class Leader {
    public static void main(String[] args) {

    }

    public static int findLeader(int[] nums){
        Map<Integer, Integer> freqMap = new HashMap<>();

        for(int num : nums){
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);

            if(freqMap.get(num) > nums.length / 2){
                return 1;
            }
        }

        return 0;
    }
}
