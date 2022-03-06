package com.solid.algolearning.javacode.algorithms.patterns.modified_binary_search;

public class SplitArray {
    public static void main(String[] args) {

    }

    public int splitArray(int[] nums, int m) {
        int start = 0;  // largest value in nums.
        int end =  0;    //sum of all the elements in nums

        //get the start
        for(int i = 0; i < nums.length; i++){
            //get the maximum item from the array
            start = Math.max(start, nums[i]); //In the end this will contain the maximum item in array
            end += nums[i];  //in the end, end will hold the value of the sum of all elements.

            // apply binary search

            while(start < end){
                //try for the middle as potential answer
                int mid = start + (end - start) / 2;

                //calculate how many pieces you can divide this array in with the max sum.
                int sum = 0;
                int pieces = 1; //initially we can have only one piece

                for(int num : nums){
                    if(sum + num > mid){ //this means that you cannot add to the subarray.
                        //use new array.
                        //say you add this sum into the new subarray, then sum = num.
                        sum = num;
                        pieces++; //increment count for subarrays
                    }else{
                        sum += num; //if not the case, just keep adding to the subarray
                    }
                }

                if(pieces > m){  //if we have exceeded the number of subarrays needed,
                    start = mid + 1;  //we check the right hand side of the array
                }else{
                    end = mid;    //if not, we check the left hand side of the array.
                }

            }
        }

        return end;
    }
}
