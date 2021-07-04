package com.solid.algolearning.javacode.arrays;

public class ArrayInterviewQuestions {
//    Create a function that reverses a string:
//    "Hi My name is Andrei"  should be:
//    "ierdnA si eman iH"

    public static void main(String[] args) {
        String word = "Hi, My name is ";
        reverse(word);
    }


    public static void reverse(String args) {
//        first thing to do is to always check the inputs:
//        If args is empty, or args is just one letter, there is no need for any reversal simply printout the letter
//        We can also add some input validation to the string to make sure it is an instance of/typeof String class.
//        But in this case its not necessary because the input is always a String
        if (args.isEmpty() || args.length() < 2){
            System.out.println("Hmm, that's not good for reversal");
        }else {
            String[] arr = args.split("");
            for (int i = arr.length - 1; i >= 0; i--) {
                System.out.print(arr[i]);
            }
        }
    }
}
