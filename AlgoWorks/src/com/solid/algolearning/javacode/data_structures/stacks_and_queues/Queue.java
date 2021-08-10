package com.solid.algolearning.javacode.data_structures.stacks_and_queues;

//Implementing a queue using LinkedList
//NB: Queue uses FIFO protocol.
public class Queue {
    private  Node first;
    private  Node last;
    private  int length;

    public Queue() {
        this.first = null;
        this.last = null;
        this.length = 0;
    }

    public Node peek(){
        if (this.first == null){
            return null;
        }
        return this.first;
    }

    public Queue enqueue(String value){
        Node newNode = new Node(value);
        if (this.length == 0){
            System.out.println("Adding " + value);
            this.first = newNode;
            this.last = newNode;
        }else{
            System.out.println("Adding " + value);
            this.last.next = newNode;
            this.last = newNode;
        }
        this.length++;
        return this;
    }

    public Queue dequeue(){
//        if there is nothing in the list
        if (this.first == null){
            return null;
        }

//        If there is only one item in the list
        if (this.first == this.last){
            System.out.println("Removing " + this.first.value);
            this.last = null;
            this.first = null;
            this.length--;
            return null;
        }
        System.out.println("Removing " + this.first.value);
        this.first = this.first.next;
        this.length--;
        return this;
    }

    public boolean isEmpty(){
        return last == null;
    }

    @Override
    public String toString() {
        return "Queue{" +
                "First = " + first.toString() +
                ", Last = " + last.toString() +
                ", length = " + length +
                '}';
    }

    public static void main(String[] args) {
        Queue myQueue = new Queue();

        System.out.println(myQueue.peek());
        System.out.println(myQueue.enqueue("Joy"));
        System.out.println(myQueue.enqueue("Matt"));
        System.out.println(myQueue.enqueue("Pavel"));
        System.out.println(myQueue.enqueue("Samir"));
        System.out.println(myQueue.dequeue());
        System.out.println(myQueue.dequeue());
        System.out.println(myQueue.dequeue());
        System.out.println(myQueue.isEmpty());
    }
}
