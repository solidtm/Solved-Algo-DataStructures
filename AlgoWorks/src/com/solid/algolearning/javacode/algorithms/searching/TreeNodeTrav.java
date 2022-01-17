package com.solid.algolearning.javacode.algorithms.searching;

import java.util.ArrayList;
import com.solid.algolearning.javacode.algorithms.searching.TreeNode;
import java.util.List;

public class TreeNodeTrav {

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);
        tree.right.left = new TreeNode(6);
        tree.right.right = new TreeNode(7);

        System.out.println(traverse(tree));
    }

    public static List<List<Integer>> traverse(TreeNode root) {
        List<List<Integer>> nodeList = new ArrayList<>();
        compute(nodeList, root, 0);
        return nodeList;
    }

    public static void compute(List<List<Integer>> result, TreeNode root, int height){
        if(root == null) return;
        if (height == result.size()){
            ArrayList<Integer> level = new ArrayList<>();
            result.add(level); // create a new level
        }

        result.get(height).add(root.val); // add a value in the  level
        compute(result, root.left, height+1);
        compute(result, root.right, height+1);
    }

//        if(root == null){
//            return new ArrayList<>();
//        }

//        nodeList.add(Collections.singletonList(root.val));
//        while(root.left != null && root.right != null){
//            List<Integer> subNodeList = new ArrayList<Integer>();
//            subNodeList.add(root.left.val);
//            subNodeList.add(root.right.val);
//
//            nodeList.add(subNodeList);
//
//            root.left = root.left.left;
//            root.right = root.right.right;
//
//        }
}
