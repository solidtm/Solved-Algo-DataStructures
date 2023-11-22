package com.solid.algolearning.javacode.algorithms.dynamic_programming.dp_learning;

public class EqualSubsetSumPartition {
    public static void main(String[] args) {
        int[] num = {1, 2, 3, 4};
        System.out.println(canPartition(num));
        num = new int[]{1, 1, 3, 4, 7};
        System.out.println(canPartition(num));
        num = new int[]{2, 3, 4, 6};
        System.out.println(canPartition(num));
    }

    public static boolean canPartition(int[] num) {
        int sum = 0;
        for (int j : num) sum += j;  //calculate the sum of all the values

        // if 'sum' is an odd number, we can't have two subsets with equal sum
        if(sum % 2 != 0)
            return false;

        return canPartitionRecursive(num, sum/2, 0);
    }

    private static boolean canPartitionRecursive(int[] num, int sum, int currentIndex) {
        if(sum == 0) return true;

        if (num.length == 0 || currentIndex >= num.length) return false;

        if (num[currentIndex] <= sum){
            if (canPartitionRecursive(num, sum - num[currentIndex], currentIndex + 1)) return true;
        }

        return canPartitionRecursive(num, sum, currentIndex + 1);
    }

    //TC: O(2^n)   because there is no memoization
    //SC: O(n)

//    Bottom up approach:
//    We can use memoization to overcome the overlapping sub-problems. As stated in previous lessons,
//    memoization is when we store the results of all the previously solved sub-problems
//    return the results from memory if we encounter a problem that has already been solved.

//    Since we need to store the results for every subset and for every possible sum,
//    therefore we will be using a two-dimensional array to store the results of the solved sub-problems.
//    The first dimension of the array will represent different subsets and the second dimension
//    will represent different ‘sums’ that we can calculate from each subset.
//    These two dimensions of the array can also be inferred from the two changing values
//    (sum and currentIndex) in our recursive function canPartitionRecursive().


    public static boolean canPartitionTD(int[] num) {
        int sum = 0;
        for (int j : num) sum += j;  //calculate the sum of all the values

        // if 'sum' is an odd number, we can't have two subsets with equal sum
        if(sum % 2 != 0)
            return false;

        Boolean[][] dp = new Boolean[num.length][sum/2 + 1];
        return canPartitionRecursiveTD(dp, num, sum/2, 0);
    }

    private static boolean canPartitionRecursiveTD(Boolean[][] dp, int[] num, int sum, int currentIndex) {
        if(sum == 0) return true;

        if (num.length == 0 || currentIndex >= num.length) return false;

        // if we have not already processed a similar problem
        if (dp[currentIndex][sum] == null) {
            // recursive call after choosing the number at the currentIndex
            // if the number at currentIndex exceeds the sum, we shouldn't process this
            if (num[currentIndex] <= sum) {
                if (canPartitionRecursive(num, sum - num[currentIndex], currentIndex + 1)) {
                    dp[currentIndex][sum] = true;
                    return true;
                }
            }

            // recursive call after excluding the number at the currentIndex
            dp[currentIndex][sum] = canPartitionRecursive(num, sum, currentIndex + 1);
        }

        return dp[currentIndex][sum];
    }

//    The above algorithm has time and space complexity of O(N * S)
//    where ‘N’ represents total numbers and ‘S’ is the total sum of all the numbers.
}
