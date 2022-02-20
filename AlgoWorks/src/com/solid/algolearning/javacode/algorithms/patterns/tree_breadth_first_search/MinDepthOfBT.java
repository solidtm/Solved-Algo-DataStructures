package com.solid.algolearning.javacode.algorithms.patterns.tree_breadth_first_search;

//Problem Statement#
//        Find the minimum depth of a binary tree.
//        The minimum depth is the number of nodes along the shortest path from the root node to the nearest leaf node.

//Solution#
//        This problem follows the Binary Tree Level Order Traversal pattern. We can follow the same BFS approach.
//        The only difference will be, instead of keeping track of all the nodes in a level, we will only track the depth of the tree.
//        As soon as we find our first leaf node, that level will represent the minimum depth of the tree.


import java.util.*;

public class MinDepthOfBT {


    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        System.out.println("Tree Minimum Depth: " + findMinDepth(root));
        root.left.left = new TreeNode(9);
        root.right.left.left = new TreeNode(11);
        System.out.println("Tree Minimum Depth: " + findMinDepth(root));


        TreeNode root2 = new TreeNode(12);
        root2.left = new TreeNode(7);
        root2.right = new TreeNode(1);
        root2.right.left = new TreeNode(10);
        root2.right.right = new TreeNode(5);
        System.out.println("Tree Minimum Depth: " + findMaxDepth(root2));
        root2.left.left = new TreeNode(9);
        root2.right.left.left = new TreeNode(11);
        System.out.println("Tree Minimum Depth: " + findMaxDepth(root2));
    }


    public static int findMinDepth(TreeNode root) {
        if (root == null)
            return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int minTreeDepth = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            minTreeDepth++;

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();

                //check if this is a leaf node
                if(currentNode.left == null && currentNode.right == null){
                    return minTreeDepth;
                }

                // else insert the children of current node to the queue
                if (currentNode.left != null)
                    queue.offer(currentNode.left);
                if (currentNode.right != null)
                    queue.offer(currentNode.right);
            }// append the current level's average to the result array
        }

        return minTreeDepth;
    }



//    Similar Problems#
//    Problem 1: Given a binary tree, find its maximum depth (or height).
//
//    Solution: We will follow a similar approach. Instead of returning as soon as we find a leaf node,
//    we will keep traversing for all the levels, incrementing maximumDepth each time we complete a level.
//    Here is what the code will look like:


    public static int findMaxDepth(TreeNode root) {
        if (root == null)
            return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int maxTreeDepth = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            maxTreeDepth++;

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                // else insert the children of current node to the queue
                if (currentNode.left != null)
                    queue.offer(currentNode.left);
                if (currentNode.right != null)
                    queue.offer(currentNode.right);
            }// append the current level's average to the result array
        }

        return maxTreeDepth;
    }
}






















