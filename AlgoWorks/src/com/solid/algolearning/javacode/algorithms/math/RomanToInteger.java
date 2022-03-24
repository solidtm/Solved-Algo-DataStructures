package com.solid.algolearning.javacode.algorithms.math;

import java.util.*;
public class RomanToInteger {
    public static void main(String[] args) {

    }

    public int romanToInt(String s) {
        //create numeric hashmap
        HashMap<Character, Integer> numericMap = new HashMap<>();
        int result = 0;

        numericMap.put('I', 1);
        numericMap.put('V', 5);
        numericMap.put('X', 10);
        numericMap.put('L', 50);
        numericMap.put('C', 100);
        numericMap.put('D', 500);
        numericMap.put('M', 1000);

        //III
        char[] charArray = s.toCharArray();
        for(int i = 0; i < charArray.length; i++){
            int next = i + 1;
            if(next < charArray.length){
                if(charArray[i] == 'I' && (charArray[next] == 'V' || charArray[next] == 'X')){
                    //we have a subtraction instance
                    result += numericMap.get(charArray[next]) - numericMap.get(charArray[i]);
                    i = next;
                }else if(charArray[i] == 'X' && (charArray[next] == 'L' || charArray[next] == 'C')){
                    //we have a subtraction instance
                    result += numericMap.get(charArray[next]) - numericMap.get(charArray[i]);
                    i = next;
                } else if(charArray[i] == 'C' && (charArray[next] == 'D' || charArray[next] == 'M')){
                    //we have a subtraction instance
                    result += numericMap.get(charArray[next]) - numericMap.get(charArray[i]);
                    i = next;
                }else {
                    //where we have no subtraction instance
                    result += numericMap.get(charArray[i]);
                }

            }else {
                //where we have no subtraction instance
                result += numericMap.get(charArray[i]);
            }
        }

        return result;
    }
}
