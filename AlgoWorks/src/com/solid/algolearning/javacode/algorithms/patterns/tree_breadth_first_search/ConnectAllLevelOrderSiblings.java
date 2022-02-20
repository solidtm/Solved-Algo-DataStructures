package com.solid.algolearning.javacode.algorithms.patterns.tree_breadth_first_search;

//Connect All Level Order Siblings (medium)#
//        Given a binary tree, connect each node with its level order successor.
//        The last node of each level should point to the first node of the next level.

//Solution#
//        This problem follows the Binary Tree Level Order Traversal pattern.
//        We can follow the same BFS approach.
//        The only difference will be that while traversing we will remember (irrespective of the level)
//        the previous node to connect it with the current node.

import java.util.*;
public class ConnectAllLevelOrderSiblings {

    public static void connect(LinkedTreeNode root) {
        if (root == null)
            return;

        Queue<LinkedTreeNode> queue = new LinkedList<>();
        queue.offer(root);
        LinkedTreeNode currentNode = null, previousNode = null;

        while (!queue.isEmpty()) {
            currentNode = queue.poll();

            if (previousNode != null)
                previousNode.next = currentNode;
            previousNode = currentNode;

            // insert the children of current node in the queue
            if (currentNode.left != null)
                queue.offer(currentNode.left);
            if (currentNode.right != null)
                queue.offer(currentNode.right);
        }
    }

    public static void main(String[] args) {
        LinkedTreeNode root = new LinkedTreeNode(12);
        root.left = new LinkedTreeNode(7);
        root.right = new LinkedTreeNode(1);
        root.left.left = new LinkedTreeNode(9);
        root.right.left = new LinkedTreeNode(10);
        root.right.right = new LinkedTreeNode(5);
        connect(root);
        root.printLevelOrder();
    }
}
