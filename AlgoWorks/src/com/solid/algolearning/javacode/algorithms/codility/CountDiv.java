package com.solid.algolearning.javacode.algorithms.codility;

//https://app.codility.com/c/run/trainingJFGGWN-5HC/

public class CountDiv {
    public static void main(String[] args) {

    }

    //this code below gets the count of numbers that are divisible by k from the range a - b.
    public int solution(int a, int b, int k) {
        int base = (int) Math.ceil((double) a / k);
        base *= k;
        b -= base;
        int count = (int) Math.floor((double) b / k);
        count++;

        return count;
    }

}
