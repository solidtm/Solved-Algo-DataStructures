package com.solid.algolearning.javacode.algorithms.searching;

import java.util.ArrayList;
import java.util.List;

public class DepthFirstSearch {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);
        tree.right.left = new TreeNode(6);
        tree.right.right = new TreeNode(7);

        //      1
        //   2     3
        // 4   5 6   7
        System.out.println(DFSInInOrder(tree, list));
        System.out.println(DFSPreOrder(tree, list));
        System.out.println(DFSInPostOrder(tree, list)); //[4, 5, 2, 6, 7, 3, 1]
    }

    public static List<Integer> DFSInInOrder(TreeNode node, List<Integer> list){
        return traverseInOrder(node, list);
    }

    public static List<Integer> DFSPreOrder(TreeNode node, List<Integer> list){
        return traversePreOrder(node, list);
    }

    public static List<Integer> DFSInPostOrder(TreeNode node, List<Integer> list){
        return traversePostOrder(node, list);
    }

    private static List<Integer> traverseInOrder(TreeNode node, List<Integer> list) {
        if(node == null) return new ArrayList<>();
        //we check if the node has a left child, if yes we traverse all the way down using recursion
        if (node.left != null){
            traverseInOrder(node.left, list);
        }
        list.add(node.val); // once there is no more left node put the value to the list
        //we repeat the same process and go all the way down till there is no more children
        if (node.right != null){
            traverseInOrder(node.right, list);
        }

        return list;
    }

    private static List<Integer> traversePreOrder(TreeNode node, List<Integer> list) {
        if(node == null) return new ArrayList<>();
        //Here, we want to add to the list at the very beginning, ie add the parent first and then check left and right nodes
        list.add(node.val); // put the node value to the list before checking if it has left and right children
        if (node.left != null){
            traversePreOrder(node.left, list);
        }
        //we repeat the same process and go all the way down till there is no more children
        if (node.right != null){
            traversePreOrder(node.right, list);
        }

        return list;
    }

    private static List<Integer> traversePostOrder(TreeNode node, List<Integer> list) {
        if(node == null) return new ArrayList<>();
        //Here we check if left has child, and we insert into list, same with right before we visit parent
        if (node.left != null){
            traversePostOrder(node.left, list);
        }
        //we repeat the same process and go all the way down till there is no more children
        if (node.right != null){
            traversePostOrder(node.right, list);
        }

        list.add(node.val);

        return list;
    }
}
