package com.solid.algolearning.javacode.data_structures.linkedlist;

public class MergeNodesBtwZeros {
    public static void main(String[] args) {

        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(0);
        head.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next.next = new ListNode(0);

        ListNode result = mergeNodes(head);
        System.out.print("Nodes of the processed LinkedList are: ");
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }

    public static ListNode mergeNodes(ListNode head) {
        ListNode dummy = new ListNode();
        ListNode result = dummy;
        int res = 0;

        ListNode curr = head.next;
        while(curr != null){
            if(curr.val == 0){
                ListNode node = new ListNode(res);
                dummy.next = node;
               dummy = dummy.next;
               res = 0;
            }else{
                res += curr.val;
            }

            curr = curr.next;
        }

        return result.next;
    }
}
