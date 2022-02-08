package com.solid.algolearning.javacode.algorithms.patterns.in_place_linked_list_reversal;

//Problem Statement#
//        Given the head of a LinkedList and two positions ‘p’ and ‘q’, reverse the LinkedList from position ‘p’ to ‘q’.

class ListNode {
    int value = 0;
    ListNode next;

    ListNode(int value) {
        this.value = value;
    }
}

public class ReverseSubList{
    public static ListNode reverse(ListNode head, int p, int q) {
        // check if head and head.next is null and return null;
        // while the linkedlist still has values, check if the current node value
        // is equal to p if it is, call reverse method to reverse the linkedList
        // while the value of the node during reversal is not 4.

        if(head == null || head.next == null) return null;

        ListNode curr = head;
        ListNode prev = null;

        while(curr.next != null && curr.next.value == p){
            prev = curr;
            curr = curr.next;
        }

        ListNode lastNodeFirstPart = prev; //first part of the list
        ListNode lastNodeSubList = curr;   // last part end of the reversed list will be curr

//        reverse the sublist until we reach q
        ListNode next = null;
        while(!(curr.value > q)){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // connect first part a last part
        if(lastNodeFirstPart != null){
            lastNodeFirstPart.next = prev;
        }else head = prev;

//        connect the  last part
        lastNodeSubList.next = curr;

        return head;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode result = ReverseSubList.reverse(head, 1, 3);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}
