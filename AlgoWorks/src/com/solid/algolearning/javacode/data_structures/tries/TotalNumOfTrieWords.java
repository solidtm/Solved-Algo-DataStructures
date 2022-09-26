package com.solid.algolearning.javacode.data_structures.tries;

//Problem Statement#
//        Implement the totalWords(TrieNode root) function to find the total number of words in a Trie.
//
//        Function Prototype#
//        int totalWords(TrieNode root);
//        Here, root is the root node of the Trie.
//
//        Output#
//        It returns the total number of words in the Trie
//
//        Sample Input#
//        String keys[] = {"the", "a", "there", "answer", "any",
//        "by", "bye", "their","abc"};
//        Sample Output#
//        9


import java.util.Arrays;

public class TotalNumOfTrieWords {
    public static int totalWords(TrieNode root){
        int result = 0;

        // Leaf denotes end of a word
        if (root.isEndWord)
            result++;

        for (int i = 0; i < 26; i++)
            if (root.children[i] != null)
                result += totalWords(root.children[i]);
        return result;
    }


    public static void main(String args[]){
        // Input keys (use only 'a' through 'z' and lower case)
        String keys[] = {"the", "a", "there", "answer", "any",
                "by", "bye", "their","abc"};

        System.out.println("Keys: "+ Arrays.toString(keys));

        // Construct trie
        Trie t = new Trie();

        for (String key : keys) t.insert(key);

        System.out.println(totalWords(t.getRoot()));
    }
}
