package com.solid.algolearning.javacode.algorithms.cmd;

public class RemoveKDigits {
    public static void main(String[] args) {
        System.out.println(removeKdigits("1432219", 3));
    }

    public static String removeKdigits(String num, int k) {

        int min = 0;
        int n = num.length();
        int start = 0;
        String valStr = "";
        String checkStr;

        if(n == k){
            return "0";
        }

        int i = 0, j = 0;
        while(i < n){
            char leftChar = num.charAt(i);
            String startChar = num.substring(0, start);

            valStr = valStr + leftChar;
            if(start == 0 ) checkStr = num.substring(i);
            else checkStr = startChar + num.substring(i + 1);

            i++;
            j++;

            if(j == k){
                min = Math.min(Integer.parseInt(checkStr), Integer.parseInt(valStr));
                valStr = valStr.substring(1);
                checkStr = "";
                j--;
                start++;
            }
        }

        return Integer.toString(min);
    }
}
