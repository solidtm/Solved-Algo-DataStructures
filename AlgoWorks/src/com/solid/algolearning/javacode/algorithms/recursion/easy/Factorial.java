package com.solid.algolearning.javacode.algorithms.recursion.easy;

//Given a number n, find the factorial of n
// factorial of a number n = 5 = 5 * 4 * 3 * 2 * 1 = 120
// using recursion we can go thus: knowing that factorial of 5 ie f(5) = 5 * f(4)
// recurrence relation  = f(n) = n * f(n - 1); and base case will be the fact that factorial of 1 = 1.

// Follow up 1: we can do the same for sum of n numbers from n to 0
// Follow up 2: What if you are given a number say 1452, and you are asked to find the sum of the digits?


public class Factorial {
    public static void main(String[] args) {
        System.out.println(factorial(0));
    }

    static int factorial(int n){
        if(n <= 1) return 1;

        return n * factorial(n - 1);
    }

    static int sum(int n){
        if(n <= 1) return 1;

        return n + sum(n - 1);
    }
}
