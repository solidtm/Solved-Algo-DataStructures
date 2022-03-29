package com.solid.algolearning.javacode.algorithms.codility;

public class MinAvgTwoSlice {
    public static void main(String[] args) {

    }

    public static int solution(int[] arr) {

        int indexOfMinOf2 = -1;
        int minSumOf2 = Integer.MAX_VALUE;

        int indexOfMinOf3 = -1;
        int minSumOf3 = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length - 1; i++) {
            int val1 = arr[i];
            int val2 = arr[i + 1];
            int sumOf2 = val1 + val2;

            if (sumOf2 < minSumOf2){
                minSumOf2 = sumOf2;
                indexOfMinOf2 = i;
            }


            if (i < arr.length - 2){
                int val3 = arr[i + 2];
                int sumOf3 = val1 + val2 + val3;

                if (sumOf3 < minSumOf3){
                    minSumOf3 = sumOf3;
                    indexOfMinOf3 = i;
                }
            }
        }

        if(indexOfMinOf3 == -1){
            return indexOfMinOf2;

        }
        double avg2 = (double) minSumOf2 / 2;
        double avg3 = (double) minSumOf3 / 3;

        if(avg2 < avg3){
            return indexOfMinOf2;
        }
        else if(avg3 < avg2){
            return indexOfMinOf3;
        }
        else return Math.min(indexOfMinOf2, indexOfMinOf3);

    }
}
