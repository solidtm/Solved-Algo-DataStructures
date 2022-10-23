package com.solid.algolearning.javacode.algorithms.prep_problems;

public class LengthOfLastWord {
    public static void main(String[] args) {
        String s = "   fly me   to   the moon  ";
        System.out.println(lengthOfLastWord(s));
    }

    public static int lengthOfLastWord(String s) {
        if(s.isEmpty()) return 0;

        String str = s.trim();
        int length = 0;

        for(int i = str.length() - 1; i >= 0; i--){
            if(str.charAt(i) != ' ')  length++;
            else break;
        }

        return length;
    }
}
