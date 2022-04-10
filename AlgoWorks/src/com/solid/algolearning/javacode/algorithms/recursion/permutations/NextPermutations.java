package com.solid.algolearning.javacode.algorithms.recursion.permutations;

import java.util.*;

public class NextPermutations {

    public static void main(String[] args) {
        nextPermutation(new int[]{1, 2, 3});
    }


    public static void nextPermutation(int[] nums) {
        //first convert nums to a string
        //find all the permutations of numsString and return it in an array
        //convert the array to integer array
        //sort the array
        //loop through the array and when i find numString(converterd to int) in it,
        //i will return the value at the next index, and that will be my answer.

        StringBuilder sb = new StringBuilder();
        String numString;
        long[] res = new long[nums.length * 2];

        for(int num : nums){
            sb.append(num);
        }

        numString = sb.toString();   //get the value as a string

        ArrayList<String> permResults = findPermutations("", numString); //find all permutations

        //convert the string list to integer array
        int j = 0;
        for(String str : permResults){
            res[j++] = Long.parseLong(str);
        }

        //sort the array
        Arrays.sort(res);

        //finally, loop through the array to find the next permutation
        for(int i = 0; i < res.length; i++){
            if(res[i] == Long.parseLong(numString)){
                System.out.println(res[i + 1]);
            }
        }
    }


    static ArrayList<String> findPermutations(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList<String> ans = new ArrayList<>();  //local to this call and new arraylist is not created.
        char ch = up.charAt(0);   //get the first element

        for (int i = 0; i <= p.length(); i++) {  //each function call is dependent on the processed length
            String f = p.substring(0, i);  //get the value at first index of p
            String s = p.substring(i);  // get from current index to length of p

            ans.addAll(findPermutations(f + ch + s, up.substring(1)));
        }

        return ans;
    }
}
