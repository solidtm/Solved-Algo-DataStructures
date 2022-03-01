package com.solid.algolearning.javacode.algorithms.blind_75;
//leetcode problem 153


public class _7_FindMinInRotatedSortedArray {
    public static void main(String[] args) {
        System.out.println(findMin(new int[]{3,4,5,1,2}));
    }

    public static int findMin(int[] nums) {
       int result = nums[0];
       int left = 0;
       int right = nums.length - 1;

       while(left <= right){
           if(nums[left] < nums[right]){  //it means array is sorted
               result = Math.min(result, nums[left]);
               break;
           }

           //if the array is rotated
           int mid = left + (right - left) / 2;
           result = Math.min(result, nums[mid]);

           if(nums[mid] >= nums[left]){//we know mid val is in the left part, search right
              left = mid + 1;
           }else{
               right = mid - 1;
           }
       }

       return result;
    }
}
