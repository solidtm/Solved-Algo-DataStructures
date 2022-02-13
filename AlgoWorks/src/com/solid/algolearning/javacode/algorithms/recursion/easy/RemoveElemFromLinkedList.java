package com.solid.algolearning.javacode.algorithms.recursion.easy;

import com.solid.algolearning.javacode.algorithms.patterns.in_place_linked_list_reversal.ListNode;

public class RemoveElemFromLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(3);

        ListNode result = removeElements(head, 3);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }

    public static ListNode removeElements(ListNode head, int val) {
        if(head == null)
            return head;
        ListNode ans = removeElements(head.next,val);
        if(head.value == val)
            return ans;
        else{
            head.next = ans;
            return head;
        }
    }
}
