package com.solid.algolearning.javacode.algorithms.patterns.subsets;
import java.util.*;

//Problem Statement#
//        For a given number ‘N’, write a function to generate all combination of ‘N’ pairs of balanced parentheses.
//
//        Example 1:
//
//        Input: N=2
//        Output: (()), ()()
//        Example 2:
//
//        Input: N=3
//        Output: ((())), (()()), (())(), ()(()), ()()()

public class GenerateParenthesis {
    public static void main(String[] args) {
        List<String> result = generateValidParentheses(2);
        System.out.println("All combinations of balanced parentheses are: " + result);

        result = generateValidParentheses(3);
        System.out.println("All combinations of balanced parentheses are: " + result);
    }

    static List<String> result = new ArrayList<String>();

    public static List<String> generateValidParentheses(int num) {
        generate(num, 0, 0, "");
        return result;
    }

    public static void generate(int n, int openPar, int closedPar, String s){
        if(openPar == n && closedPar == n){
            result.add(s);
            return;
        }

        if(openPar < n){
            generate(n, openPar + 1, closedPar, s += "(");
        }

        if(closedPar < openPar){
            generate(n, openPar, closedPar + 1, s += ")");
        }
    }
}

