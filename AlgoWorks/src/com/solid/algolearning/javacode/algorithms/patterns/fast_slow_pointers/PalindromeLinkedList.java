package com.solid.algolearning.javacode.algorithms.patterns.fast_slow_pointers;

//Palindrome LinkedList (medium)
//        Given the head of a Singly LinkedList, write a method to check if the LinkedList is a palindrome or not.
//
//        Your algorithm should use constant space and the input LinkedList should be in the original form once the algorithm is
//        finished. The algorithm should have O(N)O(N) time complexity where ‘N’ is the number of nodes in the LinkedList.
//
//        Example 1:
//
//        Input: 2 -> 4 -> 6 -> 4 -> 2 -> null
//        Output: true

//        Example 2:
//
//        Input: 2 -> 4 -> 6 -> 4 -> 2 -> 2 -> null
//        Output: false

//Solution#
//        As we know, a palindrome LinkedList will have nodes values that read the same backward or forward.
//        This means that if we divide the LinkedList into two halves, the node values of the first half in the forward direction
//        should be similar to the node values of the second half in the backward direction. As we have been given a
//        Singly LinkedList, we can’t move in the backward direction. To handle this, we will perform the following steps:
//
//        We can use the Fast & Slow pointers method similar to Middle of the LinkedList to find the middle node of the LinkedList.
//        Once we have the middle of the LinkedList, we will reverse the second half.
//        Then, we will compare the first half with the reversed second half to see if the LinkedList represents a palindrome.
//        Finally, we will reverse the second half of the LinkedList again to revert and bring the LinkedList back to its
//        original form.

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
            if(head.value != secondHead.value){
                break; //it is not a palindrome
            }

            head = head.next;
            secondHead = secondHead.next;
        }

        //after finding out if it's a palindrome, we need to reverse back the list again
        reverse(copyOfSecondHead);
        return head == null || secondHead == null;   //if both values match
    }

    static ListNode reverse(ListNode head){
        ListNode prev = null;

        while (head != null){
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
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(2);
        System.out.println("Is palindrome: " + isPalindrome(head));
        head.next.next.next.next.next = new ListNode(2);
        System.out.println("Is palindrome: " + isPalindrome(head));
    }
}
