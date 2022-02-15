package com.solid.algolearning.javacode.algorithms.recursion.easy;

//write a function that prints numbers from n to 1
//Follow up 1: What if you are given the number n at start and asked to print from 1 to n?
//Follow up 2: What if you are asked to print both 1 to n anad n to 1 at the same time?
//
//solution: using recursion we go thus:
public class NTo1 {
    public static void main(String[] args) {
        printNumsBoth(5);
    }

    static void printNumsNTo1(int n) {
        if (n == 0) return;    //base case

        System.out.println(n);
        printNumsNTo1(n - 1);  //recursive case
    }

    static void printNums1ToN(int n){
        if (n == 0) return;    //base case

        printNums1ToN(n - 1);  //recursive case
        System.out.println(n); //here we have to wait for the function to finish before printing it's result.
    }

    static void printNumsBoth(int n){
        if (n == 0) return;    //base case

        System.out.println(n);  //first print n
        printNumsBoth(n - 1); //enter the recursive call and print the rest
        System.out.println(n);  //same is here...
    }
}
