package com.solid.algolearning.javacode.algorithms.prep_problems;

import java.util.*;
public class SlowestKey {
    public static void main(String[] args) {
//        System.out.println(slowestKey(new int[]{12,23,36,46,62}, "spuda"));
        System.out.println(slowestKey(new int[]{9,29,49,50}, "cbcd"));
    }

    public static char slowestKey(int[] releaseTimes, String keysPressed) {
        Map<Character, Integer> keyDurationMap = new HashMap<>();


        for(int i = 0, j = 0; i < releaseTimes.length; i++){
            char c = keysPressed.charAt(j);

            if(i != 0){
                keyDurationMap.putIfAbsent(c, releaseTimes[i] - releaseTimes[i - 1]);
            }else{
                keyDurationMap.putIfAbsent(c, releaseTimes[i]);
            }
            j++;
        }

        Map<Character, Integer> results = new HashMap<>();
        int highest = Integer.MIN_VALUE;
        char highestChar = '#';

        for(Character c : keyDurationMap.keySet()){
            if(keyDurationMap.get(c) > highest){
                highest = keyDurationMap.get(c);
                highestChar = c;
            }else if(keyDurationMap.get(c) == highest){
                results.putIfAbsent(highestChar, keyDurationMap.get(highestChar));
                results.putIfAbsent(c, keyDurationMap.get(c));
            }
        }

        if(results.size() != 0){
            Character[] resultSet = results.keySet().toArray(new Character[0]);
            for(int i = 0; i < resultSet.length; i++){
                if(resultSet[i] > resultSet[i + 1]) highestChar = resultSet[i];
            }
        }
        return highestChar;
    }
}
