package com.solid.algolearning.javacode.algorithms.codility;

public class OddOccurencesInAnArray {
    public static int solution(int[] A) {
        int ans = 0;
        for(int value : A){
            ans ^= value;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{9,3,9,3,9,7,9}));
    }
}
