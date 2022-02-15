package com.solid.algolearning.javacode.algorithms.cmd;

public class FindMinimumTimeDifference {

    static String findMinimumTime(String[] arr) {
        if (arr.length <= 1) return "0";

        //loop through the array
        // get the String there
        // split the String into an integer array using the : regex
        // loop through other remaining elements and get difference
        // return difference

        int difference1 = Integer.MAX_VALUE, result;
        int difference2 = Integer.MAX_VALUE;
        int[] value; int l = arr.length - 1;
        StringBuilder sb = new StringBuilder();

        int j = 1;
        for(int i = 0; i < l; i++){
            String s1 = arr[i]; //[16:15]
            String[] arr1 = s1.split(":");

            while (j <= l) {
                String s2 = arr[j]; //[16:00]
                String[] arr2 = s2.split(":");

                difference1 = Math.min(difference1, Math.abs(Integer.parseInt(arr1[0]) - Integer.parseInt(arr2[0])));
                difference2 = Math.min(difference2, Math.abs(Integer.parseInt(arr1[1]) - Integer.parseInt(arr2[1])));

                j++;
            }
        }
        if(difference1 == 0){
            return Integer.toString(difference2);
        }else return Integer.toString(difference1) + ":" + Integer.toString(difference2);
    }


    public static void main(String[] args) {
        System.out.println(findMinimumTime(new String[]{"16:15", "16:00", "12:20"}));
    }
}
