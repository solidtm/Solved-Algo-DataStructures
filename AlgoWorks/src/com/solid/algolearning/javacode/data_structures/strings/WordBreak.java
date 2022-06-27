package com.solid.algolearning.javacode.data_structures.strings;

import java.util.*;
public class WordBreak {
    public static boolean wordBreak(String inputString, List<String> dictionary) {
        if (inputString == null || inputString.length() == 0) {
            return false;
        }

        if (dictionary == null || dictionary.size() < 2) {
            return false;
        }

        int count = 0;
        for(String word : dictionary){
            if(inputString.contains(word)) count++;
        }

        System.out.println(count);
        return count > 1;
    }

    public static void main(String[] args) {

        List<String> dictionary = new ArrayList<>(Arrays.asList("cats", "dog", "sand", "and", "cat"));

        System.out.println(wordBreak("catsandog", dictionary));

    }
}
