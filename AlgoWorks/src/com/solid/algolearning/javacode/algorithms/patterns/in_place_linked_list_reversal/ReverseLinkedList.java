package com.solid.algolearning.javacode.algorithms.patterns.in_place_linked_list_reversal;

public class ReverseLinkedList {

    static class ListNode {
        int value;
        ListNode next;

        ListNode(int value) {
            this.value = value;
        }
    }

    public static ListNode reverse(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }

        ListNode curr = head;
        while (curr.next != null){
            ListNode temp = head;
            head = curr.next;
            curr.next = head.next;
            head.next = temp;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(8);
        head.next.next.next.next = new ListNode(10);

        ListNode result = reverse(head);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}
