package com.solid.algolearning.javacode.algorithms.recursion.permutations;

import java.util.ArrayList;

// Given a dice, find all the possible combinations that will sum up to 4
//
// Solution:
//         What are the numbers in a dice first: they are -> [1, 2, 3, 4, 5, 6]
//         All possible combinations that can yield the number 4 are: [4, [2,2], [1, 1, 2], [3, 1]]
//         This follows the combinatoricss principle explained before, where we take one element and leave the other.

// Follow up: given a 9 faced die, instead of a 6 faced die
public class DiceThrow {
    public static void main(String[] args) {
//        diceCombinations("", 4);
        System.out.println(diceFaceCombinationsReturn("", 4, 6));
//        diceFaceCombinations("", 6, 9);

    }


    static void diceCombinations(String p, int target){
        if(target == 0){
            System.out.println(p);
            return;
        }

        for(int i = 1; i <= target; i++){
            diceCombinations(p + i, target - i);
        }
    }

    static ArrayList<String> diceCombinationsReturn(String p, int target){
        if(target == 0){
            ArrayList<String> list= new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList<String> ans = new ArrayList<>();
        for(int i = 1; i <= target; i++){
            ans.addAll(diceCombinationsReturn(p + i, target - i));
        }

        return ans;
    }


    static void diceFaceCombinations(String p, int target, int numOfFaces){
        if(target == 0){
            System.out.println(p);
            return;
        }

        for(int i = 1; i <= numOfFaces && i <= target; i++){
            diceFaceCombinations(p + i, target - i, numOfFaces);
        }
    }

    static ArrayList<String> diceFaceCombinationsReturn(String p, int target, int faces){
        if(target == 0){
            ArrayList<String> list= new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList<String> ans = new ArrayList<>();
        for(int i = 1; i <= faces && i <= target; i++){
            ans.addAll(diceFaceCombinationsReturn(p + i, target - i, faces));
        }

        return ans;
    }
}
