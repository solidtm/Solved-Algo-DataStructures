package com.solid.algolearning.javacode.algorithms.prep_problems;

import java.util.*;
public class ValidParenthesisProblem {

    public static boolean validateParenthesis(char[] arr){
        Map<Character, Character> charMap = new HashMap<>();
        Stack<Character> bucket = new Stack<>();
        charMap.put(')','(');
        charMap.put('}','{');
        charMap.put(']','[');

        for(char val : arr){
            if(val == '(' || val == '{' || val == '['){
                bucket.add(val);
            }else if(charMap.get(val) == bucket.peek()){
                bucket.pop();
            }else return false;
        }

        if(bucket.size() != 0) return false;
        return true;
    }


    static public void main( String args[] ) {
        System.out.println(validateParenthesis(new char[]{'(', ')'}));
        System.out.println(validateParenthesis(new char[]{'(', ')', '[',']','{','}'}));
        System.out.println(validateParenthesis(new char[]{'{', '{', '(', '{', ')', '}', '}'}));
        System.out.println(validateParenthesis(new char[]{'(', ']'}));
    }
}
