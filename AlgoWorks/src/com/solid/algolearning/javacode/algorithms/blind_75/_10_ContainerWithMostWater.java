package com.solid.algolearning.javacode.algorithms.blind_75;

//leetcode problem 11
public class _10_ContainerWithMostWater {
    public static void main(String[] args) {

    }

//    BRUTE FORCE O(n^2)
     static int maxArea(int[] heights){
        int res = 0;

         for (int i = 0; i < heights.length; i++) {
             for (int j = i + 1; j < heights.length; j++) {
                 int area = (j - i) * Math.min(heights[i], heights[j]);
                 res = Math.max(res, area);
             }
         }
         return res;
     }

    //    OPTIMIZED O(n) -> using 2 pointers
     static int maxAreaOp(int[] heights){
        int left = 0;
        int right = heights.length - 1;
        int res = 0;


        while(left < right){
            int area = (right - left) * Math.min(heights[left], heights[right]);
            res = Math.max(res, area);

            if(heights[left] < heights[right]){
                left++;
            }else if(heights[right] < heights[left]){
                right--;
            }else{
                right--;
            }
        }

        return res;
     }
}
