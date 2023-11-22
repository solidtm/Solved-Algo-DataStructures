package com.solid.algolearning.javacode.algorithms.codility;

public class FrogJmp {
    public static int solution(int X, int Y, int D) {
        if(D == 0) return 0;

        return (int) Math.ceil((double) (Y - X) / D);
    }
    public static void main(String[] args) {
        System.out.println(solution(10,85,30));
    }
}
