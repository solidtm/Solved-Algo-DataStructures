package com.solid.algolearning.javacode.algorithms.codility;

public class NumOfDiscIntersections {
    public static void main(String[] args) {

    }

    public static int solution(int[] arr) {
        int[] starts = new int[arr.length];

        //record when each disc have started
        for (int i = 0; i < arr.length; i++) {
            int radius = arr[i];
            int startPos = i - radius;

            if (startPos < 0){
                startPos = 0;
            }

            starts[startPos]++;
        }

        //loop through starts array and keep track of the total
        int total = 0;
        for (int i = 0; i < starts.length; i++) {
            total += starts[i];
            starts[i] = total;
        }

        int totalIntersections = 0;
        for (long i = 0; i < arr.length; i++) {
            long radius = arr[(int) i];
            long endPos = i + radius;

            if (endPos > arr.length - 1){
                endPos = arr.length - 1;
            }

            int intersections = (int) (Math.max(starts[(int) i], starts[(int) endPos]) - (i + 1));
            totalIntersections += intersections;

            if (totalIntersections > 10000000) return -1;
        }

        return totalIntersections;
    }
}
