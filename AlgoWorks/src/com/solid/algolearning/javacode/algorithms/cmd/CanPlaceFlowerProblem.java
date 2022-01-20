package com.solid.algolearning.javacode.algorithms.cmd;

public class CanPlaceFlowerProblem {
    public static void main(String[] args) {
        System.out.println(canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 2));
    }

    public static boolean canPlaceFlowers(int[] arr, int n) {
        if(n < 0){
            return false;
        }

        if(n == 0){
            return true;
        }

        if(arr.length == 1){
            return arr[0] == 0 && n == 1;
        }

        //else we have some work to do
        return canPlaceFlow(arr, n);
    }

    public static boolean canPlaceFlow(int[] arr, int n){
        for(int i = 0; i < arr.length; i++){
            if(i == 0 && arr[i] != 1){  //if we are at beginning of array
                if(arr[i + 1] == 0){
                    arr[i] = 1;
                    n--;
                }
            }else if(i == arr.length - 1 && arr[i] != 1){ //if we are at end of array
                if(arr[i - 1] == 0){
                    arr[i] = 1;
                    n--;
                }
            }else if((arr[i] != 1) && (arr[i - 1] == 0 && arr[i + 1] == 0)){
                // try to insert a flower at an index
                arr[i] = 1;
                n--;
            }else continue;

            if(n == 0) return true;
        }
        return false;
    }
}
