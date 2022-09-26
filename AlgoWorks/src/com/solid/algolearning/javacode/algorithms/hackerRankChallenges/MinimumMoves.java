package com.solid.algolearning.javacode.algorithms.hackerRankChallenges;

public class MinimumMoves {
    public static void main(String[] args) {
        System.out.println(minMoves(new int[]{1234, 4321}, new int[]{2345, 3214}));
    }

    public static int minMoves(int[] arr1, int[] arr2){

        if(arr1.length == 0 || arr2.length == 0) return 0;

        int result = 0;
        String val1, val2;
        StringBuilder sb = new StringBuilder();
        int x = 0, y = 0;

        for (int i : arr1) {
            sb.append(i);
        }
        val1 = sb.toString();
        sb = new StringBuilder();

        for (int i : arr2) {
            sb.append(i);
        }
        val2 = sb.toString();

        while(x < val1.length() && y < val2.length()){
            int a = Integer.parseInt(String.valueOf(val1.charAt(x++)));
            int b = Integer.parseInt(String.valueOf(val2.charAt(y++)));

            result += Math.abs(a - b);
        }

        return result;
    }
}
