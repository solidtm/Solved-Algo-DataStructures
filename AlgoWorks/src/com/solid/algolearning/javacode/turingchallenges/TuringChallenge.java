package com.solid.algolearning.javacode.turingchallenges;

import java.util.ArrayList;
import java.util.List;

//Turing problem that states:
//Given an array of Strings, return the sum of the scores in the result list wherein
// "C" in the ops means that we should invalidate the previous score in the list by removing it and add the result to the list
// "D" in ops means that we should double the previous score by 2 and add the result to the list
// "+" in ops means that we should add the last two values in the list and add the sum into the list
// a number in ops should just be added into the result list

 public class TuringChallenge {
    private static List<Integer> resultList = new ArrayList<>();


    public static void main(String[] args) {

        String[] ops = {"1"};

        System.out.println(calPoints(ops));
    }

    public static  int calPoints(String[] ops){
        for (String op : ops) {
            if (ops.length <= 1) {
                return 1;
            } else if (op.equals("+")) {
                recordNewSumScore(resultList, resultList.size() - 2, resultList.size() - 1);
            } else if (op.equals("C")) {
                invalidatePreviousScore(resultList, resultList.size() - 1);
            } else if (op.equals("D")) {
                recordNewDoubleScore(resultList, resultList.size() - 1);
            } else {
                recordPoints(resultList, Integer.parseInt(op));
            }
        }

        return getListSum(resultList);
    }

    public static void recordPoints(List<Integer> itemList, int point){
        itemList.add(point);
    }

    public static void recordNewSumScore(List<Integer> itemList, int indexOne, int indexTwo){
        itemList.add(itemList.get(indexOne) + itemList.get(indexTwo));
    }

    public static void recordNewDoubleScore(List<Integer> itemList, int index){
        itemList.add(itemList.get(index) *  2);
    }

    public static void invalidatePreviousScore(List<Integer> itemList, int index){
        itemList.remove(index);
    }

    public static int getListSum(List<Integer> itemList){
        int result = 0;

        for (int item : itemList){
            result += item;
        }
        return result;
    }

}
