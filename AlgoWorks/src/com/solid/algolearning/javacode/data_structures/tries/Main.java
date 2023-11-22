package com.solid.algolearning.javacode.data_structures.tries;

import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        // Input keys (use only 'a' through 'z' and lower case)
        String[] keys = {"a", "app", "ball"};
        String[] output = {"Not present in trie", "Present in trie"};
        Trie t = new Trie();

        System.out.println("Keys: "+ Arrays.toString(keys));

        // Construct trie

        int i;
        for (i = 0; i < keys.length ; i++) t.insert(keys[i]);

        // Search for different keys and delete if found
        if(t.search("a"))
        {
            System.out.println("a --- " + output[1]);
            t.delete("a");
            System.out.println("Deleted key \"a\"");
        }
        else System.out.println("a --- " + output[0]);

        if(t.search("app"))
        {
            System.out.println("app --- " + output[1]);
            t.delete("app");
            System.out.println("Deleted key \"app\"");
        }
        else System.out.println("app --- " + output[0]);

        if(t.search("ball"))
        {
            System.out.println("ball --- " + output[1]);
            t.delete("ball");
            System.out.println("Deleted key \"ball\"");
        }
        else System.out.println("ball --- " + output[0]);

        // check if the string has deleted correctly or still present
        if(t.search("abc")) System.out.println("abc --- " + output[1]);
        else System.out.println("abc --- " + output[0]);
    }
}
