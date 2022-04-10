package com.solid.algolearning.javacode.algorithms.recursion.easy;

public class ReverseString {

    public static void main(String[] args) {
        System.out.println(reverse("hello"));
    }

    public static String reverse(String s) {
        StringBuilder sb = new StringBuilder();
       helper(0, s.toCharArray(), sb);
       return sb.toString();
    }

    private static void helper(int index, char [] str, StringBuilder sb) {
        if (str == null || index >= str.length) {
            return;
        }
        helper(index + 1, str , sb);
        sb.append(str[index]);
    }
}
