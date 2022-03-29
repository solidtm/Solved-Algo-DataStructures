package com.solid.algolearning.javacode.algorithms.math;

public class PrimeNumbers {
    public static void main(String[] args) {
        int n = 5;
        for (int i = 0; i <= n; i++) {
            System.out.println("Number " + i + ": " + isPrime(i));
        }
    }

    static boolean isPrime(int n){
        if(n <= 1) return false;

        int c = 2;
        while(c * c <= n){
            if(n % c == 0) return false;

            c++;
        }

        return true;
    }
}
