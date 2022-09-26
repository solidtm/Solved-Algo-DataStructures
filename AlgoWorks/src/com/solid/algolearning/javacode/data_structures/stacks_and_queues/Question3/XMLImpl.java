package com.solid.algolearning.javacode.data_structures.stacks_and_queues.Question3;

/*
*  To implement a validator for open and closing tags, I need a Stack data structure,
*  hence I implemented a stack class using the Queue data structure earlier implemented
*  as shown in the helper class below:
*/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

class Stack{
    /** Defining two Queues to be used to implement the Stack. */
    private final QueueImpl q1;
    private final QueueImpl q2;

    //construct the queues
    public Stack(){
        q1 = new QueueImpl();
        q2 = new QueueImpl();
    }

    //push a value to the stack.
    public void push(String val) {
        q1.enqueue(val);
    }

    //remove a value from the stack.
    public String pop() {
        if(q1.isEmpty() && q2.isEmpty()){  //there is nothing in the stack
            return null;
        }

        while(q1.size() > 1){  //push all values to q2 except the value at front
            q2.enqueue(q1.dequeue());
        }

        String val = q1.dequeue();  //remove val at front

        while (!q2.isEmpty()){  //push back other values to the q1
            q1.enqueue(q2.dequeue());
        }

        return val;
    }

    //return the value at the top of the stack.
    public String top(){
        if (q1.isEmpty()){
            return null;
        }

        while(q1.size() > 1){
            q2.enqueue(q1.dequeue());
        }
        Node top = q1.peek();
        q2.enqueue(q1.dequeue());

        while(q2.size() > 0) {
            q1.enqueue(q2.dequeue());
        }

        return top.value;
    }

    /** Returns whether the stack is empty. */
    public boolean isEmpty() {
        return q1.isEmpty();
    }
}

public class XMLImpl {

    public static void main(String[] args) {
        BufferedReader reader;         //BufferedReader object to read the file line by line
        URL path = XMLImpl.class.getResource("XmlFile.txt");
        File file = new File(path.getFile());

        try {
            reader = new BufferedReader(
                    new FileReader(file));
            String line = reader.readLine();

            while(line != null){
                System.out.println(line + " has valid xml tags: " + hasValidTags(line));
                line = reader.readLine();
            }

            reader.close();
        } catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    private static boolean hasValidTags(String line) {
        Stack myStack = new Stack();   //Stack object to keep track of open and closing braces
        StringBuilder sb = new StringBuilder();

        if(line.isEmpty()) return true;
        if(line.length() == 1) return false;


        for(int i = 0; i < line.length();){
            char ch = line.charAt(i);

            if (ch == '<'){  //build the tag everytime we encounter this character
                sb = new StringBuilder();
                sb.append(ch);
                i++;
            }else if(ch == '>'){  //validate closing tags or push to stack if we encounter this character
                sb.append(ch);
                String s1 = sb.toString();
                String s2 = myStack.pop();

                if (sb.toString().contains("/")){   //we have encountered a closing tag
                    if(myStack.isEmpty() && !(s1.equals(s2))){
                        return false;
                    }
                }else{  //not a closing tag, push equivalent closing tag to stack
                    myStack.push(sb.insert(1, "/").toString());
                }

                i++;
            }else{
               sb.append(ch);
               i++;
            }
        }

        return myStack.isEmpty();
    }
}
