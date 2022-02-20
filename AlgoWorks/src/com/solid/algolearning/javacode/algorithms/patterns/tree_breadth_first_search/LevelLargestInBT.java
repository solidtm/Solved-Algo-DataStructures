package com.solid.algolearning.javacode.algorithms.patterns.tree_breadth_first_search;

//Similar Problems#
//        Problem 1: Find the largest value on each level of a binary tree.
//
//        Solution: We will follow a similar approach, but instead of having a running sum we will track the maximum value of each level.


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelLargestInBT {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        List<Integer> result = findLevelLargests(root);
        System.out.print("Level averages are: " + result);
    }

    public static List<Integer> findLevelLargests(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int levelLargest = 0;

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                levelLargest = Math.max(levelLargest, currentNode.val);  // add the node's value to the running sum

                // insert the children of current node to the queue
                if (currentNode.left != null)
                    queue.offer(currentNode.left);
                if (currentNode.right != null)
                    queue.offer(currentNode.right);
            }
            result.add(levelLargest); // append the current level's average to the result array
        }

        return result;
    }
}

