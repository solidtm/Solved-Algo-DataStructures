package com.solid.algolearning.javacode.algorithms.blind_75;

public class _8_SearchInRotatedArray {
    public static void main(String[] args) {

    }

    public  static int search(int[] nums, int target) {
        int left = 0;
        int right  = nums.length - 1;

        while (left <= right){
            int mid = left + (left - right) / 2;

            if(nums[mid] == target){ //the middle value could be the target we are looking for
                return mid;
            }

           //check, are we in the left sorted portion?
            //we are checking both scenarios where the array is not rotated and where it is rotated
            if(nums[left] <= nums[mid]){ //we are in the left portion of the array
                if(target > nums[mid] || target < nums[left]){ //array is not rotated
                    left = mid + 1;
                }else {
                    right  = mid - 1;
                }

            //we are in the right portion of the array
            }else {
                if(target < nums[mid] || target > nums[right]){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }
        }

        return -1;
    }
}
