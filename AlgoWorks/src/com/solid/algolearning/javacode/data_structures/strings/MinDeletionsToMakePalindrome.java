package com.solid.algolearning.javacode.data_structures.strings;


//Problem Statement#
//        Given a string, find the minimum number of characters that we can remove to make it a palindrome.
//
//        Example 1:
//
//        Input: "abdbca"
//        Output: 1
//        Explanation: By removing "c", we get a palindrome "abdba".
//        Example 2:
//
//        Input: = "cddpd"
//        Output: 2
//        Explanation: Deleting "cp", we get a palindrome "ddd".
//        Example 3:
//
//        Input: = "pqr"
//        Output: 2
//        Explanation: We have to remove any two characters to get a palindrome, e.g. if we
//        remove "pq", we get palindrome "r".

//Solution#
//This problem can be easily converted to the Longest Palindromic Subsequence (LPS) problem.
// We can use the fact that LPS is the best subsequence we can have, so any character that is not part of LPS must be removed.
// Please note that it is ‘Longest Palindromic SubSequence’ and not ‘Longest Palindrome Substring’.
//So, our solution for a given string ‘st’ will be: Minimum_deletions_to_make_palindrome = Length(st) - LPS(st)

public class MinDeletionsToMakePalindrome {
    public static int findMinimumDeletions(String st) {
        // subtracting the length of The Longest Palindromic Subsequence from the length of
        // the input string to get minimum number of deletions
        return st.length() - findLPSLength(st);
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
        System.out.println(findMinimumDeletions("abdbca"));
        System.out.println(findMinimumDeletions("cddpd"));
        System.out.println(findMinimumDeletions("pqr"));
    }
}
