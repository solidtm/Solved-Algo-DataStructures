package com.solid.algolearning.javacode.algorithms.patterns.two_pointer;

public class ReverseString {
    public static char[] reverseString(char[] arr) {
        if(arr.length == 1 || arr.length == 0){
            return arr;
        }

        int start  = 0, end = arr.length - 1;

        while(start < end){
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }

        return arr;
    }


    public static void main(String[] args) {
        System.out.println(reverseString(new char[]{'h','e','l','l','o'}));
        System.out.println(reverseString(new char[]{'i','n','d','o','m','i','e'}));
    }
}
