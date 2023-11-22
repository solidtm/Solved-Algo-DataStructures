package com.solid.algolearning.javacode.algorithms.codility;

public class TapeEquilibrum {

//    public static int solution(int[] A) {
//        int sum = 0, currentSum = 0, diff = Integer.MAX_VALUE;
//
//        for (int val: A) {
//            sum += val;
//        }
//
//        for (int j = 0; j < A.length - 1; j++) {
//            currentSum += j;
//            diff = Math.min(diff, Math.abs(currentSum - (sum - currentSum)));
//        }
//
//        return diff;
//    }

    public static int solution(int[] A) {
        int numbersOnRight = 0, numbersOnLeft = 0, minDiff = Integer.MAX_VALUE;

        for (int val: A) {
            numbersOnRight += val;
        }

        for (int i = 0; i < A.length - 1; i++) {
            numbersOnRight -= A[i];
            numbersOnLeft += A[i];

            minDiff = Math.min(minDiff, Math.abs(numbersOnLeft - numbersOnRight));
        }

        return minDiff;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{3,1,2,4,3}));
    }
}
