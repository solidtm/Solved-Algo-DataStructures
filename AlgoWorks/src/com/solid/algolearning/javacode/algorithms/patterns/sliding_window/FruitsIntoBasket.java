package com.solid.algolearning.javacode.algorithms.patterns.sliding_window;

import java.util.*;
public class FruitsIntoBasket {

//Problem Statement#
//Given an array of characters where each character represents a fruit tree, you are given two baskets,
//and your goal is to put maximum number of fruits in each basket.
//The only restriction is that each basket can have only one type of fruit.

//You can start with any tree, but you can’t skip a tree once you have started. You will pick one fruit from each tree until you cannot, i.e.,
//you will stop when you have to pick from a third fruit type.

//Write a function to return the maximum number of fruits in both baskets.

// Example 1:
// Input: Fruit=['A', 'B', 'C', 'A', 'C']
// Output: 3
// Explanation: We can put 2 'C' in one basket and one 'A' in the other from the subarray ['C', 'A', 'C']

// Example 2:
// Input: Fruit=['A', 'B', 'C', 'B', 'B', 'C']
// Output: 5
// Explanation: We can put 3 'B' in one basket and two 'C' in the other basket.
// This can be done if we start with the second letter: ['B', 'C', 'B', 'B', 'C']


        public static int findLength(char[] arr) {
            if(arr.length == 0 || arr.length == 1){return 0;}

            int windowStart = 0, maxLength = 0;
            int windowEnd;
            Map<Character, Integer> frequencyMap = new HashMap<>();

            for(windowEnd = 0; windowEnd < arr.length; windowEnd++){
                char rightChar = arr[windowEnd];
                frequencyMap.put(rightChar, frequencyMap.getOrDefault(rightChar, 0) + 1);

                while(frequencyMap.size() > 2){
                    char leftChar = arr[windowStart];
                    frequencyMap.put(leftChar, frequencyMap.get(leftChar) - 1);

                    if(frequencyMap.get(leftChar) == 0){
                        frequencyMap.remove(leftChar);
                    }

                    windowStart++;
                }

                maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
            }
            return maxLength;
        }

        public static void main(String[] args) {
            System.out.println("Hello world!");
        }
}
