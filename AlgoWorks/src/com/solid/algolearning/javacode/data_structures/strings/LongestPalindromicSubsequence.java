package com.solid.algolearning.javacode.data_structures.strings;

//Problem Statement#
//        Given a sequence, find the length of its Longest Palindromic Subsequence (LPS).
//        In a palindromic subsequence, elements read the same backward and forward.
//
//        A subsequence is a sequence that can be derived from another sequence by deleting some or no elements
//        without changing the order of the remaining elements.
//
//        Example 1:
//
//        Input: "abdbca"
//        Output: 5
//        Explanation: LPS is "abdba".
//        Example 2:
//
//        Input: = "cddpd"
//        Output: 3
//        Explanation: LPS is "ddd".
//        Example 3:
//
//        Input: = "pqr"
//        Output: 1
//        Explanation: LPS could be "p", "q" or "r".

//Basic Solution#
//        A basic brute-force solution could be to try all the subsequences of the given sequence.
//        We can start processing from the beginning and the end of the sequence. So at any step, we have two options:
//
//        If the element at the beginning and the end are the same,
//        we increment our count by two and make a recursive call for the remaining sequence.
//        We will skip the element either from the beginning or the end to make two recursive calls for the remaining subsequence.
//        If option one applies then it will give us the length of LPS; otherwise,
//        the length of LPS will be the maximum number returned by the two recurse calls from the second option.

//Top-down Dynamic Programming with Memoization# to improve the basic solution
//        We can use an array to store the already solved subproblems.
//
//        The two changing values to our recursive function are the two indexes, startIndex and endIndex.
//        Therefore, we can store the results of all the subproblems in a two-dimensional array.
//        (Another alternative could be to use a hash-table whose key would be a string (startIndex + “|” + endIndex))

public class LongestPalindromicSubsequence {
    public static int findLPSLength(String st) {
        Integer[][] dp = new Integer[st.length()][st.length()];
        return findLPSLengthRecursive(dp, st, 0, st.length()-1);
    }

    private static int findLPSLengthRecursive(Integer[][] dp, String st, int startIndex, int endIndex) {
        if(startIndex > endIndex)
            return 0;

        // every sequence with one element is a palindrome of length 1
        if(startIndex == endIndex)
            return 1;

        if(dp[startIndex][endIndex] == null) {
            // case 1: elements at the beginning and the end are the same
            if(st.charAt(startIndex) == st.charAt(endIndex)) {
                dp[startIndex][endIndex] = 2 + findLPSLengthRecursive(dp, st, startIndex+1, endIndex-1);
            } else {
                // case 2: skip one element either from the beginning or the end
                int c1 =  findLPSLengthRecursive(dp, st, startIndex+1, endIndex);
                int c2 =  findLPSLengthRecursive(dp, st, startIndex, endIndex-1);
                dp[startIndex][endIndex] = Math.max(c1, c2);
            }
        }

        return dp[startIndex][endIndex];
    }

    public static void main(String[] args) {
        System.out.println(findLPSLength("abdbca"));
        System.out.println(findLPSLength("cddpd"));
        System.out.println(findLPSLength("pqr"));
    }
}
// For our basic solution,
//In each function call, we are either having one recursive call or two recursive calls
//        (we will never have three recursive calls); hence, the time complexity of the above algorithm is exponential O(2^n)
//        , where ‘n’ is the length of the input sequence. The space complexity is O(n), which is used to store the recursion stack.


//    Since our memoization array dp[st.length()][st.length()] stores the results for all the subproblems,
//        we can conclude that we will not have more than N*N
//        subproblems (where ‘N’ is the length of the input sequence). This means that our time complexity will be O(N^2)
//
//        The above algorithm will be using O(N^2)
//        space for the memoization array. Other than that we will use O(N)
//        space for the recursion call-stack. So the total space complexity will be O(N^2 + N), which is asymptotically equivalent to O(N^2)

//
