package com.solid.algolearning.javacode.algorithms.codility;

import java.util.*;
public class Nesting {
    public static void main(String[] args) {

    }

    public int solution(String s) {
        Stack<Character> stack = new Stack<>();

        for(char ch : s.toCharArray()){
            if(ch == '(') stack.push(')');
            else if(stack.isEmpty() || stack.pop() != ch) return 0;
        }

        return stack.isEmpty() ? 1 : 0;
    }
}
