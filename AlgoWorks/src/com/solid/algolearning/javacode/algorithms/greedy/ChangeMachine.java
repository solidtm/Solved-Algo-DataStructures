package com.solid.algolearning.javacode.algorithms.greedy;

import java.util.*;

public class ChangeMachine {
    public static void main(String[] args) {
        System.out.println("getMinCoins(1) = " + getMinCoins(1));
        System.out.println("getMinCoins(9) = " + getMinCoins(9));
        System.out.println("getMinCoins(10) = " + getMinCoins(10));
        System.out.println("getMinCoins(41) = " + getMinCoins(41));
        System.out.println("getMinCoins(50) = " + getMinCoins(50));
        System.out.println("getMinCoins(90) = " + getMinCoins(90));
        System.out.println("getMinCoins(99) = " + getMinCoins(99));
    }

    public static int [] coins = {25, 10, 5, 1};

    public static ArrayList<Integer> getMinCoins(int amount){ // function to recieve change in the form of coins
        ArrayList<Integer> change = new ArrayList<>();
        int i = 0;

        while(i < coins.length){
            int diff = amount - coins[i];

            if(diff >= 0){
                change.add(coins[i]);
                amount = diff;
            }else i++;

            if(amount <= 0) break;
        }

        return change;
    }
}
