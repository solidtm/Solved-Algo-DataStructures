package com.solid.algolearning.javacode.algorithms.patterns.tree_depth_first_search;

import java.util.ArrayList;
import java.util.List;

public class MaxRootToLeafPathSum {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);

        int result = maxPathSum(root);
        System.out.println("Tree paths: " + result);
    }

    private static int maxPathSum( TreeNode root) {
        if(root == null) return Integer.MIN_VALUE;

        if(root.left == null && root.right == null){ //if we hit a leaf node.
            return root.val;
        }

        int maxSumFromLeft = maxPathSum(root.left);
        int maxSumFromRight = maxPathSum(root.right);

        return Math.max(maxSumFromLeft, maxSumFromRight) + root.val;
    }
}
