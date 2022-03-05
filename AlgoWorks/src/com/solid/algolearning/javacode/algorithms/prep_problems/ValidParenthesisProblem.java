package com.solid.algolearning.javacode.algorithms.prep_problems;

import java.util.*;
public class ValidParenthesisProblem {

    public static boolean validateParenthesis(char[] arr){
        Stack<Character> bucket = new Stack<>();

        for(char val : arr){
            if(val == '('){
                bucket.push(')');
            }else if(val == '{'){
                bucket.push('}');
            }else if(val == '['){
                bucket.push(']');
            }else {
                if(bucket.isEmpty() || bucket.pop() != val) return false;
            }
        }

        return bucket.isEmpty();
    }


    static public void main( String args[] ) {
        System.out.println(validateParenthesis(new char[]{'(', ')'}));
        System.out.println(validateParenthesis(new char[]{'(', ')', '[',']','{','}'}));
        System.out.println(validateParenthesis(new char[]{'{', '{', '(', '{', ')', '}', '}'}));
        System.out.println(validateParenthesis(new char[]{'(', ']'}));
    }
}
