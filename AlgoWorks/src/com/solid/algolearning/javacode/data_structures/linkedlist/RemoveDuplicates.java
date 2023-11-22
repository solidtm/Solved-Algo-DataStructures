package com.solid.algolearning.javacode.data_structures.linkedlist;
//leetcode problem 83
public class RemoveDuplicates {
    public static void main(String[] args) {

    }

    public ListNode deleteDuplicates(ListNode head) {
        //always remember your edge cases
        if(head == null || head.next == null) return head;

        ListNode node = head;

        while(node.next != null){
            if(node.val == node.next.val){
                node.next = node.next.next;
            }else{
                node = node.next;
            }
        }

        return head;
    }

    //function to detect if there is a cycle in the list
    public static boolean detectCycle(ListNode head) { // 3->2->0->-4->  fast = -4, slow = -4, temp = 3;
        ListNode fast = head;
        ListNode slow = head;

        if(head == null) return false;

        while(fast != null && fast.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast) {
                return true;
            }
        }
        return false;
    }

    //function to find start of the cycle
    public static ListNode detectCycleStart(ListNode head) { // 3->2->0->-4->  fast = -4, slow = -4, temp = 3;
        ListNode fast = head;
        ListNode slow = head;
        ListNode temp = head;
        if(head == null)
            return null;
        while(fast.next != null && fast.next.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast)
            {
                while(temp != slow)
                {
                    temp=temp.next;
                    slow=slow.next;
                }
                return temp;
            }
        }
        return null;
    }

    //function to calculate the length of the cycle in the list
    public static int calcCycleLength(ListNode head) { // 3->2->0->-4->  fast = -4, slow = -4, temp = 3;
        ListNode fast = head;
        ListNode slow = head;
        ListNode temp = head;
        int length = 0;

        if(head == null) return 0;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast) {
                while(temp != slow) {
                    length++;
                    temp = temp.next;
                    slow = slow.next;
                }
                return length;
            }
        }

        return 0;
    }
}
