package com.solid.algolearning.javacode.algorithms.patterns.tree_breadth_first_search;

//Problem Statement#
//        Given a binary tree, populate an array to represent its zigzag level order traversal.
//        You should populate the values of all nodes of the first level from left to right,
//        then right to left for the next level and keep alternating in the same manner for the following levels.

//Solution#
//        This problem follows the Binary Tree Level Order Traversal pattern.
//        We can follow the same BFS approach.
//        The only additional step we have to keep in mind is to alternate the level order traversal,
//        which means that for every other level, we will traverse similar to Reverse Level Order Traversal.

import java.util.*;
public class ZigZagTraversal {
    public static List<List<Integer>> traverse(TreeNode root) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if(root == null){
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>(); //using a likned list instead of arraylist
        queue.offer(root);
        boolean hasVisited = true;  //coolean to check if I have visited the right/left side before

        while(!queue.isEmpty()){
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>(levelSize);

            for(int i = 0; i < levelSize; i++){
                TreeNode currentNode =  queue.poll();
                currentLevel.add(currentNode.val);

                if(hasVisited){
                    if(currentNode.right != null){
                        queue.offer(currentNode.right);
                    }
                    if(currentNode.left != null){
                        queue.offer(currentNode.left);
                    }
                    hasVisited = false;
                }else{
                    if(currentNode.left != null){
                        queue.offer(currentNode.left);
                    }
                    if(currentNode.right != null){
                        queue.offer(currentNode.right);
                    }
                    hasVisited = true;
                }
            }
            result.add(currentLevel);
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
        root.right.left.left = new TreeNode(20);
        root.right.left.right = new TreeNode(17);
        List<List<Integer>> result = traverse(root);
        System.out.println("Zigzag traversal: " + result);
    }


}
