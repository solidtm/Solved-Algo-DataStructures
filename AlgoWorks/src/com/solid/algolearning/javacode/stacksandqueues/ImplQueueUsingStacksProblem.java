package com.solid.algolearning.javacode.stacksandqueues;

import java.util.Stack;

public class ImplQueueUsingStacksProblem {
//    One of the most common interview question is the implement a queue using stack problem:
//    Implement the following operations of a Queue using Stacks
//    push(x) --> push element x to the back of the queue
//    pop() --> Removes the element from in front of queue
//    peek() --> Get the front element
//    empty() --> Return whether the queue is empty or not.

//    Solution:


    /** Initialize your data structure here. */
    private Stack<Integer> s1;
    private Stack<Integer> s2;

    public ImplQueueUsingStacksProblem() {
        s1 = new Stack<>();   //first stack
        s2 = new Stack<>(); //second stack
    }

    /** Push element x to the back of queue. */
    public void push(int x) { //s1 = [1] push = 2; s2 = [1, 2]; new s1 = [2, 1]
        //check if s1 is empty  q1 = [1, 2] push = 3; q2 = [1, 2, 3]; new q1 = [1, 2, 3]
        while(!s1.isEmpty()){
            s2.push(s1.peek()); //take top value of stack s1 and  put in s2
            s1.pop();       //remove top item of stack s1
        }
        s2.push(x);         //put x in the stack top

        while(!s2.isEmpty()){
            s1.push(s2.peek()); //transfer all the values of s2 to s1 to have the first element back on top representing a queue
            s2.pop();
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return s1.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (s1.isEmpty()){
            return 0;
        }
        return s1.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.isEmpty();
    }

    public static void main(String[] args) {
        ImplQueueUsingStacksProblem myQueue = new ImplQueueUsingStacksProblem();

        System.out.println(myQueue.peek());
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        System.out.println(myQueue.peek());
        System.out.println("=================");
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println("=================");
        System.out.println(myQueue.empty());


    }

}

