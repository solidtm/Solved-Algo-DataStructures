package com.solid.algolearning.javacode.algorithms.blind_75;

//leetcode problem 191
public class _11_NumberOf1Bits {
    public static void main(String[] args) {
        System.out.println(numOfBits(11));
    }

    //this solution looks at every bit even though it is not a 1
    private static int numOfBits(int n){
        int count = 0;

        while(n != 0){
            if((n & 1) == 1) count++;

            n = n >> 1; //>>> for unsigned bits
        }

        return count;
    }

    //can we come up with a solution that looks at only 1s?

    private static int numOfBitsOptimized(int n){
        int count = 0;

        while(n != 0){
            count++;
            n = n & (n - 1);
        }
        return count;
    }
}
