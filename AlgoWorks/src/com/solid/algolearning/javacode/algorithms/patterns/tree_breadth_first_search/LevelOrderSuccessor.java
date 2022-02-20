package com.solid.algolearning.javacode.algorithms.patterns.tree_breadth_first_search;

//Problem Statement#
//        Given a binary tree and a node, find the level order successor of the given node in the tree.
//        The level order successor is the node that appears right after the given node in the level order traversal.

import java.util.*;
public class LevelOrderSuccessor {
    public static TreeNode findSuccessor(TreeNode root, int key) {
        if (root == null)
            return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();
            // insert the children of current node in the queue
            if (currentNode.left != null)
                queue.offer(currentNode.left);
            if (currentNode.right != null)
                queue.offer(currentNode.right);

            // break if we have found the key
            if (currentNode.val == key)
                break;
        }

        return queue.peek();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        TreeNode result = findSuccessor(root, 12);
        if (result != null)
            System.out.println(result.val + " ");
        result = findSuccessor(root, 9);
        if (result != null)
            System.out.println(result.val + " ");
    }
}
