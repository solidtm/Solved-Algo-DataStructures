package com.solid.algolearning.javacode.algorithms.patterns.tree_depth_first_search;
//Tree Diameter (medium)#
//        Given a binary tree, find the length of its diameter.
//        The diameter of a tree is the number of nodes on the longest path between any two leaf nodes. The diameter of a tree may or may not pass through the root.
//
//        Note: You can always assume that there are at least two leaf nodes in the given tree.


//Solution#
//        This problem follows the Binary Tree Path Sum pattern. We can follow the same DFS approach. There will be a few differences:
//
//        At every step, we need to find the height of both children of the current node. For this, we will make two recursive calls similar to DFS.
//        The height of the current node will be equal to the maximum of the heights of its left or right children, plus ‘1’ for the current node.
//        The tree diameter at the current node will be equal to the height of the left child plus the height of the right child plus ‘1’
//        for the current node: diameter = leftTreeHeight + rightTreeHeight + 1.
//        To find the overall tree diameter, we will use a class level variable.
//        This variable will store the maximum diameter of all the nodes visited so far, hence, eventually, it will have the final tree diameter.

public class TreeDiameter {
    private static int treeDiameter = 0;

    public static int findDiameter(TreeNode root) {
        calculateHeight(root);
        return treeDiameter;
    }

    private static int calculateHeight(TreeNode currentNode) {
        if (currentNode == null)
            return 0;

        int leftTreeHeight = calculateHeight(currentNode.left);
        int rightTreeHeight = calculateHeight(currentNode.right);

        // if the current node doesn't have a left or right subtree, we can't have
        // a path passing through it, since we need a leaf node on each side
        if (leftTreeHeight != 0 && rightTreeHeight != 0) {

            // diameter at the current node will be equal to the height of left subtree +
            // the height of right sub-trees + '1' for the current node
            int diameter = leftTreeHeight + rightTreeHeight + 1;

            // update the global tree diameter
            treeDiameter = Math.max(treeDiameter, diameter);
        }

        // height of the current node will be equal to the maximum of the heights of
        // left or right subtrees plus '1' for the current node
        return Math.max(leftTreeHeight, rightTreeHeight) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        System.out.println("Tree Diameter: " + TreeDiameter.findDiameter(root));
        root.left.left = null;
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        root.right.left.right.left = new TreeNode(10);
        root.right.right.left.left = new TreeNode(11);
        System.out.println("Tree Diameter: " + TreeDiameter.findDiameter(root));
    }
}
