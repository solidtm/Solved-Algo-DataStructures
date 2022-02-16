package com.solid.algolearning.javacode.algorithms.recursion.permutations;



import java.util.ArrayList;

public class LetterCombinations2 {
    public static void main(String[] args) {
        letterCombinations("", "234");
        System.out.println(letterCombinationsReturn("", "234"));
        System.out.println(letterCombinationsCountReturn("", "234"));
    }

    static void letterCombinations(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }

        int digit = up.charAt(0) - '0';   //this converts a char '2 to an int 2
        for (int i = (digit - 1) * 3; i < digit * 3; i++) {
            char ch = (char) ('a' + i);

            letterCombinations(p + ch, up.substring(1));
        }

    }


    static ArrayList<String> letterCombinationsReturn(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> list= new ArrayList<>();
            list.add(p);
            return list;
        }

        int digit = up.charAt(0) - '0';   //this converts a char '2 to an int 2
        ArrayList<String> ans = new ArrayList<>();

        for (int i = (digit - 1) * 3; i < digit * 3; i++) {
            char ch = (char) ('a' + i);
            ans.addAll(letterCombinationsReturn(p + ch, up.substring(1)));
        }
        return ans;
    }

    static int letterCombinationsCountReturn(String p, String up){
        if(up.isEmpty()){
            return 1;
        }

        int count = 0;
        int digit = up.charAt(0) - '0';   //this converts a char '2 to an int 2
        for (int i = (digit - 1) * 3; i < digit * 3; i++) {
            char ch = (char) ('a' + i);

            count = count + letterCombinationsCountReturn(p + ch, up.substring(1));
        }
       return count;
    }
}
