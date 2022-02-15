package com.solid.algolearning.javacode.algorithms.recursion.easy;

public class CountNumOfZeros {
    public static void main(String[] args) {
        System.out.println(countZeros(3020002, 0));
    }

    static int countZeros(int n, int count){
        if(n == 0) return count;

        int digit = n % 10;
        n = n / 10;
        if(digit == 0) return countZeros(n, count + 1);
        else return countZeros(n, count);
    }
}
