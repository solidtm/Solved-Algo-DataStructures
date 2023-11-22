package com.solid.algolearning.javacode.data_structures.linkedlist;

import java.util.List;

public class LinkedList {

    private ListNode head;
    private ListNode tail;
    private int size;
    //    *
//     * Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public int size(){
        return size;
    }


//    insert at tail
    public void insertFirst(int val) {
        ListNode node = new ListNode(val);
        node.next = head;
        head = node;

        if(tail == null){
            tail = head;
        }
        size++;
    }


//    insert at tail
    public void insertLast(int val) {
        if(tail == null){
            insertFirst(val);
            return;
        }

        ListNode node = new ListNode(val);
        tail.next = node;
        tail = node;
        size++;
    }


    //insert at particular index
    public void insert(int val, int index) {
        if(index == 0){
            insertFirst(val);
            return;
        }if(index == size){
           insertLast(val);
           return;
        }

        ListNode temp = head;
        for (int i = 1; i < index && temp != null; i++) {
            temp = temp.next;
        }

        assert temp != null;
        ListNode node = new ListNode(val, temp.next);
        temp.next = node;
        size++;
    }

    public void insertRecursive(int val, int index){
        head = insertRec(val, index, head);
    }

    private ListNode insertRec(int val, int index, ListNode node){
        if(index == 0){
            ListNode temp = new ListNode(val, node);
            size++;
            return temp;
        }

        node.next = insertRec(val, index - 1, node.next);
        return node;
    }
    public int deleteFirst(){
        int val = head.val;
        head = head.next;

        if(head == null){
            tail = null;
        }
        size--;

        return val;
    }

    public int deleteLast(){
        if(size <= 1) return deleteFirst();

        ListNode secondLast = get(size - 2);   //node points to the second last item in the ist
        int val = tail.val;
        tail = secondLast;
        tail.next = null;

        return val;
    }

    public int delete(int index){
        if(index == 1) return deleteFirst();
        if(index == size - 1) return deleteLast();

        ListNode previous = get(index - 1);   //node points to the previous index before the index in the ist
        int val = previous.next.val;
        previous.next = previous.next.next;

        return val;
    }
    public ListNode get(int index){   //gets the node at any index.
       ListNode node = head;

        for (int i = 0; i < index; i++) {
            node = node.next;
        }

        return node;
    }


    public ListNode find(int val){   //gets the node at any index.
        ListNode node = head;

        while(node != null){
            if(node.val == val){
                return node;
            }

            node = node.next;
        }

        return null;
    }

//   display the linkedList
    public void display(){
        ListNode temp = head;

        while(temp != null){
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }
}
