package com.solid.algolearning.javacode.algorithms.greedy;
import java.util.*;
//Problem statement#
//        Given n pipes of different lengths,
//        implement a function that connects these pipes into one pipe.
//        The cost to connect two pipes is equal to the sum of their lengths.
//        We need to connect the pipes with minimum cost.
//
//        Input#
//        The input is an int array where its length is equal to the
//        number of pipes available and its indices are the specific lengths of the pipes.
//
//        Output#
//        The output is the total cost of connecting the pipes.
//
//        Sample input#
//        int [] pipes = {4, 2, 3, 7};  //it means there are a total of 4 pipes
//        // having lengths of 4, 2, 3 & 7 consecutively
//        Sample output#
//        cost = 30;

public class ConnectingNPipes {
    public static void main(String[] args) {

    }

    public static int minCost(int[] pipes){
        int cost = 0;
        int sum = 0;
        Arrays.sort(pipes);
        int[] dp = new int[pipes.length];

        for(int i = 0; i < pipes.length; i++){  //minCost(1,1,2,6) -> dp = [1, ]
            if(i > 0){
                sum = pipes[i] + dp[i - 1];
                dp[i] = sum;
                cost += sum;
            }else{
                dp[i] = pipes[i];
            }

        }

        return cost;
    }
}
