package com.solid.algolearning.javacode.data_structures.stacks_and_queues;

import java.util.ArrayList;

public class StackUsingArrayList {
    private final ArrayList<String> array;

    public StackUsingArrayList() {
        this.array = new ArrayList<>();
    }

    public  String peek(){
        if (array.size() == 0){
            return null;
        }

        return this.array.get(array.size() - 1);
    }

    public StackUsingArrayList push(String value){
        this.array.add(value);
        return this;
    }

    public StackUsingArrayList pop(){
//      If there is nothing in the stack, return null
        if (this.array.isEmpty()){
            return null;
        }
        array.remove(array.size() - 1);
        return this;
    }

    public boolean isEmpty(){
        return array.isEmpty();
    }

    @Override
    public String toString() {
        return "Stack {" +
                "array =" + array +
                '}';
    }

    public static void main(String[] args) {
        StackUsingArrayList myStack = new StackUsingArrayList();

        System.out.println(myStack.peek());
        System.out.println(myStack.push("Google"));
        System.out.println(myStack.push("Udemy"));
        System.out.println(myStack.push("Discord"));
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.peek());
        System.out.println(myStack.pop());
        System.out.println(myStack.isEmpty());
    }
}
