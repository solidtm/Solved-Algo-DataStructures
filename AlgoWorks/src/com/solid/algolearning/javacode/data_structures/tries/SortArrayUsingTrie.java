package com.solid.algolearning.javacode.data_structures.tries;

import java.util.*;
//Problem Statement#
//        In this problem, you have to implement the sortArray() function to sort the elements of an array of strings in alphabetical order.
//
//        Function Prototype#
//        ArrayList<String> sortArray(String []arr);
//        Here, arr is a String array
//
//        Output#
//        It returns the given array, sorted and in an ArrayList form.
//
//        Sample Input#
//        String keys[] = {"the", "a", "there", "answer", "any",
//        "by", "bye", "their","abc"};
//        Sample Output#
//        {"a", "abc", "answer", "any", "by", "bye", "the", "their", "there"}
public class SortArrayUsingTrie {
    //Recursive Function to generate all words in alphabetic order
    public static void getWords(TrieNode root, ArrayList < String > result, int level, char[] str) {
        //Leaf denotes end of a word
        if (root.isEndWord) {
            //current word is stored till the 'level' in the character array
            String temp = "";
            for (int x = 0; x < level; x++) {
                temp += Character.toString(str[x]);
            }
            result.add(temp);
        }

        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                //Non-null child, so add that index to the character array
                str[level] = (char)(i + 'a');
                getWords(root.children[i], result, level + 1, str);
            }
        }
    }

    public static ArrayList<String> sortArray(String[] arr){
        ArrayList<String> result = new ArrayList<String>();

        //Creating Trie and Inserting words from array
        Trie trie = new Trie();
        for (int x = 0; x < arr.length ; x++)
            trie.insert(arr[x]);

        char[] char_arr = new char[20];
        getWords(trie.getRoot(),result,0,char_arr);
        return result;
    }

    public static void main(String args[]) {
        // Input keys (use only 'a' through 'z' and lower case)
        String keys[] = {"the", "a", "there", "answer", "any",
                "by", "bye", "their","abc"};

        Trie t = new Trie();

        System.out.println("Keys: "+ Arrays.toString(keys));

        // Construct trie

        for (int i = 0; i < keys.length ; i++)
            t.insert(keys[i]);


        ArrayList < String > list = sortArray(keys);
        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
