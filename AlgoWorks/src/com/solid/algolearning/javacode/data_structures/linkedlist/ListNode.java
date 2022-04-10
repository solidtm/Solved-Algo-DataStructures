package com.solid.algolearning.javacode.data_structures.linkedlist;

public class ListNode {
    public int val = 0;
    public ListNode next;

    public ListNode(){}
    public ListNode(int value) {
        this.val = value;
    }
    public ListNode(int value, ListNode node) {
        this.val = value;
        this.next = node;
    }
}
