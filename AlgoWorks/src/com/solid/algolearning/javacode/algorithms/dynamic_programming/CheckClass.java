package com.solid.algolearning.javacode.algorithms.dynamic_programming;

public class CheckClass {

    public static void main(String[] args) {
        String s = "millenium";
        System.out.println(isUniqueChars(s));
    }

    static boolean isUniqueChars(String str) {
         if (str.length() > 128) return false;

         boolean[] char_set = new boolean[128];
         for (int i= 0; i < str.length(); i++) {
             int val = str.charAt(i);
             System.out.println(val);
             if (char_set[val]) {//Already found this char in string
                 return false;
                 }
             char_set[val] = true;
             }
         return true;
         }
}
