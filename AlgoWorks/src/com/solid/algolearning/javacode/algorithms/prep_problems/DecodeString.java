package com.solid.algolearning.javacode.algorithms.prep_problems;

//https://leetcode.com/problems/decode-string/

import java.util.*;

public class DecodeString {
    public static void main(String[] args) {
        System.out.println(decodeString("3[a]2[bc]"));
    }

    public static  String decodeString(String s) {
        Stack<Integer> counts = new Stack<>();  //this will hold the counts of things in braces
        Stack<String> result = new Stack<>();    // this will hold the results

        String res = "";                      //current string we are building as we move along
        int index = 0;                        //index to loop through the input String

        while(index < s.length()){
            if(Character.isDigit(s.charAt(index))){ //if the current character is a digit,
                int count = 0;      //make sure count is correct for multidigit numbers thus:
                while(Character.isDigit(s.charAt(index))){
                    count = 10 * count + (s.charAt(index) - '0');
                    index++;
                }

                counts.push(count);     //push that count to the counts stack
            }else if(s.charAt(index) == '['){   //if it is an opening brace
                result.push(res);               //we put what we have built up in the result stack
                res = "";                       // and reset the string
                index++;
            }else if(s.charAt(index) == ']'){   // if it is a closing brace, we build result found
                StringBuilder temp = new StringBuilder(result.pop());  //remove prev result frm stack
                int count = counts.pop();       //remove the count from stack

                for(int i = 0; i< count; i++){   //append the values the stringbuilder
                    temp.append(res);
                }

                res = temp.toString();           //and assign it back to the built string
                index += 1;
            }else{                        //here if we have a letter instead
                res += s.charAt(index);      //we just build the resut string with that letter
                index++;
            }
        }

        return res;
    }
}
