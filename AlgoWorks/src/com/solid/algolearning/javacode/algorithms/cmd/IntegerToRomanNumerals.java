package com.solid.algolearning.javacode.algorithms.cmd;

public class IntegerToRomanNumerals {
    public static void main(String[] args) {
        System.out.println(intToRoman(3));
    }

    public static String intToRoman(int num) {
        int[] numValues = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String[] romanEquivalent = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        int k = 12;

        StringBuilder res = new StringBuilder();

        while(num > 0) {
            while (num >= numValues[k]) {
                num -= numValues[k];
                res.append(romanEquivalent[k]);
            }
            k--;
        }

        return res.toString();
    }
}
