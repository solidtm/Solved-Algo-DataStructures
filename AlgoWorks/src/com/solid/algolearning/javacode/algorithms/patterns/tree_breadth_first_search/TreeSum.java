package com.solid.algolearning.javacode.algorithms.patterns.tree_breadth_first_search;

import java.util.*;

public class TreeSum {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);
        tree.right.left = new TreeNode(6);
        tree.right.right = new TreeNode(7);

        System.out.println(calculateTreeSum(tree));
        System.out.println(calcTreeSumRecursive(tree, 0));
    }

    //using BFS
    static int calculateTreeSum(TreeNode root) {
        if (root == null) return 0;

        int sum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            int current = curr.val;
            sum += current;

            if (curr.left != null) queue.add(curr.left);
            if (curr.right != null) queue.add(curr.right);
        }
        return sum;
    }

    //Using DFS
    static int calcTreeSumRecursive(TreeNode root, int sum){
        if (root == null) return 0;

        int left = calcTreeSumRecursive(root.left, sum);
        int right = calcTreeSumRecursive(root.right, sum);
        sum += root.val + left + right;

        return sum;
    }
}
