package com.solid.algolearning.javacode.algorithms.prep_problems;
import java.util.*;

public class SmallestSubStringOfAllChars {
    static String getShortestUniqueSubstring(char[] arr, String str) {
        int windowStart = 0;
        int matched = 0;
        int minLength = str.length() + 1;
        int subStringStart = 0;
        Map<Character, Integer> charFrequencyMap = new HashMap<>();

        //putting the values from t into a map
        for(char ch : arr){
            charFrequencyMap.put(ch, charFrequencyMap.getOrDefault(ch, 0) + 1);
        }


        //try to extend the range/window for matching characters
        for(int windowEnd = 0; windowEnd < str.length(); windowEnd++){
            char rightChar = str.charAt(windowEnd);

            if(charFrequencyMap.containsKey(rightChar)){
                charFrequencyMap.put(rightChar, charFrequencyMap.get(rightChar) - 1);  //remove the character from the map

                if(charFrequencyMap.get(rightChar) >= 0){  //count every matching of a character
                    matched++;
                }
            }

            //shrink the window if we can, stop as soon as we remove a matched character
            while(matched == arr.length){
                if(minLength > windowEnd - windowStart + 1){
                    minLength = windowEnd - windowStart + 1;
                    subStringStart = windowStart;
                }

                char leftChar = str.charAt(windowStart++);
                if(charFrequencyMap.containsKey(leftChar)){
                    //we could have redundant characters, therefore we will decrementthe matched count only
                    //when a useful occurence of a matched character is going out of the window

                    if(charFrequencyMap.get(leftChar) == 0){
                        matched--;
                    }
                    charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) + 1);
                }
            }
        }

        return minLength > str.length() ? "" : str.substring(subStringStart, subStringStart + minLength);
    }

    public static void main(String[] args) {
        System.out.println(getShortestUniqueSubstring(new char[]{'x','y','z'}, "xyyzyzyx"));
        System.out.println(getShortestUniqueSubstring(new char[]{'A'}, "B"));
        System.out.println(getShortestUniqueSubstring(new char[]{'A'}, "A"));
        System.out.println(getShortestUniqueSubstring(new char[]{'A','B','C'}, "ADOBECODEBANCDDD"));
        System.out.println(getShortestUniqueSubstring(new char[]{'A','B','C','E','K','I'}, "KADOBECODEBANCDDDEI"));
        System.out.println(getShortestUniqueSubstring(new char[]{'x','y','z', 'r'}, "xyyzyzyx"));
    }
}
