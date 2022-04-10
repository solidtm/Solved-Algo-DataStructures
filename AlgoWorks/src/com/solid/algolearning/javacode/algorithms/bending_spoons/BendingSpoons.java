package com.solid.algolearning.javacode.algorithms.bending_spoons;

import java.util.*;
public class BendingSpoons {
    public static void main(String[] args) {
        System.out.println(taskOfPairing(new ArrayList<>(Arrays.asList(3L, 5L, 4L, 3L))));
    }


    public static long taskOfPairing(List<Long> freq) {

        int n = freq.size();
        long rem = 0;
        long ans = 0L;
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 1; i <= n; i++){
            map.put(i, Math.toIntExact(freq.get(i - 1)));
        }

        for(int key : map.keySet()){
            ans += map.get(key) / 2;
            rem += map.get(key) % 2;
        }

        while(rem != 0){
            ans += rem / 2;
            rem %= 2;
        }

        return ans;
    }

}
