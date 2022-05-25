package com.solid.algolearning.javacode.algorithms.math;

import java.util.*;
public class PrimeNumbers {
    public static void main(String[] args) {
//        int n = 10000;
//        for (int i = 1; i <= n; i++) {
////            System.out.println("Number " + i + ": " + 0);
//
//        }
        System.out.println(solution(0));
        System.out.println(solution(1));
        System.out.println(solution(3));
        System.out.println(solution(11));
        System.out.println(solution(10000));
    }

    static boolean isPrime(int n){
        if(n <= 1) return false;
        //summerofcode.withgoogle.com/?gcp-iap-mode=CLEAR_LOGIN_COOKIE
        int c = 2;
        while(c * c <= n){
            if(n % c == 0) return false;

            c++;
        }

        return true;
    }

    //this is Google Foobar challenge.

    public static String solution(int i) {
        return getPrimeNumbers(i).substring(i, i + 5);
    }

    public static String getPrimeNumbers(int n){
        //generate prime numbers from 0 to 10005
        StringBuilder sb = new StringBuilder();
        int prime = 2;

        while(sb.length() < n + 5){
            sb.append(prime);
            prime += 1;

            while(!isPrime(prime)){
                prime += 1;
            }
        }

        return sb.toString();
    }

//    method to check if a number is prime or not
public static String solutionOp(int n) {
    boolean[] arr = new boolean[10000];
    StringBuilder primes = new StringBuilder();
    Arrays.fill(arr, true);

    for (int i = 2; i < arr.length; i++) {
        if (!arr[i]){
            continue;
        }

        if (arr[i]){
            primes.append(i);
            if (primes.length() >= n + 5){
                break;
            }
        }
        for (int j = i * i; j < arr.length; j+=i) {
            arr[j] = false;
        }
    }

    return primes.substring(n, n + 5);
}

}
