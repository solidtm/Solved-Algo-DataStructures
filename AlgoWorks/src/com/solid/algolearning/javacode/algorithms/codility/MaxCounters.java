package com.solid.algolearning.javacode.algorithms.codility;

//https://app.codility.com/c/run/trainingWAG4KH-X7B/

public class MaxCounters {
    public static void main(String[] args) {

    }

    public static int[] solution(int n, int[] arr) {
        // write your code in Java SE 8
        int[] counter = new int[n];
        int maxVal = Integer.MIN_VALUE;
        int minVal = 0;

        for(int i = 0; i < arr.length; i++){
            int indexVal = arr[i];

            if(indexVal >= 1 && indexVal <= n){ //increment operation
                counter[indexVal - 1] = Math.max(counter[indexVal - 1] + 1, minVal + 1);
                maxVal = Math.max(maxVal, counter[indexVal - 1]);

            }else if(arr[i] == (n + 1)){ // max value set operation
                minVal = maxVal;
            }
        }

        for(int i = 0; i < counter.length; i++){
            counter[i] = Math.max(counter[i], minVal);
        }

        return counter;
    }
}
