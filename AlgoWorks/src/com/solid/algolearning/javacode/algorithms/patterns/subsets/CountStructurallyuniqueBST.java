package com.solid.algolearning.javacode.algorithms.patterns.subsets;
import java.util.*;

//Count of Structurally Unique Binary Search Trees (hard)#
//        Given a number ‘n’, write a function to return the count of structurally unique Binary Search Trees (BST) that can store values 1 to ‘n’.
//
//        Example 1:
//
//        Input: 2
//        Output: 2
//        Explanation: As we saw in the previous problem, there are 2 unique BSTs storing numbers from 1-2.
//        Example 2:
//
//        Input: 3
//        Output: 5
//        Explanation: There will be 5 unique BSTs that can store numbers from 1 to 3.

public class CountStructurallyuniqueBST {
    public static int countTrees(int n) {
        if (n <= 1)
            return 1;
        int count = 0;
        for (int i = 1; i <= n; i++) {
            // making 'i' root of the tree
            int countOfLeftSubtrees = countTrees(i - 1);
            int countOfRightSubtrees = countTrees(n - i);
            count += (countOfLeftSubtrees * countOfRightSubtrees);
        }
        return count;
    }

    static Map<Integer, Integer> map = new HashMap<>();
    public static int countTreesMemoized(int n) {
        if (map.containsKey(n))
            return map.get(n);

        if (n <= 1) return 1;
        int count = 0;

        for (int i = 1; i <= n; i++) {
            // making 'i' root of the tree
            int countOfLeftSubtrees = countTrees(i - 1);
            int countOfRightSubtrees = countTrees(n - i);
            count += (countOfLeftSubtrees * countOfRightSubtrees);
        }
        map.put(n, count);
        return count;
    }

    public static void main(String[] args) {
        int count = countTrees(3);
        int count2 = countTreesMemoized(3);
        System.out.println("Total trees: " + count);
        System.out.println("Total trees: " + count2);
    }
}
