package com.solid.algolearning.javacode.algorithms.patterns.tree_depth_first_search;

//Path with Maximum Sum (hard)#
//        Find the path with the maximum sum in a given binary tree. Write a function that returns the maximum sum.
//
//        A path can be defined as a sequence of nodes between any two nodes and doesn’t necessarily pass through the root.
//        The path must contain at least one node.

//Solution#
//        This problem follows the Binary Tree Path Sum pattern and shares the algorithmic logic with Tree Diameter.
//        We can follow the same DFS approach. The only difference will be to ignore the paths with negative sums.
//        Since we need to find the overall maximum sum, we should ignore any path which has an overall negative sum.

public class PathWithMaxSum {
    private static int globalMaximumSum;

    public static int findMaximumPathSum(TreeNode root) {
        globalMaximumSum = Integer.MIN_VALUE;

        findMaximumPathSumRecursive(root);
        return globalMaximumSum;
    }

    private static int findMaximumPathSumRecursive(TreeNode currentNode) {
        if (currentNode == null)
            return 0;

        int maxPathSumFromLeft = findMaximumPathSumRecursive(currentNode.left);
        int maxPathSumFromRight = findMaximumPathSumRecursive(currentNode.right);

        // ignore paths with negative sums, since we need to find the maximum sum we should
        // ignore any path which has an overall negative sum.
        maxPathSumFromLeft = Math.max(maxPathSumFromLeft, 0);
        maxPathSumFromRight = Math.max(maxPathSumFromRight, 0);

        // maximum path sum at the current node will be equal to the sum from the left subtree +
        // the sum from right subtree + val of current node
        int localMaximumSum = maxPathSumFromLeft + maxPathSumFromRight + currentNode.val;

        // update the global maximum sum
        globalMaximumSum = Math.max(globalMaximumSum, localMaximumSum);

        // maximum sum of any path from the current node will be equal to the maximum of
        // the sums from left or right subtrees plus the value of the current node
        return Math.max(maxPathSumFromLeft, maxPathSumFromRight) + currentNode.val;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println("Maximum Path Sum: " + findMaximumPathSum(root));

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        System.out.println("Maximum Path Sum: " + findMaximumPathSum(root));

        TreeNode root2 = new TreeNode(12);
        root2.left = new TreeNode(7);
        root2.right = new TreeNode(1);
        root2.left.left = new TreeNode(4);
        root2.right.left = new TreeNode(10);
        root2.right.right = new TreeNode(5);
        System.out.println("Maximum Path Sum: " + findMaximumPathSum(root2));

        root = new TreeNode(-1);
        root.left = new TreeNode(-3);
        System.out.println("Maximum Path Sum: " + findMaximumPathSum(root));
    }
}
