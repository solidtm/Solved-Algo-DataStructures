package com.solid.algolearning.javacode.algorithms.codility;

import java.util.*;

public class EquiLeader {
    private static int dominator;
    private static int dominatorCount;

    public static void main(String[] args) {
        System.out.println(findEquiLeaderCount(new int[]{4, 3, 4, 4, 4, 2}));
    }

    public static int findEquiLeaderCount(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);

            if (freqMap.get(num) > nums.length / 2) { //if we find a leader, save that leader and get its count
                dominator = num;
                dominatorCount = freqMap.get(num);
            }
        }

        int equiLeader = 0;   //var to hold number of equiliders
        int leaderInRightSide = dominatorCount;     //leftside leader
        int leaderInLeftSide = 0;                  //rightside leader
        int countRightSide = nums.length;         //count in right
        int countLeftSide = 0;                   //count in left

        for (int num : nums) {    //go through the numbers again to find the equileaders
            if (num == dominator) {  //if we find the dominator in the array
                leaderInRightSide--;  //reduce the count of leader in the right cos we have found one of its occurence
                leaderInLeftSide++;   //and increment the count of leaders in the left cos that is where we found its occurence
            }

            //regardless of whether we found the dominator, we increase the left side count and the right side count
            //becasue we will be looping throught the array
            countLeftSide++;
            countRightSide--;

            //here we then chek if there is a leader found on both sides of the array
            //this is the equileader then we increment the count of equileader found.
            if (leaderInLeftSide > countLeftSide / 2) { //we have more than half the value in the left
                if (leaderInRightSide > countRightSide / 2) { //we have also found more than half the value in the right.
                    equiLeader++;            //increment the equileader var
                }
            }
        }

        return equiLeader;
    }
}
