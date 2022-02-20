package com.solid.algolearning.javacode.algorithms.patterns.tree_breadth_first_search;

//Problem Statement#
//        Given a binary tree, populate an array to represent its level-by-level traversal in reverse order,
//        i.e., the lowest level comes first. You should populate the values of all nodes in each level from
//        left to right in separate sub-arrays.


//Solution#
//        This problem follows the Binary Tree Level Order Traversal pattern.
//        We can follow the same BFS approach. The only difference will be that instead of appending the current level at the end,
//        we will append the current level at the beginning of the result list.
//
//        Code#
//        Here is what our algorithm will look like; only the highlighted lines have changed.
//        Please note that, for Java, we will use a LinkedList instead of an ArrayList for our result list.
//        As in the case of ArrayList, appending an element at the beginning means shifting all the existing elements.
//        Since we need to append the level array at the beginning of the result list, a LinkedList will be better,
//        as this shifting of elements is not required in a LinkedList. Similarly,
//        we will use a double-ended queue (deque) for Python, C++, and JavaScript.

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ReverseLevelOrderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        List<List<Integer>> result = reverseTraverseIterative(root);
        System.out.println("Level order traversal: " + result);
    }



    public static List<List<Integer>> reverseTraverseIterative(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root); //add top element to queue

        while (!queue.isEmpty()) {
            int levelSize = queue.size();   //get the level we are on
            List<Integer> currentLevel = new ArrayList<>(levelSize); //create an arraylist for that level

            for (int i = 0; i < levelSize; i++) { //loop through that levelsize
                TreeNode currentNode = queue.poll(); //remove the value at the currNode from queue
                currentLevel.add(currentNode.val);   // add the node to the current level

                if (currentNode.left != null)        // insert the children of current node in the queue
                    queue.offer(currentNode.left);
                if (currentNode.right != null)
                    queue.offer(currentNode.right);
            }

            // append the current level at the beginning
            result.add(0, currentLevel);  //insert the arralist for that level to the result list.
        }
        return result;
    }
}
