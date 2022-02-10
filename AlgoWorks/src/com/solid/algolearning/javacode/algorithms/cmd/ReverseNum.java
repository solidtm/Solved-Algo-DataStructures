package com.solid.algolearning.javacode.algorithms.cmd;

public class ReverseNum {
    public static int reverse(int x) {

        int leftRange = Integer.MIN_VALUE;
        int rightRange = Integer.MAX_VALUE;
        String intStringVal, copyOfIntVal;
        int signHolder = 0;
        int stringIntVal;
        int result;
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        if (x == 0) {
            return 0;
        }

        //have work to do here
        copyOfIntVal = Integer.toString(x);
        intStringVal = Integer.toString(Math.abs(x)); //converted
        int l = intStringVal.length() - 1;
        int i = intStringVal.length() - 1;

        if (copyOfIntVal.charAt(0) == '-') {
            signHolder = intStringVal.charAt(0);
        }

        while (i >= 0) {
            char rightChar = intStringVal.charAt(i);
            if (rightChar == '0') {
                i = intStringVal.length() - 2;
            } else {
                sb.append(rightChar);
                i--;
            }
        }


        //convert back to integer
        intStringVal = new String(sb);
        stringIntVal = Integer.parseInt(intStringVal);
        result = stringIntVal;


        if (signHolder > 0) {
            result = -1 * result;
        }

//        if(result > rightRange || result < leftRange) return 0;

        return result;
    }

    public static void main(String[] args) {
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(120));
    }
}
