package com.solid.algolearning.javacode.algorithms.codility;

import java.util.Arrays;

public class maximalNumofTriplets {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{-3, 1, 2, -2, 5, 6}));
    }

    public static int solution(int[] arr) {
        int windowStart = 0;
        int windowEnd = 0;
        int maximalProd = Integer.MIN_VALUE;
        int prod = 1, counter = 0;

        while (windowEnd < arr.length){
            int num = arr[windowEnd];
            if (windowEnd != 0 && num < 0){
                windowEnd++;
            }else{
                prod *= num;
                counter++;
                windowEnd++;
            }

            if(counter == 3){
                maximalProd = Math.max(maximalProd, prod);
                prod /= arr[windowStart++];
                counter--;
            }
        }
        return maximalProd;
    }

    public int solution2(int[] arr) {
        Arrays.sort(arr);
        int ans = 1, n = arr.length;

        ans = arr[n-1] * arr[n-2] * arr[n-3];

        return ans;
    }



    //best solution
    int[] minValues = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
    int[] maxValues = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};

    public int solution3(int[] arr) {
        for(int a : arr){
            considerLarge(a);
            considerSmall(a);
        }

        int prod1 = maxValues[0] * maxValues[1] * maxValues[2];
        int prod2 = maxValues[0] * minValues[0] * minValues[1];


        return Math.max(prod1, prod2);  //return the max product between the 2
    }

    //get the 2 smallest numbers
    private void considerSmall(int a){
        if(a < minValues[0]){
            minValues[1] = minValues[0];
            minValues[0] = a;
        }else if(a < minValues[1]){
            minValues[1] = a;
        }
    }

    //get the 2 largest numbers
    private void considerLarge(int a){
        if(a > maxValues[0]){
            maxValues[2] = maxValues[1];
            maxValues[1] = maxValues[0];
            maxValues[0] = a;
        }else if(a > maxValues[1]){
            maxValues[2] = maxValues[1];
            maxValues[1] = a;
        }else if(a > maxValues[2]){
            maxValues[2] = a;
        }
    }
}
