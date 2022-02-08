package com.solid.algolearning.javacode.algorithms.patterns.in_place_linked_list_reversal;
//Problem: Reverse the first ‘k’ elements of a given LinkedList.
//
//        Solution: This problem can be easily converted to our parent problem; to reverse the first ‘k’ nodes of the list, we need to pass p=1 and q=k.

public class ReverseFirstKElements {
   static ListNode reverseFirstKElem(ListNode head, int k){
       int p = 1;
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
       while(!(curr.value > k)){
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

        ListNode result = reverseFirstKElem(head, 3);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}
