package com.solid.algolearning.javacode.algorithms.hackerRankChallenges;

public class Factorial {

    public static void main(String[] args) {
        System.out.println(findFactorialIterative(5));
        System.out.println(findFactorialRecursive(5));
    }

    public static int findFactorialIterative(int number){
        int answer = 1;

        if (number == 2){
            answer = 2;
        }

        while (number > 0){
            answer *= number;
            number--;
        }

        return answer;
    }

    public static int findFactorialRecursive(int number){
        if (number == 0 || number == 1){
            return 1;
        }

        return number * findFactorialRecursive(number - 1);
    }
}
