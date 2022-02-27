package com.solid.algolearning.javacode.data_structures.strings;

public class Comparison {
    public static void main(String[] args) {
        String name = "Richard";
        String name2 = name;

        name2 = "beef";

        String name1 = new String("beef");
        String name3 = new String("beef");
        name1 = name3;
        name3 = "Escapade";


        System.out.println(name1 == name3);
    }
}
