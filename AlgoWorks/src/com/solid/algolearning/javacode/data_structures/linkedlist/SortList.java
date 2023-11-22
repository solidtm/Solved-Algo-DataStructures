package com.solid.algolearning.javacode.data_structures.linkedlist;

public class SortList {
    public static void main(String[] args) {}

    public ListNode sortList(ListNode head) {
        //we will use merge sort.
        //first we have to first find the middle using fast slow pointer and then perform merge sort

        if(head == null || head.next == null) return head;   //sorted

        ListNode mid = findMid(head);    //find the middle
        ListNode left = sortList(head);  //sort the left and right sides
        ListNode right = sortList(mid);

        return mergeTwoLists(left, right);

    }

    public ListNode findMid(ListNode head){
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        return merge(list1, list2);
    }

    public ListNode merge(ListNode node1, ListNode node2){
        ListNode temp = null;

        if(node1 == null || node2 == null){
            if(node1 != null){
                temp = node1;
            }else if(node2 != null){
                temp = node2;
            }
        }else{
            if(node1.val <= node2.val){
                temp = node1;
                node1 = node1.next;
            }else {
                temp = node2;
                node2 = node2.next;
            }

            temp.next = merge(node1, node2);
        }

        return temp;
    }
}
