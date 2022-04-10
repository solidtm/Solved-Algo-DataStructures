package com.solid.algolearning.javacode.algorithms.prep_problems;

public class KthSymbolInGrammer {
    public static void main(String[] args) {
        System.out.println(kthGrammar(30, 12));   //0110
    }

    public static int kthGrammar(int n, int k) {
        String[] dp = new String[n];
        dp[0] = "0";
        if(!(n <= 1)) dp[1] = "01";

        String ans = getGrammer(n, dp);

        return grammer(ans, k);
    }


    public static int grammer(String ans, int k){
        char ch = ans.charAt(k - 1);
        return Integer.parseInt(Character.toString(ch));
    }

    public  static String getGrammer(int n, String[] dp){
        if(n == 1) return dp[0];
        if(n == 2) return dp[1];

        StringBuilder sb = new StringBuilder();
        String res = getGrammer(n - 1, dp);
        for(char ch : res.toCharArray()){
            if(ch == '0') sb.append(ch).append('1');

            else if(ch == '1')sb.append(ch).append('0');
        }

        return sb.toString();
    }
}
