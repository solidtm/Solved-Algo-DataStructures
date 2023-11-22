package com.solid.algolearning.javacode.algorithms.patterns.bitwise_xor;

// Here you are asked, given a range of numbers,
// we should find the xor of the numbers say from 0 to a

//When we manually do the xor starting from for the numbers,
//a pattern repeats itself after each 4 numbers

//so simply tha pattern is:
//if(a % 4 == 0) then a  = a
//if(a % 4 == 1) then a  = 1
//if(a % 4 == 2) then a  = a + 1
//if(a % 4 == 3) then a  = 0

//the above will keep repeating until we hit the value of a
public class FindXorOfNumbers {

    public static void main(String[] args) {

        System.out.println(calculateXor(2));
        System.out.println(calculateXorOfAllNums(3, 9));
    }

    //this calculates xor of numbers from 0 to num
    static  int calculateXor(int num){
       if(num % 4 == 0) return num;

       if(num % 4 == 1) return 1;

       if(num % 4 == 2) return num + 1;

       return 0;
    }

    // follow-up question could be to find the XOR of all
    //numbers between 2 numbers a to b inclusive
    // range xor for a, b = xor(b) ^ xor(a - 1)
    static  int calculateXorOfAllNums(int a, int b){
       return calculateXor(b) ^ calculateXor(a - 1);
    }
}
