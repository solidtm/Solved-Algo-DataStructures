package com.solid.algolearning.javacode.algorithms.cmd;

public class RandomizedQueue {

    Node first = null;
    int size = 0;

    private boolean isEmpty(){
        return first == null;
    }

    private  void size(){

    }

    private  void enqueue(){

    }

    private void dequeue(){

    }

    private void remove(){

    }

    private void hasNext(){

    }
}

class Node<Item>{
    Item item;
    Node next;
    Node prev;

    Node(){
        item = null;
        next = null;
        prev = null;
    }
}
