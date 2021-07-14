package com.solid.algolearning.javacode.stacksandqueues;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ImplStackUsingQueueProblem {
//    One of the most common interview question is the implement a stack using queue problem:
//    Implement the following operations of a Stack using Stacks
//    push(x) --> push element x to the top of the stack
//    pop() --> Removes the element from top of stack
//    peek() --> Get the top element
//    empty() --> Return whether the stack is empty or not.

//    Solution:


    /** Initialize your data structure here. */
    private Queue<Integer> q1;
    private Queue<Integer> q2;
    private int first;

    public ImplStackUsingQueueProblem() {
        q1 = new LinkedList<>();   //first queue
        q2 = new LinkedList<>(); //second queue
    }


    private void swapQ(){
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    /** Push element x to the back of queue. ie unto stack in this case*/
    public void push(int x) {
        q1.add(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(q1.isEmpty() && q2.isEmpty()){
//            System.out.println("q1 or q2 may be empty: " + q1.isEmpty());
            return 0;
        }
        while(q1.size() > 1){
//            System.out.println("Adding " + q1.poll() + " to q2");
            q2.add(q1.poll()); //q1 = []; q2 = [1, 2, 3]
        }

        Integer x = q1.poll();
        while (!q2.isEmpty()){
//            System.out.println("Adding " + q2.poll() + " to q1");
            q1.add(q2.poll());
        }
//        System.out.println(Arrays.toString(q1.toArray()));
//        System.out.println(Arrays.toString(q2.toArray()));
        return x;
    }

    /** Get the top element */
    public int top(){
        while(q1.size() > 1){
            q2.add(q1.poll());
        }
        Integer x = q1.peek();
        System.out.println("x = " + x);
        q2.add(q1.poll());
        while(q2.size() > 0) {
            q1.add(q2.poll());
        }

        return x;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty();
    }

    public static void main(String[] args) {
        ImplStackUsingQueueProblem myStack = new ImplStackUsingQueueProblem();

        System.out.println(myStack.pop());
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        System.out.println(myStack.pop());
        System.out.println("=================");
        System.out.println(myStack.top());
//        System.out.println(myStack.top());
        System.out.println("=================");
        System.out.println(myStack.empty());


    }

}

