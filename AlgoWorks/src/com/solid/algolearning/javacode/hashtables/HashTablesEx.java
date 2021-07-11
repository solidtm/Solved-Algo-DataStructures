package com.solid.algolearning.javacode.hashtables;

import java.util.HashSet;
import java.util.Set;

public class HashTablesEx {
    private static int[] data;
    public static void main(String[] args) {
        HashTablesEx hashTablesEx = new HashTablesEx(50);
        System.out.println(hash("Grapes"));
    }

    public HashTablesEx(int size){
        data = new int[size];
    }

//    My hash function implementation
    public static int hash(String key){
        int hash = 0;

        for (int i = 0; i < key.length(); i++){
            hash = (hash + key.charAt(i) * i) % data.length;
        }
        return hash;
    }

//    Implementing hashtable to store key-value pair
    public static void set(String key, Object value){
        int address = hash(key);
//       finish implementation
    }

    public static void gey(String key){
        int address = hash(key);
//       finish implementation
    }

    public static Set<Integer> keys(){
//       finish implementation

        return new HashSet<>();
    }


}
