package com.solid.algolearning.javacode.algorithms.cmd;

public class RemoveDuplicates2 {
    public static int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n < 3)	return n;  //if length of array is 2 we have no work to do

        int i = 2;   //we start at 2 for both i and j pointers
        for (int j = i; j < n; j++)   // [1,1,1,2,2,3]
            if (nums[j] != nums[i - 2])
                nums[i++] = nums[j];

        return i;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1,1,1,2,2,3}));
    }
}
