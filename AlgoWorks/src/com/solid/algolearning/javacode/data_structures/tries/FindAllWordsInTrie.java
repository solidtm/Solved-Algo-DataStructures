package com.solid.algolearning.javacode.data_structures.tries;

import java.util.*;

//Problem Statement#
//        In this problem, you have to implement the findWords() function to return all of the words stored in the Trie in alphabetically sorted order.
//
//        Function Prototype:#
//        ArrayList<String> findWords(TrieNode root);
//        Here, root is the root node of Trie.
//
//        Output:#
//        In the form of an ArrayList, it returns all the words stored in the Trie in lexicographic order.
//
//        Sample Input#
//        String keys[] = {"the", "a", "there", "answer", "any",
//        "by", "bye", "their","abc"};
//        Sample Output#
//        "a", "abc","answer","any","by","bye","the","their","there"

public class FindAllWordsInTrie {

    //Recursive Function to generate all words
    public static void getWords(TrieNode root, ArrayList<String> result, int level, char[] str)
    {
        if(root.isEndWord){
            StringBuilder temp = new StringBuilder();

            for(int i = 0; i < level; i++){
                temp.append(Character.toString(str[i]));
            }

            result.add(temp.toString());
        }

        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                str[level] = (char)(i + 'a');
                getWords(root.children[i], result, level + 1, str);
            }
        }

    }
    public static ArrayList<String> findWords(TrieNode root)
    {
        ArrayList<String> result = new ArrayList<>();
        char[] charArr = new char[20];
        getWords(root, result, 0, charArr);
        return result;
    }
}
