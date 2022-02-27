package com.solid.algolearning.javacode.algorithms.patterns.bitwise_xor;

public class Power {
    public static void main(String[] args) {
        System.out.println(calculatePower(3, 6));
    }

    static int calculatePower(int base, int power){
        int ans = 1;

        while (power > 0){
            if((power & 1 ) == 1){
                ans *= base;       // multiply the base to the
            }

            base *= base;          // double the base
            power = power >> 1;    // get the rightmost set bit
        }

        return ans;
    }
}
