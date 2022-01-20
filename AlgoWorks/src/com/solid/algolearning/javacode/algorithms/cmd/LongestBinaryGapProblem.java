package com.solid.algolearning.javacode.algorithms.cmd;

public class LongestBinaryGapProblem {

//    Algorithm:
// first convert the number from base 10 to base 2
// convert the number to a string
// loop through the string and check if the number at the index is a 0, if it is, increase a counter variable.
// if we hit a 1 in the loop, assign the counter value to another result variable and set the counter to zero.
// before we set the result variable value to the counter value, we check if the initial result value is less than the counter value, and if it is we assign it.
// when we hit the end of the loop, we know that the result value will always hold the value of the longest gap length.


    public static void main(String[] args) {
        System.out.println(longestBinaryGap(1041)); //expected output --> 5
        System.out.println(longestBinaryGap(32));   // expected output --> 0
        System.out.println(longestBinaryGap(9));    // expected output --> 2
        System.out.println(longestBinaryGap(5));    // expected output --> 0
        System.out.println(longestBinaryGap(529));  // expected output --> 4
    }

    static int longestBinaryGap(int n){
        //convert the number to binary
        //String binaryNumber;
        // int remainder = 0;

        //while((n /= 2) != 0){
        //    remainder = n%2;
        //    binaryNumber += n.toString();
        // }

        //we need to reverse the binaryNumber string
        // binaryNumber = reverse(binaryNumber);   //write reverse method later(inefficient)

        String binaryNumber = Integer.toBinaryString(n);
        String[] characters = binaryNumber.split("");
        int counter = 0;
        int result = 0;

        for(String c : characters){
            if(c.equals("0")){
                counter ++;
            }else if (c.equals("1")){
                if(result < counter){
                    result = counter;
                }
                counter = 0;
            }
        }
        return result;
    }
}
