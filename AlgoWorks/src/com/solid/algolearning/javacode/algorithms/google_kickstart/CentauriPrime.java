package com.solid.algolearning.javacode.algorithms.google_kickstart;

import java.util.*;
public class CentauriPrime {
    private static String getRuler(String kingdom) {
        // TODO: implement this method to determine the ruler name, given the kingdom.
        String ruler = "";
        //we can use a data structure to store the consonants and vowels list
        ArrayList<String> consonants =
                new ArrayList<>(Arrays.asList("b", "c", "d", "f", "g", "h", "j", "k", "l",
                                              "m", "n", "p", "q", "r", "s", "t", "v", "w", "x", "z",
                                              "B", "C", "D", "F", "G", "H", "J", "K", "L",
                                              "M", "N", "P", "Q", "R", "S", "T", "V", "W", "X", "Z"));

        Character lastChar = kingdom.charAt(kingdom.length() - 1);
        String last = String.valueOf(lastChar);

        if(consonants.contains(String.valueOf(lastChar))){
            ruler = "Bob";
        }else if(last.equalsIgnoreCase("y")){
            ruler = "nobody";
        }else {
            ruler = "Alice";
        }
        return ruler;
    }

//    Sample input:
//      3
//    Ameerica
//    Zingily
//    Spain
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int T = in.nextInt();

            for (int t = 1; t <= T; ++t) {
                String kingdom = in.next();
                System.out.println(
                        "Case #" + t + ": " + kingdom + " is ruled by " + getRuler(kingdom) + ".");
            }
        }
    }
}
