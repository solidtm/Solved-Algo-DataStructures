package com.solid.algolearning.javacode.algorithms.searching;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ValidateBST {

    public static void main(String[] args) {

    }

    public static boolean isValidBST(TreeNode root) {
// Using a BFS, we can touch each level
// and check if the right node is less than the parent
// or if the left is greater than the parent.
// return false in any case it isn't.
        if(root == null) return false;

        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        boolean returnValue = false;

        TreeNode currentNode = root;
        queue.add(currentNode);

        while(queue.size() > 0){
            currentNode = queue.poll();
            list.add(currentNode.val);

            if(currentNode.left != null && currentNode.left.val < currentNode.val){
                queue.add(currentNode.left);
                returnValue = true;
            }else return false;

            if(currentNode.right != null && currentNode.right.val > currentNode.val){
                queue.add(currentNode.right);
            }else returnValue = false;
        }
        return returnValue;
    }
}
