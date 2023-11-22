package com.solid.algolearning.javacode.data_structures.stacks_and_queues;

//Implementing a Stack using LinkedLists.
public class Stack {

    private  Node topNode;
    private  Node bottomNode;
    private  int length;

    public Stack() {
        this.topNode = null;
        this.bottomNode = null;
        this.length = 0;
    }

    public  Node peek(){
        return this.topNode;
    }

    public Stack push(String value){
        Node newNode = new Node(value);

        if (this.length == 0){
            System.out.println("Adding " + newNode.value);
            this.topNode = newNode;
            this.bottomNode = newNode;
        }else{
            System.out.println("Adding " + newNode.value);
            Node previousTop = this.topNode;
            this.topNode = newNode;
            this.topNode.next = previousTop;
        }

        this.length++;
        return this;
    }

    public Stack pop(){
//        If there is nothing in the stack, return null
        if (this.topNode == null){
            return null;
        }

//        If there is only one item in the list
        if (this.topNode == this.bottomNode){
            System.out.println("Removing " + topNode.value);
            this.bottomNode = null;
            this.topNode = null;
            this.length--;
            return null;
        }

        System.out.println("Removing " + topNode.value);
        this.topNode = this.topNode.next;
        this.length--;
        return this;
    }

    public boolean isEmpty(){
        return topNode == null;
    }

    @Override
    public String toString() {
        return "Stack{" +
                "topNode = " + topNode.toString() +
                ", bottomNode = " + bottomNode.toString() +
                ", length = " + length +
                '}';
    }

    public static void main(String[] args) {
        Stack myStack = new Stack();

        System.out.println(myStack.peek());
        System.out.println(myStack.push("Google"));
        System.out.println(myStack.pop());
        System.out.println(myStack.push("Udemy"));
        System.out.println(myStack.push("Discord"));
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.isEmpty());
    }
}
