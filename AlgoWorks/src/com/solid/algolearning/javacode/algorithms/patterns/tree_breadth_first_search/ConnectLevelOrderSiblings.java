package com.solid.algolearning.javacode.algorithms.patterns.tree_breadth_first_search;

//Problem Statement#
//        Given a binary tree, connect each node with its level order successor.
//        The last node of each level should point to a null node.

//Solution#
//        This problem follows the Binary Tree Level Order Traversal pattern. We can follow the same BFS approach.
//        The only difference is that while traversing a level we will remember the previous node to connect it with the current node.

import java.util.*;
public class ConnectLevelOrderSiblings {

    public static void main(String[] args) {
        LinkedTreeNode root = new LinkedTreeNode(12);
        root.left = new LinkedTreeNode(7);
        root.right = new LinkedTreeNode(1);
        root.left.left = new LinkedTreeNode(9);
        root.right.left = new LinkedTreeNode(10);
        root.right.right = new LinkedTreeNode(5);

        connect(root);

        System.out.println("Level order traversal using 'next' pointer: ");
        root.printLevelOrder();
    }



    public static void connect(LinkedTreeNode root) {
        if (root == null)
            return;

        Queue<LinkedTreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            LinkedTreeNode previousNode = null;
            int levelSize = queue.size();

            // connect all nodes of this level
            for (int i = 0; i < levelSize; i++) {
                LinkedTreeNode currentNode = queue.poll();

                if (previousNode != null)   //if previousNode is null, set it to the currentNode else set it's next to currentNode
                    previousNode.next = currentNode;
                previousNode = currentNode;

                // insert the children of current node in the queue
                if (currentNode.left != null)
                    queue.offer(currentNode.left);
                if (currentNode.right != null)
                    queue.offer(currentNode.right);
            }
        }
    }
}
