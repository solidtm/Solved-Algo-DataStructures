package com.solid.algolearning.javacode.algorithms.cmd;

import com.solid.algolearning.javacode.algorithms.patterns.in_place_linked_list_reversal.ListNode;

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(4);

//        ListNode head3 = null;
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(3);
        head2.next.next = new ListNode(4);

        ListNode result = mergeTwoLists(head1, head2);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }


//     * Definition for singly-linked list.
      public static class ListNode {
         int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }



    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //if both are empty return null
        //if one of them is empty, return the other.

        //have a pointer to the head of list1,
        //recursively loop through list1. and list 2 and check which
        // value is lesser


        if(list1 == null && list2 == null){
            return null;
        }

        if(list1 == null || list2 == null){
            if(list1 == null)return list2;
            else return list1;
        }


        ListNode curr1 = list1;
        ListNode head = null;


        while(curr1.next != null && list2.next != null){
            ListNode next1 = curr1.next;
            ListNode next2 = list2.next;
//            if(curr1.val < list2.val && next1.val < next2.val){
//                head = curr1
                curr1.next = list2;
                list2.next = next1;
//            }else{
//                head = list2;
//                list2.next = curr1;
//                curr1.next = next2;
//            }
            curr1 = next1;
            list2 = next2;
        }

        return list1;
    }
}
