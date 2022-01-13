package com.solid.algolearning.javacode.algorithms.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {
    public static void main(String[] args) {
        List<Integer> array = Arrays.asList(20, 35, -15, 7, 55, 1, -22);
        mergeSort(array);

        System.out.println(Arrays.toString(array.toArray()));
    }

    public static List<Integer> mergeSort(List<Integer> input){
        if(input.size() < 2){
            return input;
        }

        int mid = input.size() / 2;

        List<Integer> left = input.subList(0, mid);
        List<Integer> right = input.subList(mid, input.size());

        return merge(mergeSort(left), mergeSort(right));
    }

    public static List<Integer> merge(List<Integer> left, List<Integer> right){
        int leftIndex = 0;
        int rightIndex = 0;
        int size = left.size() + right.size();
        List<Integer> tempList = new ArrayList<>(size);

        while(leftIndex < left.size() && rightIndex < right.size()){
            if(left.get(leftIndex) <= right.get(rightIndex)){
                tempList.add(left.get(leftIndex));
                leftIndex++;
            }else{
                tempList.add(right.get(rightIndex));
                rightIndex++;
            }

            while(leftIndex < left.size()){
                tempList.add(left.get(leftIndex));
                leftIndex++;
            }

            while(rightIndex < right.size()){
                tempList.add(right.get(rightIndex));
                rightIndex++;
            }
        }

        return tempList;
    }
}
