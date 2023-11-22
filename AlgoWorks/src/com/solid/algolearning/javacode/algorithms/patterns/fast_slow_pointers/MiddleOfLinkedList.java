package com.solid.algolearning.javacode.algorithms.patterns.fast_slow_pointers;

public class MiddleOfLinkedList {
     static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    //My brute force approach gets the length of the linkedList, calculates its middle and then loops to
    // that middle and returns that value
    public static Node findMiddleBruteForce(Node head) {
        Node currentNode = head;

        int middle = findLength(head) % 2 == 0 ? findLength(head) / 2 : findLength(head) / 2 + 1;
        int counter = 0;

        while(currentNode != null && counter != middle){
            currentNode = currentNode.next;
            counter++;
        }

        return currentNode;
    }

    public static int findLength(Node head){
        Node currentNode = head;
        int listLength = 0;

        while(currentNode.next != null){
            currentNode = currentNode.next;
            listLength++;
        }
        return listLength;
    }

    //Using fast_slow pointers we have only one loop thus:
    public static Node findMiddle(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        System.out.println("Middle Node: " + MiddleOfLinkedList.findMiddle(head).value);

        head.next.next.next.next.next = new Node(6);
        System.out.println("Middle Node: " + MiddleOfLinkedList.findMiddle(head).value);

        head.next.next.next.next.next.next = new Node(7);
        System.out.println("Middle Node: " + MiddleOfLinkedList.findMiddle(head).value);
    }
}
