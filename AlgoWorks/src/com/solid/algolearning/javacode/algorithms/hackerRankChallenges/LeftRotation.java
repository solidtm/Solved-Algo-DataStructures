package com.solid.algolearning.javacode.algorithms.hackerRankChallenges;

import java.util.Arrays;

public class LeftRotation {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(rotateLeft(array, 4)));
    }

    public static int[] rotateLeft(int[] array, int numOfRotations){
        int[] result = new int[array.length];   //result array
        int rotatedIndex = 0;
        int mainCounter = numOfRotations;
//        If there is no rotations
        if (numOfRotations == 0){
            return array;
        }

//        If there is empty array (assuming the array can contain zeros)
        if (array.length == 0){
            return array;
        }
//        If all other requirements above are met:
//        Loop through from the index of numOfRotations in the array to the end of the array
//        and copy it into the result array
        while (mainCounter < array.length){
            result[rotatedIndex] = array[mainCounter];
            rotatedIndex++;
            mainCounter++;
        }

        mainCounter = 0;
        while(mainCounter < numOfRotations){
            result[rotatedIndex] = array[mainCounter];
            rotatedIndex++;
            mainCounter++;
        }
        return result;
    }
}
