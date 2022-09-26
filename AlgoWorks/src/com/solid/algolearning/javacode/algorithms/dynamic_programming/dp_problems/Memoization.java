package com.solid.algolearning.javacode.algorithms.dynamic_programming.dp_problems;

import java.util.HashMap;
import java.util.function.Function;

public class Memoization {

    public static void main(String[] args) {
        System.out.println(addTo80(5));
        System.out.println(addTo80(5));
        System.out.println(addTo80(5));

        System.out.println(fib2(3));
    }

    private static int addTo80(int n) {
        HashMap<Integer, Integer> cache = new HashMap<>(); // removing the cache from global scope.

        Function<Integer, Integer> auxMethod = (a) -> {
            if (cache.containsKey(a)) {
                return cache.get(a);
            } else {
                cache.put(n, n+80);
                return cache.get(n);
            }
        };

        return memoizeAddTo80(n, auxMethod);
    }

    private static int memoizeAddTo80(int n, Function<Integer, Integer> auxMethod) {
        // some checks on input validity
        return  auxMethod.apply(n);
    }



//    Fibonacci sequence recursive algorithm using memoization for optimization
    static HashMap<Integer, Integer> cache = new HashMap<>();
    public static int fibonacciMaster(int n){
        return fib(n);
    }

    private static int fib(int n) {
        if (cache.containsKey(n)){
            return cache.get(n);
        }else {
            if (n < 2){
                return n;
            }else{
//                cache.put((int) (fib(n - 1) + fib(n - 2)));
                return cache.get(n);
            }
        }
    }


//    Fibonacci sequence algorithm using bottom up approach
    static int fib2(int n){
        int[] answer = new int[n];
        answer[0] = 0;
        answer[1] = 1;

        for (int i = 2; i < n; i++){
            answer[i] = answer[i - 2] + answer[i - 1];
        }

        return answer[n-1];
    }
}
