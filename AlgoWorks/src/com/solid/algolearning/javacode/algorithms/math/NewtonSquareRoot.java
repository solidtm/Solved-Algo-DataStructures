package com.solid.algolearning.javacode.algorithms.math;

//this is newton raphson's formular for getting the square root of a number
//this method works based on the formular that: root(n) = (x - (n / x)) / 2. --> root(n) = 0.5 * (x + (n / x)
//and that we  will keep guessing the value of x and subtracting it from the root we previously calculated,
// this is the error difference precision
//then we can use an error difference precision of 1 or 0.5 to say break the infinite loop.

public class NewtonSquareRoot {
    public static void main(String[] args) {
        System.out.printf("%.3f", sqrt(36));
    }

    static double sqrt(double num){
        double x = num;
        double root;

        while(true){ //infinite while loop to break when the error is less than 1, or we can choose 0.5 for more bounds
            root = 0.5 * (x + (num / x));

            if(Math.abs(root - x) < 0.5){ //found the answer
                break;
            }
            x = root;  //else update the answer
        }
        return root;
    }
}
