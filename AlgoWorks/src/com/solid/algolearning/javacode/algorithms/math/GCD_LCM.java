package com.solid.algolearning.javacode.algorithms.math;

public class GCD_LCM {
    public static void main(String[] args) {
        System.out.println(hcf(4, 9));
        System.out.println(lcm(2, 4));
    }

    static int hcf(int a, int b){
        if (a == 0) {
            return b;
        }

        return hcf(b % a, a);
    }

    static int lcm(int a, int b){
        return  a * b / hcf(a, b);
    }
}
