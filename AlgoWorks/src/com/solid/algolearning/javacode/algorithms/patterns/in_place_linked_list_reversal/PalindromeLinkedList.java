package com.solid.algolearning.javacode.algorithms.patterns.in_place_linked_list_reversal;

public class PalindromeLinkedList {
    public static void main(String[] args) {

    }

    public boolean isPalindrome(ListNode head) {
        //algorithm:
        //we can cut the linkedList in 2 halves and rotate the right half
        // then use 2 pointers to check if the values at any point are not the same.

        if (head == null || head.next == null) return true;

        // find middle of the LinkedList
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode headSecondHalf = reverse(slow); // reverse the second half
        ListNode copyHeadSecondHalf = headSecondHalf; // store the head of reversed part to revert back later

        // compare the first and the second half
        while (head != null && headSecondHalf != null) {
            if (head.value != headSecondHalf.value) {
                break; // not a palindrome
            }
            head = head.next;
            headSecondHalf = headSecondHalf.next;
        }

        reverse(copyHeadSecondHalf); // revert the reverse of the second half
        if (head == null || headSecondHalf == null) // if both halves match
            return true;

        return false;
    }

    private static ListNode reverse(ListNode head) {
        ListNode prev = null;

        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
