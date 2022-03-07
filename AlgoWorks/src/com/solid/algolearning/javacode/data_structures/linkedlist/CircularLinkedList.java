package com.solid.algolearning.javacode.data_structures.linkedlist;

public class CircularLinkedList {
    private Node head;
    private Node tail;

    private class Node{
        int val;
        Node next;

        public Node(int val){
            this.val = val;
        }

        Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val + '}';
        }
    }

    public void insert(int val){
        Node node = new Node(val);
        if(head == null){
            head = node;
            tail = node;
            return;
        }

        tail.next = node;
        node.next = head;
        tail = node;
    }

    public void delete(int val){
        Node node = head;

        if(node == null) return;

        if(node.val == val){  //if we have only one item in the list
            head = head.next;
            tail.next = head;
            return;
        }

        do{
            Node n = node.next;
            if(n.val == val){
                node.next = n.next;
                break;
            }

            node = node.next;
        }while(node != head);
    }

    public void display(){
        Node node = head;
        if (head != null){
           do{
               System.out.print(node.val + " -> ");
               node = node.next;
           }while(node != head);
        }
        System.out.println("HEAD");
    }
}
