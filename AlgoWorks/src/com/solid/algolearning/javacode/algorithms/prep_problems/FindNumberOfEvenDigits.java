package com.solid.algolearning.javacode.algorithms.prep_problems;

//https://leetcode.com/problems/find-numbers-with-even-number-of-digits/
public class FindNumberOfEvenDigits {
    public static void main(String[] args) {
        System.out.println(findNumbers(new int[]{12,345,2,6,7896}));
    }

    public static int findNumbers(int[] nums) {
        int count = 0;
        for(int num : nums) {
            if(even(num)){
                count++;
            }
        }

        return count;
    }

    private static boolean even(int num) {
        int count = 0;
        while(num > 0){
            count++;
            num = num / 10;
        }
        return count % 2 == 0;
    }
}
