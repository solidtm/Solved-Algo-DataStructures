package com.solid.algolearning.javacode.algorithms.recursion.easy;

public class ConceptParsingNums {
    // the code below causes stack overflow error, and that is because n-- and  --n are not the same



    public static void main(String[] args) {
        printNums(5);
    }

    static void printNums(int n) {
        if (n == 0) return;

        System.out.println(n);
//        printNums(n--);//wrong
        printNums(--n);
    }
}
