package com.solid.algolearning.javacode.algorithms.patterns.tree_depth_first_search;

//Similar Problems#
//        Problem 1: Given a binary tree, return all root-to-leaf paths.
//
//        Solution: We can follow a similar approach. We just need to remove the “check for the path sum.”
//
//        Problem 2: Given a binary tree, find the root-to-leaf path with the maximum sum.
//
//        Solution: We need to find the path with the maximum sum. As we traverse all paths, we can keep track of the path with the maximum sum.

import java.util.ArrayList;
import java.util.List;

public class AllRootToLeafPaths {
    public static List<List<Integer>> findPaths(TreeNode root) {
        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<Integer>();
        findAllTreePaths(allPaths, currentPath, root);
        return allPaths;
    }



    public static void findAllTreePaths(List<List<Integer>> result, List<Integer> currentPath, TreeNode currentNode){
        if(currentNode == null){
            return;
        }

        //add the currentNode(root node) to the path
        currentPath.add(currentNode.val);

        // if the current node is a leaf and its value is equal to sum, save the current path
        if(currentNode.left == null && currentNode.right == null){
            result.add(new ArrayList<>(currentPath));
        }
        else{
            //traverse the left subtree
            findAllTreePaths(result, currentPath, currentNode.left);

            //traverse the right subtree
            findAllTreePaths(result, currentPath, currentNode.right);
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
        List<List<Integer>> result = findPaths(root);
        System.out.println("Tree paths with sum " + sum + ": " + result);
    }
}
