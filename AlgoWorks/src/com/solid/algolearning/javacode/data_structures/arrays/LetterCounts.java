package com.solid.algolearning.javacode.data_structures.arrays;

import java.util.*;

//Letter Count
//        HIDE QUESTION
//        Have the function LetterCount(str) take the str parameter being passed and return the first word with the greatest number of repeated letters.
//        For example: "Today, is the greatest day ever!" should return greatest because it has 2 e's (and 2 t's) and it comes before ever which also has 2 e's.
//        If there are no words with repeating letters return -1. Words will be separated by spaces.


public class LetterCounts {
    public static String LetterCount(String str) {
        if(str.length() < 2) return "-1";

        String currMaxLetterWord = "";
        int count = 0;
        int currentMax = 0;

        Map<String, Integer> wordMap = new HashMap<>();
        Set<Character> set = new HashSet<>();

        str.trim();
        String[] arr = str.split(" ");

        for(int i = 0; i < arr.length; i++){
            wordMap.put(arr[i], i);
        }

        for(Map.Entry<String, Integer> keyWord : wordMap.entrySet()){
            String word = keyWord.getKey();

            for(int i = 0; i < word.length(); i++){
                char ch = word.charAt(i);
                if(set.contains(ch)){
                    count++;
                }else set.add(ch);
            }

            if(count != 0){
                if(count > currentMax){
                    currMaxLetterWord = word;
                    currentMax = count;
                }else if(count == currentMax) {
                    if(wordMap.get(word) < wordMap.get(currMaxLetterWord)){
                        currMaxLetterWord = word;
                    }
                }
            }

            set.clear();
        }

        if(count == 0) return "-1";
        else return currMaxLetterWord;
    }

    public static void main (String[] args) {
        System.out.println(LetterCount("no words here"));
        System.out.println(LetterCount("I lied before"));
        System.out.println(LetterCount("a b c d ee"));
    }
}