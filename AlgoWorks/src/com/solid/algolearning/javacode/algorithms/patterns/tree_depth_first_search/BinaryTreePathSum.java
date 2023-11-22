package com.solid.algolearning.javacode.algorithms.patterns.tree_depth_first_search;

//Problem Statement#
//        Given a binary tree and a number ‘S’,
//        find if the tree has a path from root-to-leaf
//        such that the sum of all the node values of that path equals ‘S’.


//Solution#
//        As we are trying to search for a root-to-leaf path, we can use the Depth First Search (DFS) technique to solve this problem.
//
//        To recursively traverse a binary tree in a DFS fashion, we can start from the root and at every step, make two recursive calls one for the left and one for the right child.
//
//        Here are the steps for our Binary Tree Path Sum problem:
//
//        Start DFS with the root of the tree.
//        If the current node is not a leaf node, do two things:
//        Subtract the value of the current node from the given number to get a new sum => S = S - node.value
//        Make two recursive calls for both the children of the current node with the new number calculated in the previous step.
//        At every step, see if the current node being visited is a leaf node and if its value is equal to the given number ‘S’. If both these conditions are true, we have found the required root-to-leaf path, therefore return true.
//        If the current node is a leaf but its value is not equal to the given number ‘S’, return false.
//        Let’s take the example-2 mentioned above to visually see our algorithm:


public class BinaryTreePathSum {
    public static boolean hasPath(TreeNode root, int sum) {
        if (root == null) return false;

        // if the current node is a leaf and its value is equal to the sum, we've found a path
        if (root.val == sum && root.left == null && root.right == null)
            return true;

        // recursively call to traverse the left and right sub-tree
        // return true if any of the two recursive call return true
        return hasPath(root.left, sum - root.val) || hasPath(root.right, sum - root.val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        System.out.println("Tree has path: " + hasPath(root, 23));
        System.out.println("Tree has path: " + hasPath(root, 16));
    }

}
