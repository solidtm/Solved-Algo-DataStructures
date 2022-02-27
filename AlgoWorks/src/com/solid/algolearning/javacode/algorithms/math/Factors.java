package com.solid.algolearning.javacode.algorithms.math;

import java.util.ArrayList;

public class Factors {
    public static void main(String[] args) {
        factorsOptimized(20);
        System.out.println();
        factors(20);
        System.out.println();
        factorsOptimizedNSorted(20);
    }

    static void factors(int n){   //complexity = O(n)
        for (int i = 1; i <= n; i++) {
            if(n % i == 0){
                System.out.print(i + " ");
            }
        }
    }

    static void factorsOptimized(int n){  //complexity is = O(sqrt(n))
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if(n % i == 0){
                if(n / i == i){
                    System.out.print(i + " ");  //this is in case we have something like 6 as a factor of 36, we don't want to print 6 twice
                }else System.out.print(i + " " + n / i + " ");
            }
        }
    }


    //here we want to now use a list to store the other values of n/i we are getting
    static void factorsOptimizedNSorted(int n){  //time and space complexity is = O(sqrt(n))
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if(n % i == 0){
                if(n / i == i){
                    System.out.print(i + " ");  //this is in case we have something like 6 as a factor of 36, we don't want to print 6 twice
                }else {
                    System.out.print(i + " ");
                    list.add(n / i );          //add the remaining numbers to the list, but it will be in descending order
                }
            }
        }


        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.print(list.get(i) + " ");
        }
    }
}
