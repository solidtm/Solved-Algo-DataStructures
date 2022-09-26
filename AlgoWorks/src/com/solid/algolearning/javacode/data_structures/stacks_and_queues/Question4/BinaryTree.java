package com.solid.algolearning.javacode.data_structures.stacks_and_queues.Question4;

//Binary Tree interface
//this interface class models the functions for a binary tree implementation using generics.
public interface BinaryTree{

    //this method checks tree is empty
    boolean isEmpty();

    //this method adds an airport to the binary tree
    void add(Airport obj);

    //this method couts number of nodes in the tree
    int countNodes();

    //this method gets the best airport in tree based on wait index
    Object findBestAirport();

    //this method gets the worst airport in tree based on wait index
    Object findWorstAirport();
}
