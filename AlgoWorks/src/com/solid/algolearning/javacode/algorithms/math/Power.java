package com.solid.algolearning.javacode.algorithms.math;

public class Power {
    public double myPow(double x, int n) {

        //number power 0 is always 1
        if(n == 0){
            return 1;
        }

        //number power 1 is number itself
        else if(n == 1){
            return x;
        }

        //when n is even
        // 2^10 = (2*2)^5
        // x^n = (x*x)^(n/2)
        else if(n % 2 == 0){
            return myPow(x * x, n / 2);
        }

        //when n is odd
        // 4^5 = 4 * 4^4
        // x^n = x * x^(n-1)
        else if(n % 2 == 1){
            return x * myPow(x, n-1);
        }

        //when n is negative
        // 4^-2 = 1/(4^2)
        // x^n = 1/(x^-n)
        else{
            return 1/myPow(x, -n);
        }
    }
}
