package com.solid.algolearning.javacode.algorithms.codility;

import java.util.*;
public class StoneWall {
    public static void main(String[] args) {

    }


    public int solution(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int blockCount = 0;

        for (int height : heights) {
            //if we see a height, we look in the stack
            //if the value in the stack is the same, we aren't going to do anything
            //while what is on the stack is higher, we are going to remove it
            //but if it is not same we will add the block to the stack

            while (!stack.isEmpty() && stack.peek() > height){
                stack.pop();
            }

            if (!stack.isEmpty() && stack.peek() == height){

            }else{
                stack.push(height);
                blockCount++;
            }
        }

        return blockCount;
    }
}
