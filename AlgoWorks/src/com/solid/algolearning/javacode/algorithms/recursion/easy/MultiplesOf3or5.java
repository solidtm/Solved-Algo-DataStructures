package com.solid.algolearning.javacode.algorithms.recursion.easy;

//If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
//
//        Find the sum of all the multiples of 3 or 5 below 1000.
public class MultiplesOf3or5 {
    public static void main(String[] args) {
        System.out.println(multipleOf3Or5(10, 0, 0));
    }

    static int multipleOf3Or5(int n, int i, int sum){
        if(i == n){
            return sum;
        }
        if(i % 3 == 0 || i % 5 == 0){
            sum += i;
        }
        return multipleOf3Or5(n,i + 1, sum);
    }
}
