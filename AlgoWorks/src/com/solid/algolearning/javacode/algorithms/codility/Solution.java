package com.solid.algolearning.javacode.algorithms.codility;

import java.util.*;
public class Solution {
    public static void main(String[] args) {
        System.out.println(solution("aaBabcDaA"));
    }

    public static String solution(String str) {
        Set<Character> lowerCase = new HashSet<>();
        Set<Character> upperCase = new HashSet<>();
        List<String> results = new ArrayList<>();

// add lowercase and uppercase values
        for(char ch : str.toCharArray()){
            int ascii = (int) ch;
            if(ascii >= 65 && ascii <=90) { //we know its upper case
                upperCase.add(ch);
            }else if(ascii >= 97 && ascii <=122){//we know its lower case
                lowerCase.add(ch);
            }
        }

//get values with both uppercase and lowercase
        for(Character ch : str.toCharArray()){
            if(lowerCase.contains(ch) && upperCase.contains(Character.toUpperCase(ch))){
                results.add(Character.toString(ch).toUpperCase());
            }else if(upperCase.contains(ch) && lowerCase.contains(Character.toLowerCase(ch))){
                results.add(Character.toString(ch).toUpperCase());
            }
        }


        System.out.println(results);
        String largest = "NO";
        if(results.size() == 1) return results.get(0).toUpperCase();

        else if(results.size() > 1){
            for(int i = 0; i < results.size() - 1; i++){
                if(results.get(i).compareToIgnoreCase(results.get(i + 1)) > 0){
                    largest = results.get(i).toUpperCase();
                }
            }
        }

        return largest;
    }
}
