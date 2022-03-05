package com.solid.algolearning.javacode.algorithms.cmd;

public class NumAfterDoubleReversal {
    public static void main(String[] args) {
        System.out.println(isSameAfterReversals(526));
    }

    public static boolean isSameAfterReversals(int num) {
        if(num < 10) return true;

        int x = reverse(num);
        int y = reverse(x);

        return num == y;
    }

    public static int reverse(int n){     //526
        int result = 0;
        int sum = 0;

        while(n > 0){
            sum = n % 10;
            n = n / 10;

            result = (result * 10) + sum;
        }

        return result;
    }
}
