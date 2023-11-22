package com.solid.algolearning.javacode.algorithms.patterns.tree_breadth_first_search;

//Problem Statement#
//        Given a binary tree, populate an array to represent its level-by-level traversal.
//        You should populate the values of all nodes of each level from left to right in separate sub-arrays.

//Solution#
//        Since we need to traverse all nodes of each level before moving onto the next level, we can use the Breadth First Search (BFS) technique to solve this problem.
//
//        We can use a Queue to efficiently traverse in BFS fashion. Here are the steps of our algorithm:
//
//        Start by pushing the root node to the queue.
//        Keep iterating until the queue is empty.
//        In each iteration, first count the elements in th   e queue (let’s call it levelSize). We will have these many nodes in the current level.
//        Next, remove levelSize nodes from the queue and push their value in an array to represent the current level.
//        After removing each node from the queue, insert both of its children into the queue.
//        If the queue is not empty, repeat from step 3 for the next level.
//        Let’s take the example-2 mentioned above to visually represent our algorithm:

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        List<List<Integer>> result = traverseRecursive(root);
        System.out.println("Level order traversal: " + result);
    }

//    Solution 1: Using Queue and iteration
public static List<List<Integer>> traverseIterative(TreeNode root) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
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

        result.add(currentLevel);   //insert the arraylist for that level to the result list.
    }

    return result;
}

//   Solution 2:
//    Using an ArrayList and recursion
    public static List<List<Integer>> traverseRecursive(TreeNode root) {
        List<List<Integer>> nodeList = new ArrayList<>();
        compute(nodeList, root, 0);
        return nodeList;
    }

    public static void compute(List<List<Integer>> result, TreeNode root, int level){
        if(root == null) return;
        if (level == result.size()){
            ArrayList<Integer> levelList = new ArrayList<>();
            result.add(levelList);
        }

        result.get(level).add(root.val);
        compute(result, root.left, level + 1);
        compute(result, root.right, level + 1);
    }
}
