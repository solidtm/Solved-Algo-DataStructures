package com.solid.algolearning.javacode.algorithms.codility;

public class MajorityElement {
    public static void main(String[] args) {

    }

    public int solution(int[] nums) {
        return returnMajority(nums, 0, 0, -1, -1);
    }


    public int returnMajority(int[] arr, int i, int votes, int candidate, int res){
        if(i == arr.length) return res;

        if(votes == 0) {
            candidate = arr[i];
            res = i;
        }
        if(candidate == arr[i]) votes++;
        else votes--;

        return returnMajority(arr, i + 1, votes, candidate, res);
    }
}
