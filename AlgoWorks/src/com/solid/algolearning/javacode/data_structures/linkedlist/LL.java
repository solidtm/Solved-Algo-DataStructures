package com.solid.algolearning.javacode.data_structures.linkedlist;

public class LL {
    public static void main(String[] args) {
//        LinkedList list = new LinkedList();
//
//        list.insertFirst(3);
//        list.insertFirst(2);
//        list.insertFirst(8);
//        list.insertFirst(17);
//        list.insertLast(99);
//        list.insert(100, 3);
//        list.display();
//
//        list.deleteFirst();
//        list.deleteLast();
//        list.delete(2);
//
//        System.out.println(list.find(8));
//        list.display();
//        System.out.println(list.size());

//        DoublyLinkedList dlList = new DoublyLinkedList();
//
//        dlList.insertFirst(3);
//        dlList.insertFirst(2);
//        dlList.insertFirst(8);
//        dlList.insertFirst(17);
//        dlList.insertLast(99);
//        dlList.insert(8, 65);
//        dlList.insert(99, 100);
//
//        dlList.display();

        CircularLinkedList circularList = new CircularLinkedList();

        circularList.insert(2);
        circularList.insert(4);
        circularList.insert(6);
        circularList.insert(10);
        circularList.insert(12);

        circularList.delete(12);
        circularList.display();
    }
}
