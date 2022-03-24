package com.solid.algolearning.javacode.algorithms.prep_problems;

public class FirstBadVersion {
    public static void main(String[] args) {

    }

    static boolean isBadVersion(int num){
        return true;
    }


    static int findFirstBadVersion(int num){
        long start = 1;
        long end = num;

        while(start <= end){
            long mid = start + (end - start) + 1;

            if(isBadVersion((int) mid)){
                if(isBadVersion((int) mid - 1)){
                    return (int) mid;
                }

                end = mid - 1;
            }else {
                if(isBadVersion((int) mid + 1)){
                    return (int) mid + 1;
                }

                start = mid + 1;
            }
        }

        return (int) start;
    }
}
