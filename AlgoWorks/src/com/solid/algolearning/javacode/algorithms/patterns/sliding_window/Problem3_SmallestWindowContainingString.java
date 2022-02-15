package com.solid.algolearning.javacode.algorithms.patterns.sliding_window;

// Smallest Window containing Substring (hard)#
// Given a string and a pattern, find the smallest substring in the given string which has all the characters of the given pattern.

// Example 1:
// Input: String="aabdec", Pattern="abc"
// Output: "abdec"
// Explanation: The smallest substring having all characters of the pattern is "abdec"

// Example 2:
// Input: String="abdbca", Pattern="abc"
// Output: "bca"
// Explanation: The smallest substring having all characters of the pattern is "bca".

// Example 3:
// Input: String="adcad", Pattern="abc"
// Output: ""
// Explanation: No substring in the given string has all characters of the pattern.

// This problem follows the Sliding Window pattern and has a lot of similarities with Permutation in a String with one difference.
// In this problem, we need to find a substring having all characters of the pattern which means that the required substring can have some
// additional characters and doesn’t need to be a permutation of the pattern. Here is how we will manage these differences:

// We will keep a running count of every matching instance of a character.
// Whenever we have matched all the characters, we will try to shrink the window from the beginning,
// keeping track of the smallest substring that has all the matching characters.
// We will stop the shrinking process as soon as we remove a matched character from the sliding window.
// One thing to note here is that we could have redundant matching characters,
// e.g., we might have two ‘a’ in the sliding window when we only need one ‘a’. In that case,
// when we encounter the first ‘a’, we will simply shrink the window without decrementing the matched count.
// We will decrement the matched count when the second ‘a’ goes out of the window.
import java.util.*;
public class Problem3_SmallestWindowContainingString {

    public static String findSubstring(String str, String pattern) {
        int windowStart = 0, matched = 0, minLength = str.length() + 1, subStrStart = 0;
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        for (char chr : pattern.toCharArray())
            charFrequencyMap.put(chr, charFrequencyMap.getOrDefault(chr, 0) + 1);

        // try to extend the range [windowStart, windowEnd]
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            if (charFrequencyMap.containsKey(rightChar)) {
                charFrequencyMap.put(rightChar, charFrequencyMap.get(rightChar) - 1);
                if (charFrequencyMap.get(rightChar) >= 0) // count every matching of a character
                    matched++;
            }

            // shrink the window if we can, finish as soon as we remove a matched character
            while (matched == pattern.length()) {
                if (minLength > windowEnd - windowStart + 1) {
                    minLength = windowEnd - windowStart + 1;
                    subStrStart = windowStart;
                }

                char leftChar = str.charAt(windowStart++);
                if (charFrequencyMap.containsKey(leftChar)) {
                    // note that we could have redundant matching characters, therefore we'll decrement the
                    // matched count only when a useful occurrence of a matched character is going out of the window
                    if (charFrequencyMap.get(leftChar) == 0)
                        matched--;
                    charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) + 1);
                }
            }
        }

        return minLength > str.length() ? "" : str.substring(subStrStart, subStrStart + minLength);
    }

    public static void main(String[] args) {
        System.out.println(findSubstring("aabdec", "abc"));
        System.out.println(findSubstring("abdbca", "abc"));
        System.out.println(findSubstring("adcad", "abc"));
    }
}
