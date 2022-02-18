package com.solid.algolearning.javacode.algorithms.cmd;

public class ValidPalindrome2 {
    public static void main(String[] args) {
        System.out.println(validPalindrome("abca"));
    }

    public static boolean validPalindrome(String s) {

        boolean result = false;
        StringBuilder sb = new StringBuilder(s);
        StringBuilder sb2 = new StringBuilder();

        for(int i = 0; i < s.length(); i++){
            sb2 = sb.deleteCharAt(i);
            if(isPalindrome(sb2.toString(), 0, sb2.toString().length() - 1)) result = true;
            else result = false;
        }

        return result;
    }

    public static boolean isPalindrome(String s, int i, int j){
        while(i < j){
            if(s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }
}
