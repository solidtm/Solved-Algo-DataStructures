package com.solid.algolearning.javacode.algorithms.recursion.easy;

// Given a digit n say 18432, reverse the number to yield 23481
//we can do this using recursion thus:

public class ReverseNum {
    public static void main(String[] args) {
        reverse(18432);
        System.out.println(sum);

        System.out.println(reverse2(18432));

        System.out.println(palindromeNumber(1221));
    }

    //first method of reversal
    static int sum = 0;

    static void reverse(int n){
        if(n == 0) return;

        int rem = n % 10;
        sum = (sum * 10) + rem;
        reverse(n / 10);
    }

    //what if we do not want to take the outside sum value as the main value, what do we do?
    //we can go thus:

    static int reverse2(int n){

        int digits = (int) (Math.log10(n)) + 1; // get the digit to be passed as power of 10 from n using natural logarithm
        return helper(n, digits); // call helper function
    }




    //Second technique iused in reversing numbers
    static int helper(int n, int digits){
      if(n % 10 == n) return n; //if the number is itsel, return it, ie if we have only one number in n

      int rem = n % 10;  //get each digit in n
      n = n / 10;        // remove digit from n
      return rem * (int) Math.pow(10, digits - 1) + helper(n, digits - 1); // multiply the digit by 10 raised to the power and call helper for the rest.
    }



    //Check if a number is a palindrome or not. Basically if a number is equal to it's reverse
    static boolean palindromeNumber(int n){
        return n == reverse2(n);
    }



//    we can also check from star and end of the number to know if it is a palindrome or not using recursion
//      but the number has to be converted to string or array.
}
