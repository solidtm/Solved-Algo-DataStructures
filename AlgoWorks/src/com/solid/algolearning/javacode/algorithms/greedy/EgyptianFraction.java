package com.solid.algolearning.javacode.algorithms.greedy;
import java.util.*;

//   Problem statement#
//           Every positive fraction can be represented as the sum of its unique unit fractions.
//           A fraction is a unit fraction if the numerator is 1 and the denominator is a positive integer.
//           For example, 1/3 is a unit fraction. Such a representation is called Egyptian fraction.
//
//           Input#
//           The inputs are two variables, numerator and denominator.
//
//           Output#
//           The output is a string in the format n1/d1 , n2/d2 ...
//
//           Sample input#
//           numerator: 2
//           denominator: 3
//
//           Sample output#
//           1/2, 1/6

public class EgyptianFraction {
    public static void main(String[] args) {
        printEgyptianFraction(2, 3);
        System.out.println();
        printEgyptianFraction(1, 6);
    }

    public static void printEgyptianFraction(int numerator, int denominator){
        //if either numerator or denominator is zero
        if (denominator == 0 || numerator == 0){
            return;
        }

        //numerator divides denominator -> fraction in 1/n form
        if (denominator % numerator == 0) {
            System.out.print("1/" + denominator / numerator);
            return;
        }

        //denominator can divide numerator -> number not a fraction
        if (numerator % denominator == 0) {
            System.out.println(numerator / denominator);
            return;
        }

        //if numerator greater than denominator
        if (numerator > denominator) {
            System.out.println(numerator / denominator + " , ");
            printEgyptianFraction(numerator % denominator, denominator);
            return;
        }
        //denominator  greater than numerator here
        int n = denominator / numerator + 1;
        System.out.print("1/" + n + " , ");
        //call function recursively for remaining part
        printEgyptianFraction(numerator * n - denominator, denominator * n);
    }
}
