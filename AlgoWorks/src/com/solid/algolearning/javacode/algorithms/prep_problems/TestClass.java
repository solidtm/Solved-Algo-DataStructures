package com.solid.algolearning.javacode.algorithms.prep_problems;

import java.util.*;
public class TestClass {
    public static void main(String[] args) {
        System.out.println(isPalindrome("race a car"));
    }

    public static boolean isPalindrome(String s) {
        //remove whitespaces (trim string)
        //remove special characters
        //check if it is an anagram   //use 2 pointers

        if(s.equals(" ") || s.isEmpty()) return true;


        s = removeSpecialChars(s);   //remove special characters
        s = s.toLowerCase();   //put to lower case


        //check if it is an anagram using two pointers approach
        String initialString = s;
        char[] charArray = s.toCharArray();
        int start = 0;
        int end = charArray.length - 1;

        String resString = reverse(charArray, start, end);

        return resString.equals(initialString);
    }

    private static String reverse(char[] charArray, int start, int end) {
        StringBuilder sb = new StringBuilder();

        while(start < end){
            swap(charArray, start, end);
            start++;
            end--;
        }

        for (char c : charArray) {
            sb.append(c);
        }

        return sb.toString();
    }


    public static String removeSpecialChars(String s){
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);

            if(Character.isLetter(ch)){
                sb.append(ch);
            }
        }

        return sb.toString();
    }

    public static void swap(char[] arr, int start, int end){   //O(1)
        char temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }


}
