package com.solid.algolearning.javacode.algorithms.cmd;

import java.util.HashMap;

public class WordPatternProb {

    public static void main(String[] args) {
        System.out.println(wordPatternMatch("abba", "dog cat cat dog")); //true
        System.out.println(wordPatternMatch("abba", "dog cat cat fish")); //false
        System.out.println(wordPatternMatch("aaaa", "dog cat cat dog")); //false
    }

    static boolean wordPatternMatch(String pattern, String s){
        int patternLength = pattern.length();

// create an array to input the words in the string s
        String[] stringArr = s.split(" ");

// check if both lengths are equal
        if(patternLength != stringArr.length){
            return false;
        }

//if not so we have some work;
        return  checkBijection(stringArr , pattern);
    }

    static boolean checkBijection(String[] arr, String pattern){
        HashMap<Character, String> mapString = new HashMap<>();

        for(int i = 0; i < arr.length; i++){
            if(mapString.containsKey(pattern.charAt(i))){
                if(!(mapString.get(pattern.charAt(i)).equals(arr[i]))){
                    return false;
                }
            }else{
                if (mapString.containsValue(arr[i])){
                    return false;
                }
                mapString.put(pattern.charAt(i), arr[i]);
            }
        }
        return true;
    }
}
