package com.solid.algolearning.javacode.algorithms.greedy;

//Problem statement#
//        A girl lost the key to her locker (Note: The key is only numeric).
//        She remembers the number of digits N and the sum S of all the digits of her password.
//        She also knows that her password is the largest number of N digits that can be possible with the given sum S.
//
//        Implement a function that helps her retrieve her key.
//
//        Input#
//        The inputs are the number of digits and the sum of those digits.
//
//        Output#
//        The output prints the largest number that can be created (or the key).
//
//        Sample input#
//        number_of_digits = 3, sum_of_digits = 20
//
//        Sample output#
//        992
//        Note: If no number is possible for a combination of sum_of_digits and number_of_digits, then simply print None.

public class RetrieveKey {
    public static void main(String[] args) {
        int sumOfDigits = 20;
        int numberOfDigits = 3;

        System.out.println("If sum of digits is 20 and number of digits is 3 then ");
        findLargestNumber(numberOfDigits, sumOfDigits);
        System.out.println();

        //Example 2
        sumOfDigits = 100;
        numberOfDigits = 2;

        System.out.println("If sum of digits is 100 and number of digits is 2 then ");
        findLargestNumber(numberOfDigits, sumOfDigits);
    }

    public static void findLargestNumber(int numOfDigits, int sumOfDigits) {
        int[] result = new int[numOfDigits];
        // If sum of digits is 0, then a number is possible only if number of digits is 1.
        if (sumOfDigits == 0) {
            if (numOfDigits == 1) {
                System.out.print(0);
            } else {
                System.out.print("None");
            }
            return;
        }

        // sumOfDigits is greater than the maximum possible sum.
        if (sumOfDigits > 9 * numOfDigits) {
            System.out.print("None");
            return;
        }

        // Fill from most significant digit to least significant digit!
        for (int i = 0; i < numOfDigits; i++) {
            // Place 9 to make the number largest
            if (sumOfDigits >= 9) {
                result[i] = 9;
                sumOfDigits -= 9;
            }
            // If remaining sum becomes less than 9, then fill the remaining sum
            else {
                result[i] = sumOfDigits;
                sumOfDigits = 0;
            }
        }
        for (int i = 0; i < numOfDigits; i++) {
            System.out.print(result[i]);
        }
    }

//    This is a greedy approach. We use the highest number 9 and put it in the leftmost available slot.
//    This idea works because our goal is to find the largest number and 9, being the largest digit, helps us do so.
//
//    This approach fails in certain conditions, like when the sum is less than the number of digits or if a number is not
//    possible in the constraints given.
}
