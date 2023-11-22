package com.solid.algolearning.javacode.algorithms.patterns.fast_slow_pointers;

//Problem 1: Given the head of a LinkedList with a cycle, find the length of the cycle.
//
//        Solution: We can use the above solution to find the cycle in the LinkedList.
//        Once the fast and slow pointers meet, we can save the slow pointer and iterate the whole cycle with another pointer
//        until we see the slow pointer again to find the length of the cycle.
//
//        Here is what our algorithm will look like:
public class LinkedListCycleLength {
    static class ListNode {
        int value;
        LinkedListCycle.ListNode next;

        ListNode(int value) {
            this.value = value;
        }
    }

    public static boolean hasCycle(LinkedListCycle.ListNode head) {
        LinkedListCycle.ListNode slow = head;
        LinkedListCycle.ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) return true; // found the cycle
        }
        return false;
    }


}
