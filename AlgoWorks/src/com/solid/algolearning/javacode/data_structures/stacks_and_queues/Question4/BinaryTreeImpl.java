package com.solid.algolearning.javacode.data_structures.stacks_and_queues.Question4;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

public class BinaryTreeImpl implements BinaryTree{
    
    //Implementation of the Binary tree interface
    //this class is an implementation of the binary tree interface
    // and implements all the methods for use in the main
    private TreeNode<Airport> rootNode;

    public BinaryTreeImpl(){    //constructing the BinaryTreeImpl object and initializing the rootNode to null.
        rootNode = null;
    }

    //this method checks if the tree is empty.
    @Override
    public boolean isEmpty() {
        return rootNode == null;
    }


    //this method adds an airport to the binary tree
    @Override
    public void add(Airport obj) {
        TreeNode<Airport> newNode = new TreeNode<>(obj, null, null);

        if (rootNode == null){
            rootNode = newNode;
        }else{
            rootNode.insert(newNode);
        }
    }


    //this method counts the  number of football teams present in the tree using a count variable.
    @Override
    public int countNodes() {
        int nodeCount = 0;
        TreeNode<Airport> currNode = rootNode;
        Stack<TreeNode<Airport>> stack = new Stack<>();

        if(currNode == null){
            return 0;
        }

        //using a Depth first search (in order traversal)
        stack.push(currNode);

        while(!stack.isEmpty()){
            TreeNode<Airport> node = stack.pop();
            nodeCount += 1;

            if (node.left != null){
                stack.push(node.left);
            }

            if (node.right != null){
                stack.push(node.right);
            }
        }

        return nodeCount;
    }


    //this method finds the team at the top of the league table using a maxHeap
    @Override
    public Airport findBestAirport() {
        PriorityQueue<Airport> maxHeap = new PriorityQueue<>(Comparator.comparingInt(Airport::getWaitIndex));
        Stack<TreeNode<Airport>> stack = new Stack<>();
        TreeNode<Airport> currNode = rootNode;

        if(currNode == null){
            return null;
        }

        //using a Depth first search (in order traversal)
        stack.push(currNode);

        while(!stack.isEmpty()){
            TreeNode<Airport> node = stack.pop();
            maxHeap.offer(currNode.value);

            if (node.left != null){
                stack.push(node.left);
            }

            if (node.right != null){
                stack.push(node.right);
            }
        }

        return maxHeap.peek();
    }


    //this method finds the team at the bottom of the league table using a minHeap
    @Override
    public Airport findWorstAirport() {
        PriorityQueue<Airport> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(b.getWaitIndex(), a.getWaitIndex()));
        Stack<TreeNode<Airport>> stack = new Stack<>();
        TreeNode<Airport> currNode = rootNode;

        if(currNode == null){
            return null;
        }

        //using a Depth first search (in order traversal)
        stack.push(currNode);

        while(!stack.isEmpty()){
            TreeNode<Airport> node = stack.pop();
            minHeap.offer(currNode.value);

            if (node.left != null){
                stack.push(node.left);
            }

            if (node.right != null){
                stack.push(node.right);
            }
        }
        System.out.println(minHeap);

        return minHeap.peek();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        TreeNode<Airport> currNode = rootNode;
        Stack<TreeNode<Airport>> stack = new Stack<>();

        if(currNode == null){
            return null;
        }

        //using a Depth first search (in order traversal)
        stack.push(currNode);

        while(!stack.isEmpty()){
            TreeNode<Airport> node = stack.pop();
            sb.append(node.value.getAirportName()).append("\n");

            if (node.left != null){
                stack.push(node.left);
            }

            if (node.right != null){
                stack.push(node.right);
            }
        }

        return sb.toString();
    }
}
