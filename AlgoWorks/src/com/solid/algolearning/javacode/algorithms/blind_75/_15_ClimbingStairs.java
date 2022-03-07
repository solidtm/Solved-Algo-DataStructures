package com.solid.algolearning.javacode.algorithms.blind_75;

//leetcode problem 70
public class _15_ClimbingStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs(5));
    }

    //here we used bottom approach for dynamic programming.
   // this problem follow fibonnaci sequence problem.
    // we are only using 2 variables iinstead of an entire array.
    //So the goal in this bottom up approach is to reach 0 from n instead of vice versa.
    // Since the 0th value is dependent on the subsequent values.

    public static int climbStairs(int n) {
        int one = 1, two = 1; //the initial steps it will take us to reach n

        for(int i = n - 1; i > 0; i--){
            //update one and 2 to new results
            int temp = one;
            one = one + two;    //add the 2 previous values and shift one
            two = temp;         // shift two to be in one's place.
        }
        return one;
    }
}
