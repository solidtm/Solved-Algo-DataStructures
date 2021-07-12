package com.solid.algolearning.javacode.linkedlist;

public class LikedListProblems {
//    One of the most common interview questions is to reverse a linkedList
//    Given a LinkedList, how would you go about reversing a linkedList?
//    eg list = [1, 10, 16, 88]
//    reverse the singly linked list to be = [88, 16, 10, 1]

//    Solution approach:
//    Each element in the linked list is a node that has a value and a pointer to the next item in the list
//    We have the head node and the tail node
//    We can traverse through the list, using a while loop or for loop,
//    and for each node from the tail, we set it's pointer to the next item moving backwards and
//    if we get to the end of the least ie index 0, we set it's pointer to null

//    Implementing reverse:
        /**
         * Definition for singly-linked list.
         * public class ListNode {
         *     int val;
         *     ListNode next;
         *     ListNode() {}
         *     ListNode(int val) { this.val = val; }
         *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
         * }
         */

        public static void main(String[] args) {

        }

            public ListNode reverseList(ListNode head) {
//         check if the LinkedList contains one or 0 nodes
                if(head == null || head.next == null){
                    return head;
                }

                ListNode prev = null;
                ListNode current = head;

                while(current != null){
                    ListNode temp = current.next;
                    current.next = prev;
                    prev = current;
                    current = temp;
                }

                return prev;
        }

        static class ListNode{
                int val;
                ListNode next;

            public ListNode(int val) { this.val = val; }
            public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
        }

    public ListNode reverseListWithIndices(ListNode head, int left, int right) {
//         check if the LinkedList contains one or 0 nodes
//        TODO: Implement this to the end
//        TODO: Method not implemented fully
//
        if(head == null || head.next == null){
            return head;
        }

        ListNode prev = null;
        ListNode current = head;

        while(left <= right && current != null){
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;

            left++;
            right--;
        }

        return prev;
    }
   }

