package com.solid.algolearning.javacode.algorithms.sorting;

import java.util.ArrayList;
import java.util.Arrays;

//In javascript, sort() method works differently on input type, but in java, natural ordering is used

public class SortIssue {
    public static void main(String[] args) {
        ArrayList<String> letters =  new ArrayList<>();

        letters.add("a");
        letters.add("d");
        letters.add("z");
        letters.add("e");
        letters.add("r");
        letters.add("b");
        letters.add("q");

        System.out.println(Arrays.toString(letters.stream().sorted().toArray()));

        ArrayList<Integer> basket =  new ArrayList<>();

        basket.add(2);
        basket.add(65);
        basket.add(34);
        basket.add(2);
        basket.add(1);
        basket.add(7);
        basket.add(8);

        System.out.println(Arrays.toString(basket.stream().sorted().toArray()));

    }
}
