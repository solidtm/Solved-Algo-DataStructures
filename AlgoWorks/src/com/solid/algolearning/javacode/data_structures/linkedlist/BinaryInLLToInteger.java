package com.solid.algolearning.javacode.data_structures.linkedlist;

public class BinaryInLLToInteger {
    public static void main(String[] args) {
        //
        ListNode head = new ListNode();
    }

    public int getDecimalValue(ListNode head) {
        int baseTwoNum = 0;
        int result = 0;
        int index = 0;
        if(head.next == null) return head.val;

        while(head != null){
            baseTwoNum += head.val;
            baseTwoNum *= 10;
            head = head.next;
        }

        baseTwoNum /= 10;


        while(baseTwoNum != 0){
            int digit = baseTwoNum % 10;
            result += (digit * Math.pow(2, index));
            baseTwoNum /= 10;
            index++;
        }

        return result;
    }
}
