package com.solid.algolearning.javacode.algorithms.patterns.tree_depth_first_search;

//Problem Statement#
//        Given a binary tree and a number ‘S’, find all paths from root-to-leaf
//        such that the sum of all the node values of each path equals ‘S’.


import java.util.*;
public class AllPathForASum {

    public static List<List<Integer>> findPaths(TreeNode root, int sum) {
        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<Integer>();
        findAllTreePaths(allPaths, currentPath, root, sum);
        return allPaths;
    }
    


    public static void findAllTreePaths(List<List<Integer>> result, List<Integer> currentPath, TreeNode currentNode, int sum){
        if(currentNode == null){
            return;
        }

        //add the currentNode(root node) to the path
        currentPath.add(currentNode.val);

        // if the current node is a leaf and its value is equal to sum, save the current path
        if(currentNode.val == sum && currentNode.left == null && currentNode.right == null){
            result.add(new ArrayList<>(currentPath));
        }
        else{
            //traverse the left subtree
            findAllTreePaths(result, currentPath, currentNode.left, sum - currentNode.val);

            //traverse the right subtree
            findAllTreePaths(result, currentPath, currentNode.right, sum - currentNode.val);
        }

        // remove the current node from the path to backtrack,
        // we need to remove the current node while we are going up the recursive call stack.
        currentPath.remove(currentPath.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        int sum = 23;
        List<List<Integer>> result = findPaths(root, sum);
        System.out.println("Tree paths with sum " + sum + ": " + result);
    }
}
