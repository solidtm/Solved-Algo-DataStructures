package com.solid.algolearning.javacode.algorithms.patterns.tree_breadth_first_search;

//Right View of a Binary Tree (easy)#
//        Given a binary tree, return an array containing nodes in its right view.
//        The right view of a binary tree is the set of nodes visible when the tree is seen from the right side.

//Solution#
//        This problem follows the Binary Tree Level Order Traversal pattern. We can follow the same BFS approach.
//        The only additional thing we will be doing is to append the last node of each level to the result array.

import java.util.*;
public class RigheViewOfBT {

    public static List<TreeNode> traverse(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        if(root == null){
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                if (i == levelSize - 1)      //if this is the last node in the level, add it to the result list
                    result.add(currentNode);

                // insert the children of current node in the queue
                if (currentNode.left != null)
                    queue.offer(currentNode.left);
                if (currentNode.right != null)
                    queue.offer(currentNode.right);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        root.left.left.left = new TreeNode(3);
        List<TreeNode> result = traverse(root);
        for (TreeNode node : result) {
            System.out.print(node.val + " ");
        }
    }
}
