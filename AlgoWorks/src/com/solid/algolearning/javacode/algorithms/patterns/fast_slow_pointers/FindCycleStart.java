package com.solid.algolearning.javacode.algorithms.patterns.fast_slow_pointers;

public class FindCycleStart {

    static class ListNode {
        int value;
        ListNode next;

        ListNode(int value) {
            this.value = value;
        }
    }

    //faster and more concise approach
    public static ListNode findCycleStart(ListNode head) { // 3->2->0->-4->  fast = -4, slow = -4, temp = 3;
        ListNode fast = head;
        ListNode slow = head;
        ListNode temp = head;

        if(head == null) return null;
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if(slow == fast) {
                while(temp != slow) {
                    temp = temp.next;
                    slow = slow.next;
                }
                return temp;
            }
        }
        return null;
    }
//    public static ListNode findCycleStart(ListNode head) {
//        int cycleLength = 0;
//        // find the LinkedList cycle
//        ListNode slow = head;
//        ListNode fast = head;
//        while (fast != null && fast.next != null) {
//            fast = fast.next.next;
//            slow = slow.next;
//            if (slow == fast) { // found the cycle
//                cycleLength = calculateCycleLength(slow);
//                break;
//            }
//        }
//
//        return findStart(head, cycleLength);
//    }
//
//    private static int calculateCycleLength(ListNode slow) {
//        ListNode current = slow;
//        int cycleLength = 0;
//        do {
//            current = current.next;
//            cycleLength++;
//        } while (current != slow);
//
//        return cycleLength;
//    }
//
//    private static ListNode findStart(ListNode head, int cycleLength) {
//        ListNode pointer1 = head, pointer2 = head;
//        // move pointer2 ahead 'cycleLength' nodes
//        while (cycleLength > 0) {
//            pointer2 = pointer2.next;
//            cycleLength--;
//        }
//
//        // increment both pointers until they meet at the start of the cycle
//        while (pointer1 != pointer2) {
//            pointer1 = pointer1.next;
//            pointer2 = pointer2.next;
//        }
//
//        return pointer1;
//    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        head.next.next.next.next.next.next = head.next.next;
        System.out.println("LinkedList cycle start: " + findCycleStart(head).value);

        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println("LinkedList cycle start: " + findCycleStart(head).value);

        head.next.next.next.next.next.next = head;
        System.out.println("LinkedList cycle start: " + findCycleStart(head).value);
    }
}
