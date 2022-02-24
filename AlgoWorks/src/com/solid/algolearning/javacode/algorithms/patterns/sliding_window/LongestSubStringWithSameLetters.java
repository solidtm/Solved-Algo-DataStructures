package com.solid.algolearning.javacode.algorithms.patterns.sliding_window;
// Given a string with lowercase letters only, if you are allowed to replace no more than k letters with any letter, find the length of the longest substring having the same letters after replacement.

// Example 1:
// Input: String="aabccbb", k=2
// Output: 5
// Explanation: Replace the two 'c' with 'b' to have the longest repeating substring "bbbbb".

// Example 2:
// Input: String="abbcb", k=1
// Output: 4
// Explanation: Replace the 'c' with 'b' to have the longest repeating substring "bbbb".

// Example 3:
// Input: String="abccde", k=1
// Output: 3
// Explanation: Replace the 'b' or 'd' with 'c' to have the longest repeating substring "ccc".

import java.util.*;
public class LongestSubStringWithSameLetters {

    public static int findLength(String str, int k) {
        int windowStart = 0, maxLength = 0, maxRepeatingCharacter = 0;
        int windowEnd;
        Map<Character, Integer> frequencyMap = new HashMap<>();

        for(windowEnd = 0; windowEnd < str.length(); windowEnd++){
            char rightChar = str.charAt(windowEnd); //ABAB
            frequencyMap.put(rightChar, frequencyMap.getOrDefault(rightChar, 0) + 1);
            maxRepeatingCharacter = Math.max(maxRepeatingCharacter, frequencyMap.get(rightChar));

            // current window size is from windowStart to windowEnd, overall we have a letter which is
            // repeating 'maxRepeatLetterCount' times, this means we can have a window which has one letter
            // repeating 'maxRepeatLetterCount' times and the remaining letters we should replace.
            // if the remaining letters are more than 'k', it is the time to shrink the window as we
            // are not allowed to replace more than 'k' letters

            if((windowEnd - windowStart + 1) - maxRepeatingCharacter > k){
                char leftChar = str.charAt(windowStart);
                frequencyMap.put(leftChar, frequencyMap.get(leftChar) - 1);
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
