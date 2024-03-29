package com.solid.algolearning.javacode.data_structures.strings;

//Find if a string is K-Palindromic#
//        Any string will be called K-palindromic if it can be transformed into a palindrome by removing at most ‘K’ characters from it.
//
//        This problem can easily be converted to our base problem of finding the minimum deletions in a string to make it a palindrome.
//        If the “minimum deletion count” is not more than ‘K’, the string will be K-Palindromic.

public class KPalindromic {
    public static boolean findIfKPalindromic(String st, int k) {
        // subtracting the length of The Longest Palindromic Subsequence from the length of
        // the input string to get minimum number of deletions
        int deletions =  st.length() - findLPSLength(st);

//        If the “minimum deletion count” is not more than ‘K’, the string will be K-Palindromic.
        return deletions <= k;
    }

    public static int findLPSLength(String st) {
        // dp[i][j] stores the length of LPS from index 'i' to index 'j'
        int[][] dp = new int[st.length()][st.length()];

        // every sequence with one element is a palindrome of length 1
        for (int i = 0; i < st.length(); i++)
            dp[i][i] = 1;

        for (int startIndex = st.length() - 1; startIndex >= 0; startIndex--) {
            for (int endIndex = startIndex + 1; endIndex < st.length(); endIndex++) {
                // case 1: elements at the beginning and the end are the same
                if (st.charAt(startIndex) == st.charAt(endIndex)) {
                    dp[startIndex][endIndex] = 2 + dp[startIndex + 1][endIndex - 1];
                } else { // case 2: skip one element either from the beginning or the end
                    dp[startIndex][endIndex] = Math.max(dp[startIndex + 1][endIndex], dp[startIndex][endIndex - 1]);
                }
            }
        }
        return dp[0][st.length() - 1];
    }

    public static void main(String[] args) {
        System.out.println(findIfKPalindromic("abdbca", 3));
        System.out.println(findIfKPalindromic("cddpd", 1));
        System.out.println(findIfKPalindromic("pqr", 4));
    }
}
