package com.solid.algolearning.javacode.data_structures.linkedlist;

public class DoublyLinkedList {

    private Node head;

    private class Node{
        int val;
        Node next;
        Node prev;

        public Node(int val){
            this.val = val;
        }

        Node(int val, Node next, Node prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val + '}';
        }
    }

    public void insertFirst(int val){
        Node node = new Node(val);
        node.next = head;
        node.prev = null;
        if(head != null) head.prev = node;   //this is because head may be null;

        head = node;
    }

    //    insert at tail
    public void insertLast(int val) {
        Node node = new Node(val);
        Node last = head;
        node.next = null;    //irrespective of if there are elements in the list or not node's next will always be null;

        if(head == null){ //edge case if head was null (ie we had no value in the list)
            node.prev = null;
            head = node;
            return;
        }

        while(last.next != null){
            last = last.next;
        }

        last.next = node;
        node.prev = last;
    }


    public void insert(int after, int val) {
        Node p = find(after);

        if(p == null){
            System.out.println("Does not exist");
        }

        Node node = new Node(val);
        node.next = p.next;
        p.next = node;
        node.prev = p;
        if(node.next != null) node.next.prev = node;
    }

    //TODO: WORK ON DELETION
    //TODO: DELETE FIRST
    //TODO: DELETE LAST
    //TODO: DELET AT SPECIFIC INDEX

    public Node find(int val){   //gets the node at any index.
       Node node = head;

        while(node != null){
            if(node.val == val){
                return node;
            }

            node = node.next;
        }

        return null;
    }

    public void display(){
        Node node = head;
        Node lastNode = null;

        while(node != null){
            System.out.print(node.val + " -> ");
            lastNode = node;   //in the end this will point to the last node.
            node = node.next;
        }
        System.out.println("END");


        System.out.println("Printing reverse");
        while(lastNode != null){
            System.out.print(lastNode.val + " -> ");
            lastNode = lastNode.prev;
        }
        System.out.println("START");
    }
}
