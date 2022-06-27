package com.solid.algolearning.javacode.data_structures.linkedlist;

public class SinglyLinkedList<T> {

    //Node inner class for SLL
    public class Node{
        public T data;
        public Node nextNode;
    }

    public Node headNode;      //head node of the linked list
    public int size;           //size of the linked list

    public SinglyLinkedList(){ //Constructor - initializes headNode and size
        headNode = null;
        size = 0;
    }

    //Helper Function that checks if List is empty or not
    public boolean isEmpty(){
        return headNode == null;
    }

    // Helper Function to printList
    public void printList() {
        if (isEmpty()) {
            System.out.println("List is Empty!");
            return;
        }

        Node temp = headNode;
        System.out.print("List : ");
        while (temp.nextNode != null) {
            System.out.print(temp.data.toString() + " -> ");
            temp = temp.nextNode;
        }
        System.out.println(temp.data.toString() + " -> null");
    }

    public void insertAtHead(T data){
       Node newNode = new Node();
       newNode.data = data;

       newNode.nextNode = headNode;
       headNode = newNode;
       size++;
    }

    public void insertAtTail(T data){
        Node newNode = new Node();
        newNode.data = data;

        if(isEmpty()){
            insertAtHead(data);
            return;
        }

        Node currNode = headNode;
        while(currNode.nextNode != null){
            currNode = currNode.nextNode;
        }

        currNode.nextNode = newNode;
    }

    public boolean searchNode(T data) {
        if(isEmpty()){
            return false;
        }

        Node currNode = headNode;
        while(currNode != null){
            if(currNode.data == data){
                return true;
            }
            currNode = currNode.nextNode;
        }

        return false;
    }

    //Deletes data from the head of list
    public void deleteAtHead() {
        //if list is empty then simply return
        if (isEmpty())
            return;
        //make the nextNode of the headNode equal to new headNode
        headNode = headNode.nextNode;
        size--;
    }

    public void deleteByValue(T data) {
        if(isEmpty()){
            return;
        }

        Node currNode = headNode;
        Node prevNode = null;


        if(currNode.data.equals(data)) {
            //data is at head so delete from head
            deleteAtHead();
            return;
        }

        while(currNode != null){
            if(currNode.data == data){
                prevNode.nextNode = currNode.nextNode;
                size--;
                return;
            }

            prevNode = currNode;
            currNode = currNode.nextNode;
        }
    }
}
