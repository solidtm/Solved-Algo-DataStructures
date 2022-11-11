package com.solid.algolearning.javacode.algorithms.recursion.easy;

public class DigitSumOfString {
    public static void main(String[] args) {
//        System.out.println(digitSum("11111222223", 3));
//        System.out.println(digitSum("00000000", 3));
        System.out.println(digitSum("1234", 2));
    }

    static String digitSum(String s, int k) {
        while(s.length() > k) {
            s = roundTrip(s, k);
        }

        return s;
    }

    static String roundTrip(String s, int k) {
        int start = 0;
        int end = 0;
        StringBuilder ans = new StringBuilder();
        int sum = 0;

        while (start < s.length()) {
            while(end < k && start < s.length()){
                sum += (s.charAt(start) - '0');
                end++;
                start++;
            }
            ans.append(sum);
            sum = 0;
            end = 0;
        }

        return ans.toString();
    }
}
