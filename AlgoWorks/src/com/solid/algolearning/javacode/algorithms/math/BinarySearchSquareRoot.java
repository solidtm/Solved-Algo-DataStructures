package com.solid.algolearning.javacode.algorithms.math;
//You are asked to find the square root of a number with a particular precision.
//whether perfect square or not...
public class BinarySearchSquareRoot {
    public static void main(String[] args) {
     int num = 4;
     int precision = 3;

        System.out.printf("%.3f", sqrt(num, precision));
    }

    static double sqrt(int num, int precision){
        int start = 0;
        int end = num;
        double root = 0.0;

        while(start <= end){
            int mid = start + (end - start) / 2;

            if((mid * mid) == num){ //we found a perfect square/root
                root = mid;
            }

            if((mid * mid) > num){ //if the square is greater check the left half
              end = mid - 1;
            }else start = mid + 1;  //else check the right half
        }


        //if not a perfect root we have to loop through the number of precisions to get the values
        double increment = 0.1;
        for (int i = 0; i < precision; i++) {
            while (root * root < num){ //while the values we have is still greater than
                root += increment;
            }

            root -= increment;  //remove the last increment if we have exceeded.
            increment /= 10;    //start adding at the 2nd decimal place until all the precision is exhausted
        }

        return root;
    }
}
