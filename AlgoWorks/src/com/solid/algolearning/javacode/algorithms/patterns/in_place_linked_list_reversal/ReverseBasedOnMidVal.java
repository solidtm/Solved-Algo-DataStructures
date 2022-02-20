package com.solid.algolearning.javacode.algorithms.patterns.in_place_linked_list_reversal;

//Problem 2: Given a LinkedList with ‘n’ nodes, reverse it based on its size in the following way:
//
//        If ‘n’ is even, reverse the list in a group of n/2 nodes.
//        If n is odd, keep the middle node as it is, reverse the first ‘n/2’ nodes and reverse the last ‘n/2’ nodes.
//        Solution: When ‘n’ is even we can perform the following steps:
//
//        Reverse first ‘n/2’ nodes: head = reverse(head, 1, n/2)
//        Reverse last ‘n/2’ nodes: head = reverse(head, n/2 + 1, n)
//        When ‘n’ is odd, our algorithm will look like:
//
//        head = reverse(head, 1, n/2)
//        head = reverse(head, n/2 + 2, n)
//        Please note the function call in the second step. We’re skipping two elements as we will be skipping the middle element.


public class ReverseBasedOnMidVal {

    static ListNode reverseOnMid(ListNode head){
        if(head == null || head.next == null) return null;

        int size = 0;
        while(head != null){
            size += 1;
            head = head.next;
        }
        System.out.println(size);

        ListNode next;
        if(size % 2 == 0){ //even
            head = reverse(head, 1, size / 2);
            next = reverse(head , size / 2 + 1, size);

            ListNode curr = head;
            while (curr != null){
                if(curr == null) curr.next = next;
                else  curr = curr.next;
            }
        }else{ //odd
            head = reverse(head, 1, size / 2);
            next = reverse(head , size / 2 + 2, size);

            ListNode curr = head;
            while (curr != null){
                if(curr == null) curr.next = next;
                else  curr = curr.next;
            }
        }

        return head;
    }


    static ListNode reverse(ListNode head, int i, int j){
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;

        while(!(curr.value > j)){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode result = reverseOnMid(head);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}
