package com.solid.algolearning.javacode.algorithms.patterns.fast_slow_pointers;
//Rearrange a LinkedList (medium)#
//        Given the head of a Singly LinkedList, write a method to modify the LinkedList such that the nodes from the second half of the LinkedList are inserted alternately to the nodes from the first half in reverse order. So if the LinkedList has nodes 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null, your method should return 1 -> 6 -> 2 -> 5 -> 3 -> 4 -> null.
//
//        Your algorithm should not use any extra space and the input LinkedList should be modified in-place.
//
//        Example 1:
//
//        Input: 2 -> 4 -> 6 -> 8 -> 10 -> 12 -> null
//        Output: 2 -> 12 -> 4 -> 10 -> 6 -> 8 -> null
//
//        Example 2:
//
//        Input: 2 -> 4 -> 6 -> 8 -> 10 -> null
//        Output: 2 -> 10 -> 4 -> 8 -> 6 -> null

public class RearrangeLinkedList {

    static  class ListNode {
        int value = 0;
        ListNode next;

        ListNode(int value) {
            this.value = value;
        }
    }


    public static void reorder(ListNode head) {
        if (head == null || head.next == null) return;

        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null){
            slow = head.next;
            fast = fast.next.next;
        }

        ListNode secondHead = reverse(slow);    //reverse the second half
        ListNode firstHead = head;

        //make each node point to the corresponding values for each of the halves
        while(firstHead != null && secondHead != null){
            ListNode temp = firstHead.next;
            firstHead.next = secondHead;
            firstHead = temp;

            temp = secondHead.next;
            secondHead.next = firstHead;
            secondHead = temp;
        }

        // set the next of the last node to 'null'
        if (firstHead != null)
            firstHead.next = null;
    }

    static ListNode reverse(ListNode head){
        ListNode prev = null;

        while(head != null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(8);
        head.next.next.next.next = new ListNode(10);
        head.next.next.next.next.next = new ListNode(12);
        reorder(head);
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
    }
}
