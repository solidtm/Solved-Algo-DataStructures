package com.solid.algolearning.javacode.algorithms.cmd;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public static void main(String[] args) {
        System.out.println(summaryRanges(new int[]{0,1,2,4,5,7}));
    }

    public static List<String> summaryRanges(int[] nums) {
        int left = 0;
        int right = 0;
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        if (nums.length == 0) {  //we have no elements to check
            return result;
        }


        for(int i = 0; i < nums.length; i++){
            int currentNumber = nums[i];
            sb.setLength(0);

            while(i + 1 < nums.length && (nums[i + 1] - nums[i]) == 1){
                i++;
            }

            if(currentNumber != nums[i]){
                sb.append(currentNumber);
                sb.append("->");
                sb.append(nums[i]);
            }else{
                sb.append(currentNumber);
            }

            result.add(sb.toString());
        }

        return result;
    }
}
