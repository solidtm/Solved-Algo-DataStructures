package com.solid.algolearning.javacode.data_structures.stacks_and_queues.Question3;

public class QueueImpl implements Queue<Node> {  //extend the interface to implement the functions

    private Node first;    //field to hold the first item in the Queue
    private Node last;    //field to hold the last item in the Queue
    private int length;   //length of the Queue

    public QueueImpl() { //construct the queue
        this.first = null;
        this.last = null;
        this.length = 0;
    }


/*
   peek() returns the value at the front of the Queue
   If there is no value at the front we return null.
*/
    @Override
    public Node peek() {
        if (this.first == null){
            return null;
        }
        return this.first;
    }


/*
   enqueue() adds a value to the Queue
   If there is no value at the front of the Queue, we add that value as both first and last node
   else, we add the value as the last node and increase the length.
*/
    @Override
    public void enqueue(String value) {
        Node newNode = new Node(value);

        if (this.length == 0){
            this.first = newNode;
        }else{
            this.last.next = newNode;
        }
        this.last = newNode;
        this.length++;
    }


/*
   dequeue() removes a value from the Queue
   If there is no value at the front of the Queue, we return null
   If there is only one item in the list, we remove the value, decrease the length and return null
   Lastly, if there is more values, just remove the value at the front and set the first value to the next node in the Queue
   Also decrease the length of the Queue.
*/
    @Override
    public String dequeue() {
        String removedVal;

        if (this.first == null){ //nothing in the list
            return null;
        }

        removedVal = this.first.value;

        if (this.first == this.last){ //only one item in the list
            this.last = null;
            this.first = null;
            this.length--;
            return removedVal;
        }

        this.first = this.first.next;
        this.length--;

        return removedVal;
    }


/*
   toString() prints the entire Queue with all it's values.
*/
    @Override
    public String toString() {
        Node curr = first;
        StringBuilder queue = new StringBuilder();
        queue.append("Queue{");

        while (curr != null){
            queue.append(curr.value).append(",");
            curr = curr.next;
        }
        queue.deleteCharAt(queue.length() - 1);
        queue.append("}");

        return queue.toString();
    }

/*
   isEmpty(): Helper function to check if the Queue is empty
   size(): Helper funtion to return the size of the Queue
*/
    public boolean isEmpty(){
        return last == null;
    }

    public int size(){return length;}
}
