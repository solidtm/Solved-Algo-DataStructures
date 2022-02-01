package com.solid.algolearning.javacode.algorithms.patterns.fast_slow_pointers;

//Palindrome LinkedList (medium)
//        Given the head of a Singly LinkedList, write a method to check if the LinkedList is a palindrome or not.
//
//        Your algorithm should use constant space and the input LinkedList should be in the original form once the algorithm is finished. The algorithm should have O(N)O(N) time complexity where ‘N’ is the number of nodes in the LinkedList.
//
//        Example 1:
//
//        Input: 2 -> 4 -> 6 -> 4 -> 2 -> null
//        Output: true

//        Example 2:
//
//        Input: 2 -> 4 -> 6 -> 4 -> 2 -> 2 -> null
//        Output: false

public class PalindromeLinkedList {

    static class ListNode {
        int value;
        ListNode next;

        ListNode(int value) {
            this.value = value;
        }
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;

        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null){
            slow = head.next;
            fast = fast.next.next;
        }
        //after the loop above, we have gotten the middle of the linkedList,  we want to reverse the other half thus:

        ListNode secondHead = reverse(slow); //reverse the other half
        ListNode copyOfSecondHead = secondHead;

        while(head != null && secondHead != null){
            if(head != secondHead){
                break; //it is not a palindrome
            }

            head = head.next;
            secondHead = secondHead.next;
        }
        //after finding out if it's a palindrome, we need to reverse back the list again
        reverse(copyOfSecondHead);
        if (head == null && secondHead == null) return true;   //if both values match
        return false;
    }

    static ListNode reverse(ListNode head){
        ListNode prev = null;

        while (head != null && head.next != null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }
}
