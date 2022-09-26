package com.solid.algolearning.javacode.data_structures.strings;

//Problem Statement#
//        Given a string, we want to cut it into pieces such that each piece is a palindrome.
//        Write a function to return the minimum number of cuts needed.
//
//        Example 1:
//
//        Input: "abdbca"
//        Output: 3
//        Explanation: Palindrome pieces are "a", "bdb", "c", "a".
//        Example 2:
//
//        Input: = "cddpd"
//        Output: 2
//        Explanation: Palindrome pieces are "c", "d", "dpd".
//        Example 3:
//
//        Input: = "pqr"
//        Output: 2
//        Explanation: Palindrome pieces are "p", "q", "r".
//        Example 4:
//
//        Input: = "pp"
//        Output: 0
//        Explanation: We do not need to cut, as "pp" is a palindrome.


//        Basic Solution#
//        This problem follows the Longest Palindromic Subsequence pattern and shares a similar
//        approach as that of the Longest Palindromic Substring.
//
//        The brute-force solution will be to try all the substring combinations of the given string.
//        We can start processing from the beginning of the string and keep adding one character at a time.
//        At any step, if we get a palindrome, we take it as one piece and recursively process the
//        remaining length of the string to find the minimum cuts needed.

//The time complexity of the above algorithm is exponential O(2^n),
// where ‘n’ is the length of the input string. The space complexity is O(n)
//which is used to store the recursion stack.
//
//Top-down Dynamic Programming with Memoization#
//        We can memoize both functions findMPPCutsRecursive() and isPalindrome().
//        The two changing values in both these functions are the two indexes; therefore,
//        we can store the results of all the subproblems in a two-dimensional array. (alternatively, we can use a hash-table).

public class PalindromicPartitioning {
    public static int findMPPCuts(String st) {
        Integer[][] dp = new Integer[st.length()][st.length()];
        Boolean[][] dpIsPalindrome = new Boolean[st.length()][st.length()];
        return findMPPCutsRecursive(dp, dpIsPalindrome, st, 0, st.length()-1);
    }

    private static int findMPPCutsRecursive(Integer dp[][], Boolean dpIsPalindrome[][],
                                            String st, int startIndex, int endIndex) {

        if(startIndex >= endIndex || isPalindrome(dpIsPalindrome, st, startIndex, endIndex))
            return 0;

        if(dp[startIndex][endIndex] == null) {
            // at max, we need to cut the string into its 'length-1' pieces
            int minimumCuts = endIndex-startIndex;
            for (int i=startIndex; i <= endIndex; i++) {
                if(isPalindrome(dpIsPalindrome, st, startIndex, i)){
                    // we can cut here as we have a palindrome from 'startIndex' to 'i'
                    minimumCuts = Math.min(minimumCuts, 1+findMPPCutsRecursive(dp, dpIsPalindrome, st, i+1, endIndex));
                }
            }
            dp[startIndex][endIndex] = minimumCuts;
        }
        return dp[startIndex][endIndex];
    }

    private static boolean isPalindrome(Boolean dpIsPalindrome[][], String st, int x, int y) {
        if(dpIsPalindrome[x][y] == null) {
            dpIsPalindrome[x][y]=true;
            int i=x, j=y;
            while(i < j) {
                if(st.charAt(i++) != st.charAt(j--)) {
                    dpIsPalindrome[x][y]=false;
                    break;
                }
                // use memoization to find if the remaining string is a palindrome
                if(i < j && dpIsPalindrome[i][j] != null) {
                    dpIsPalindrome[x][y] = dpIsPalindrome[i][j];
                    break;
                }
            }
        }
        return dpIsPalindrome[x][y];
    }

    public static void main(String[] args) {
        System.out.println(findMPPCuts("abdbca"));
        System.out.println(findMPPCuts("cdpdd"));
        System.out.println(findMPPCuts("pqr"));
        System.out.println(findMPPCuts("pp"));
    }
}

//The time and space complexity of the above algorithm is O(n^2)
//, where ‘n’ is the length of the input string.
