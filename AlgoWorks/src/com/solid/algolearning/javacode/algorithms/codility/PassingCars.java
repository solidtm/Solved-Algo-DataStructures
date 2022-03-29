package com.solid.algolearning.javacode.algorithms.codility;

//codility passing cars problem

public class PassingCars {
    public static void main(String[] args) {

    }

    public int solution(int[] arr) {
        int eastBoundCars = 0;
        int numOfPassingCars = 0;

        for(int i : arr){
            if(i == 0){//is an eastbound car
                eastBoundCars++;
            }else{ //we have seen a westbound car
                numOfPassingCars += eastBoundCars;
            }
        }
        return numOfPassingCars;
    }
}
