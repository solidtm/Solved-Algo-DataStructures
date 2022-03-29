package com.solid.algolearning.javacode.algorithms.codility;

import java.util.*;
public class Fish {
    public static void main(String[] args) {

    }

    public int solution(int[] fishSizes, int[] directions) {
        int survivals = 0;
        Stack<Integer> stack = new Stack<>();
        //if we see any fishes moving downstream, then we add them to a stack
        for (int i = 0; i < fishSizes.length; i++) {
            int fish  = fishSizes[i];
            int dir = directions[i];

            if (dir == 0){
                boolean survives = true;
                while(!stack.isEmpty()){ //if we have some fishes to the current fish going upstream
                    int oppositeFish = stack.pop();
                    if (oppositeFish > fish) { //fish dies and oppositeFish is put back on the stack
                        stack.push(oppositeFish);
                        survives = false;
                        break;
                    }
                }
                //if we have no oppositeFish to fight against fish, fish survives and is not eaten.
                  if (survives) survivals++;
            }else{
                stack.push(fish);
            }

        }

        survivals += stack.size();

        return survivals;
    }
}
