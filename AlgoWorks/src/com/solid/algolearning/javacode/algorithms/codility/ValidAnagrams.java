package com.solid.algolearning.javacode.algorithms.codility;

import java.util.Arrays;

public class ValidAnagrams {

    public static void main(String[] args) {
        System.out.println(isValid("anagram", "nagaram"));
        System.out.println(isValid("rat", "car"));
    }


    public static boolean isValid(String s, String t){
        if(s.length() == 0 || t.length() == 0){
            return false;
        }

        //parsing each string as a char array
         char[] sChar = s.toCharArray();
         char[] tChar = t.toCharArray();

         //sorting each string
         Arrays.sort(sChar);
         Arrays.sort(tChar);

         //returning them back to string
         s = Arrays.toString(sChar);
         t = Arrays.toString(tChar);

         //returning true of falase if both strings are equal.
        return s.equals(t);
    }


    public static boolean isValidRecursive(String s, String t){
        if(s.length() == 0 || t.length() == 0){
            return false;
        }

        //parsing each string as a char array
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();

        //sorting each string
        Arrays.sort(sChar);
        Arrays.sort(tChar);

        //returning them back to string
        s = Arrays.toString(sChar);
        t = Arrays.toString(tChar);

        //returning true of falase if both strings are equal.
        return s.equals(t);
    }

}
