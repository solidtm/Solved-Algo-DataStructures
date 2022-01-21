package com.solid.algolearning.javacode.algorithms.searching;

import java.util.*;

public class BreadthFirstSearch {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);
        tree.right.left = new TreeNode(6);
        tree.right.right = new TreeNode(7);

        System.out.println(breadFirstSearchIterative(tree));
//        System.out.println(breadthFirstSearchRecursive(tree, queue, list));
    }

    public static List<Integer> breadFirstSearchIterative(TreeNode root){
        if (root == null) return new ArrayList<>();

        TreeNode currentNode = root;
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        //put the root node in the queue
        queue.add(currentNode);

        while(queue.size() > 0){
            currentNode = queue.poll();   //retrieve the current node in the queue
            list.add(currentNode.val);    //add the value of the current node into the arrayList

            if (currentNode.left != null){
                queue.add(currentNode.left);
            }

            if (currentNode.right != null){
                queue.add(currentNode.right);
            }
        }
        return list;
    }

    public static List<Integer> breadthFirstSearchRecursive(TreeNode root, Queue<TreeNode> queue, List<Integer> list){
        if (queue.size() == 0){
            return list;
        }

        if (root == null){
            return null;
        }

        TreeNode currentNode = root;
        list.add(currentNode.val);

        if (currentNode.left != null){
            queue.add(currentNode.left);
        }

        if (currentNode.right != null){
            queue.add(currentNode.right);
        }

        return breadthFirstSearchRecursive(currentNode, queue, list);
    }
}
