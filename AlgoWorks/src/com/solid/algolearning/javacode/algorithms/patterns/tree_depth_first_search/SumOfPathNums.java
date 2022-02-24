package com.solid.algolearning.javacode.algorithms.patterns.tree_depth_first_search;

//Problem Statement#
//        Given a binary tree where each node can only have a digit (0-9) value, each root-to-leaf path will represent a number.
//        Find the total sum of all the numbers represented by all paths.

//Solution#
//        This problem follows the Binary Tree Path Sum pattern. We can follow the same DFS approach.
//        The additional thing we need to do is to keep track of the number representing the current path.
//
//        How do we calculate the path number for a node? Taking the first example mentioned above, say we are at node ‘7’.
//        As we know, the path number for this node is ‘17’, which was calculated by: 1 * 10 + 7 => 17.
//        We will follow the same approach to calculate the path number of each node.


public class SumOfPathNums {

    public static int findSumOfPathNumbers(TreeNode root) {
        return findRootToLeafPathNumbers(root, 0);
    }

    private static int findRootToLeafPathNumbers(TreeNode currentNode, int pathSum) {
        if(currentNode == null){
            return 0;
        }

        pathSum = 10 * pathSum + currentNode.val;
        if(currentNode.left == null && currentNode.right == null){
            return pathSum;
        }

        return findRootToLeafPathNumbers(currentNode.left, pathSum) +
                findRootToLeafPathNumbers(currentNode.right, pathSum);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);
        System.out.println("Total Sum of Path Numbers: " + findSumOfPathNumbers(root));
    }
}
