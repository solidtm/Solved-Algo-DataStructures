package com.solid.algolearning.javacode.algorithms.patterns.tree_depth_first_search;

//Problem Statement
//        Given a Binary Search Tree and an integer k, we have to determine
//        if there exist two nodes in the BST with sum of values equal to the given target.
//        The input is root of the tree and output can be true or false.

//Input: root = [5, 3, 6, 2, 4, null, 7], k = 9
//        Output: true
//        Explanation: Nodes (3,6), (5,4) and (2,7) have sum equal to 9.
//
//        This problem can be solved using the approaches as discussed below.

import java.util.*;
public class TwoSumBST {
    public static void main(String[] args) {

        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);
        tree.right.left = new TreeNode(6);
        tree.right.right = new TreeNode(7);


//        System.out.println(twoSum(tree, 22));
//        System.out.println(DFSInOrder(tree, 22));

        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(1, 2, 3));
        list.add(Arrays.asList(4, 5, 6));
        list.add(Arrays.asList(9, 8, 9));

        System.out.println(diagonalDifference(list));
        plusMinus(Arrays.asList(1, 1, 0, -1, -1));

    }


//    Using DFS
//    In this approach, we will do a DFS (depth first search) traversal of the tree and look for pairs with the given target.
//    This can be performed efficiently using hashtable.(O(1) time for lookup).
//
//    We can create a hashtable using hashset in java or unordered_set in C++ to store the values of the nodes that we encountered.
//    If the current node and any of the stored values sum up to target, then we found a pair and return true.
//    If we reach the end of the tree, we return false.
//
//    Steps of this approach:
//
//    Let sum be S and define a Hashtable H
//    Do a DFS traversal of Binary Search Tree B
//2.1. For every node N, check if S-N exists in hashtable H
//2.2. If S-N exists, then return TRUE
//2.3. If S-N does not exist, insert N in hashtable H
//    If no pair is found, return FALSE.

//Time and space complexity is O(n) and that is because we are visiting each node once and using the stack space
    private static boolean twoSum(TreeNode root, int sum){
        Set<Integer> visited = new HashSet<>();
        return checkSum(root, sum, visited);
    }

    private static boolean checkSum(TreeNode root, int sum, Set<Integer> visited) {
        if(root == null){
            return false;
        }

        if(visited.contains(sum - root.val)) return true;
        else visited.add(root.val);

        return checkSum(root.left, sum, visited) || checkSum(root.right, sum, visited);
    }

//    Approach 2: Using Inorder traversal
//    In this approach, we can store the node values of the tree in an array using inorder traversal.
//    As we know that the inorder traversal of BST is sorted, we can use two pointers to find the desired pair.
//    We can use two pointers on start and end of the array and search for the target.
//
//    Steps of this approach:
//
//    Let the sum be S.
//    Traverse Binary Search Tree B and store inorder traverse I.
//    Use 2 pointer technique (one pointer at start and other pointer at end) to find a pair where the sum is equal to S.

    private static boolean DFSInOrder(TreeNode root, int sum){
        ArrayList<Integer> list = new ArrayList<>();
        Integer[] nodes =  traverseInOrder(root, list).toArray(new Integer[list.size()]);
        int start = 0, end = nodes.length - 1;

        while(start < end){
            int s = nodes[start] + nodes[end];
            if(s == sum){
                return true;
            }else if(s < sum) start++;
             else end--;
        }
        return false;
    }

    private static ArrayList<Integer> traverseInOrder(TreeNode root, ArrayList<Integer> list) {
        if(root.left != null){
            traverseInOrder(root.left, list);
        }

        list.add(root.val);

        if(root.right != null){
            traverseInOrder(root.right, list);
        }

        return list;
    }

    public static int diagonalDifference(List<List<Integer>> arr) {
        int sumForward = 0, sumBackwards = 0;
        int j = 0;
        for(int i = 0; i < arr.size(); i++){
            sumForward += arr.get(i).get(j++);
        }

        int x = 0;
        for(int i = arr.size() - 1; i >= 0; i--){
            sumBackwards += arr.get(i).get(x++);
        }

        return Math.abs(sumForward - sumBackwards);
    }

    public static void plusMinus(List<Integer> arr) {
        int pos = 0, neg = 0, zeros = 0, n = arr.size();
        for(int i = 0; i < n; i++){
            if(arr.get(i) > 0){
                pos++;
            }else if(arr.get(i) < 0) neg++;
            else zeros++;
        }

        System.out.printf("%.6f", (double) (pos / n));
        System.out.printf("%.6f", (double) (neg / n));
        System.out.printf("%.6f", (double) (zeros / n));
    }

}



















