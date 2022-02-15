package com.solid.algolearning.javacode.algorithms.cmd;

import java.util.Arrays;

public class PlusOneProblem {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[]{9, 9})));   //todo: fix this issue
    }

    public static int[] plusOne(int[] digits) {
        // Another way of solving, apart from the below method is:
        // loop through digits and collect the values in a string builder
        // convert to a string and to an integer and add 1
        // convert back to string
        // create an int array and loop through the string result and add each
        // Integer.parseInt(string.charAt(i)) to the result value.


        if(digits.length == 0){
            return digits;
        }

        int start = 0;
        int end = digits.length - 1;
        int upgrade = digits[end] + 1;

        if(digits.length == 1 && !(upgrade >= 1 && upgrade <= 9)){
            String value = String.valueOf(upgrade);
            int[] result = new int[value.length()];

            for(int i = 0; i < value.length(); i++){
                result[i] = Integer.parseInt(value.substring(i, i + 1));
            }
            return result;
        }else if(upgrade >= 1 && upgrade <= 9){ // if the sum is between 1 and 9
            digits[end] = upgrade;
            return digits;
        }else{
            // we have some work to do [4,3,2,9] -> [4,3,3,0]
            start = end;
            String value = String.valueOf(upgrade);
            for(int i = value.length() - 1; i >= 0; i--){
                digits[start] = Integer.parseInt(value.substring(i, i + 1));
                start--;
            }
        }

        return digits;
    }
}
