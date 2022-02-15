package com.solid.algolearning.javacode.algorithms.patterns.fast_slow_pointers;

//Problem Statement#
//        Any number will be called a happy number if, after repeatedly replacing it with a number equal to the sum of the square of all of its digits, leads us to number ‘1’. All other (not-happy) numbers will never reach ‘1’. Instead, they will be stuck in a cycle of numbers which does not include ‘1’.
//
//        Example 1:
//
//        Input: 23
//        Output: true (23 is a happy number)
//        Explanations: Here are the steps to find out that 23 is a happy number:

//         Example 2:
//
//        Input: 12
//        Output: false (12 is not a happy number)
//        Explanations: Here are the steps to find out that 12 is not a happy number:

public class HappyNumber {
    public static boolean find(int num) {
        int slow = num, fast = num;
        do {
            slow = findSquareSum(slow); // move one step
            fast = findSquareSum(findSquareSum(fast)); // move two steps
        } while (slow != fast); // found the cycle

        return slow == 1; // see if the cycle is stuck on the number '1'
    }

    private static int findSquareSum(int num) {
        int sum = 0, digit;
        while (num > 0) {
            digit = num % 10;
            sum += digit * digit;
            num /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(HappyNumber.find(23));
        System.out.println(HappyNumber.find(12));
    }
}
