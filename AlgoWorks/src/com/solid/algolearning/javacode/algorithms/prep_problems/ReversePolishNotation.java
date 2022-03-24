package com.solid.algolearning.javacode.algorithms.prep_problems;

//https://leetcode.com/problems/evaluate-reverse-polish-notation/

import java.util.*;
public class ReversePolishNotation {
    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"4","13","5","/","+"}));
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        Set<String> operators = new HashSet<>(Arrays.asList("+", "-", "*", "/"));

        for(String val : tokens){
            if(!operators.contains(val)){
                stack.push(Integer.parseInt(val));
            }else {
                int val1 = stack.pop();
                int val2 = stack.pop();
                int res = 0;

                switch (val) {
                    case "+":
                        res = val2 + val1;
                        break;
                    case "-":
                        res = val2 - val1;
                        break;
                    case "/":
                        res = val2 / val1;
                        break;
                    case "*":
                        res = val2 * val1;
                        break;
                }

                stack.push(res);
            }
        }

        return stack.pop();
    }
}
