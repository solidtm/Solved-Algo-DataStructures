package com.solid.algolearning.javacode.algorithms.patterns.top_k_elements;


//Frequency Stack (hard)#
//        Design a class that simulates a Stack data structure, implementing the following two operations:
//
//        push(int num): Pushes the number ‘num’ on the stack.
//        pop(): Returns the most frequent number in the stack. If there is a tie, return the number which was pushed later.
//        Example:
//
//        After following push operations: push(1), push(2), push(3), push(2), push(1), push(2), push(5)
//
//        1. pop() should return 2, as it is the most frequent number
//        2. Next pop() should return 1
//        3. Next pop() should return 2


//Solution#
//        This problem follows the Top ‘K’ Elements pattern, and shares similarities with Top ‘K’ Frequent Numbers.
//
//        We can use a Max Heap to store the numbers.
//        Instead of comparing the numbers we will compare their frequencies so that the root of the
//        heap is always the most frequently occurring number. There are two issues that need to be resolved though:
//
//        How can we keep track of the frequencies of numbers in the heap? When we are pushing a new number to the Max Heap,
//        we don’t know how many times the number has already appeared in the Max Heap.
//        To resolve this, we will maintain a HashMap to store the current frequency of each number.
//        Thus, whenever we push a new number in the heap, we will increment its frequency in the HashMap and when we pop,
//        we will decrement its frequency.
//        If two numbers have the same frequency, we will need to return the number which was pushed later while popping.
//        To resolve this, we need to attach a sequence number to every number to know which number came first.
//        In short, we will keep three things with every number that we push to the heap:
//
//        1. number // value of the number
//        2. frequency // current frequency of the number when it was pushed to the heap
//        3. sequenceNumber // a sequence number, to know what number came first

import java.util.*;
    class Element {
        int number;
        int frequency;
        int sequenceNumber;

        public Element(int number, int frequency, int sequenceNumber) {
            this.number = number;
            this.frequency = frequency;
            this.sequenceNumber = sequenceNumber;
        }
    }

    class ElementComparator implements Comparator<Element> {
        public int compare(Element e1, Element e2) {
            if (e1.frequency != e2.frequency)
                return e2.frequency - e1.frequency;
            // if both elements have same frequency, return the one that was pushed later
            return e2.sequenceNumber - e1.sequenceNumber;
        }
    }

    class FrequencyStack {
        int sequenceNumber = 0;
        PriorityQueue<Element> maxHeap = new PriorityQueue<Element>(new ElementComparator());
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        public void push(int num) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
            maxHeap.offer(new Element(num, frequencyMap.get(num), sequenceNumber++));
        }

        public int pop() {
            int num = maxHeap.poll().number;

            // decrement the frequency or remove if this is the last number
            if (frequencyMap.get(num) > 1)
                frequencyMap.put(num, frequencyMap.get(num) - 1);
            else
                frequencyMap.remove(num);

            return num;
        }

        public static void main(String[] args) {
            FrequencyStack frequencyStack = new FrequencyStack();
            frequencyStack.push(1);
            frequencyStack.push(2);
            frequencyStack.push(3);
            frequencyStack.push(2);
            frequencyStack.push(1);
            frequencyStack.push(2);
            frequencyStack.push(5);
            System.out.println(frequencyStack.pop());
            System.out.println(frequencyStack.pop());
            System.out.println(frequencyStack.pop());
        }
    }
