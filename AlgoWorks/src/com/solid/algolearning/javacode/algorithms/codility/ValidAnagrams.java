package com.solid.algolearning.javacode.algorithms.codility;

import java.util.Arrays;

public class ValidAnagrams {
    public static boolean isValid(String s, String t){
        if(s.length() == 0 || t.length() == 0){
            return false;
        }

         char[] sChar = s.toCharArray();
         char[] tChar = t.toCharArray();

         Arrays.sort(sChar);
         Arrays.sort(tChar);
         s = new String(Arrays.toString(sChar));
         t = new String(Arrays.toString(tChar));

        return s.equals(t);
    }

    public static void main(String[] args) {
        System.out.println(isValid("anagram", "nagaram"));
        System.out.println(isValid("rat", "car"));
    }
}
