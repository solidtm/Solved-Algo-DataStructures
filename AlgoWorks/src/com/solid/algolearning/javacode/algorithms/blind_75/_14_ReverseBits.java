package com.solid.algolearning.javacode.algorithms.blind_75;

//leetcode problem 190
public class _14_ReverseBits {
    public static void main(String[] args) {
        System.out.println(reverseBits(32));
    }

    // you need treat n as an unsigned value
    public static int reverseBits(int n) {
        int res = 0;

        for(int i = 0; i < 32; i++){
            int bit = (n >>> i) & 1;   // we are getting the last bit from the digit.

            res = res | (bit << (31 - i));   //shift the bit before appending to result to append the result in the reverse order
        }

        return res;
    }
}
