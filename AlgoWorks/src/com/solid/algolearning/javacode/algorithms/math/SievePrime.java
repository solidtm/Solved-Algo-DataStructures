package com.solid.algolearning.javacode.algorithms.math;
//Here you are given a number and asked to number of all the prime numbers less than that number.

public class SievePrime {
    public static void main(String[] args) {
        int n = 37;
        boolean[] eliminated = new boolean[n + 1]; //with n inclusive

        System.out.println(sievePrime(eliminated, n));

    }

    //false in array means number is prime
    //true means the opposite
    //then we make all the multiples of that number to be set to true
    static int sievePrime(boolean[] eliminated, int n){
        int count = 0;
        for (int i = 2; i <= n; i++) {
           if(!eliminated[i]){ //if false,
               for (int j = i * 2; j <= n; j += i) { //change all the multiples of that number to true
                   eliminated[j] = true;
               }
           }
        }

        for (int i = 2; i <= n; i++) {
            if(!eliminated[i]){ //if the index marks false, it is a prime number
                System.out.print(i + " ");
                count++;
            }
        }

        System.out.println();
        return count;
    }
}
