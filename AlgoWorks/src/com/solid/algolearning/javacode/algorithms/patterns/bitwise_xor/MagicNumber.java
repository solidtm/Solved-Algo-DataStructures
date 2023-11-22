package com.solid.algolearning.javacode.algorithms.patterns.bitwise_xor;

public class MagicNumber {
    public static void main(String[] args) {

        System.out.println(magicNumber(6));
    }


    static int magicNumber(int n){
        int answer = 0;
        int base = 5;

        while(n > 0){
            int lastDigit = n & 1; //get the last number
            n = n >> 1;  //ignore the last number
            answer += lastDigit * base; //multiply by the base and add to the previous answer
            base = base * 5;   //increment the base
        }

        return answer;
    }
}
