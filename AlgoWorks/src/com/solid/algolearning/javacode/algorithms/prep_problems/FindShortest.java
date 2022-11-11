package com.solid.algolearning.javacode.algorithms.prep_problems;

import java.util.*;
public class FindShortest {
    public static int findShorDist(String[] wordDict, String word1, String word2){
        Set<String> set = new HashSet<>();

        Collections.addAll(set, wordDict);

        if(!set.contains(word1) || !set.contains(word2)) return 0;
        if(word1.equals(word2) && set.contains(word1)) return 0;

        int i;
        int res = 0;

        for(i = 0; i < wordDict.length;){
            String currWord = wordDict[i];
            if(currWord.equals(word1) || currWord.equals(word2)){
                if(currWord.equals(word1)){ //we are looking for word2
                    res = findShortDistSingle(wordDict, i, word2);
                }else { //we are looking for word1
                    res = findShortDistSingle(wordDict, i, word1);
                }

                break;
            }else i++;
        }

        return res;
    }

    public static int findShortDistSingle(String[] wordDict, int idx, String wordToFind){
        int j = idx + 1;
        int shortestDist = Integer.MAX_VALUE;

        while(j < wordDict.length){
            String currWord = wordDict[j];

            if(currWord.equals(wordToFind)){
                shortestDist = Math.min(shortestDist, j-idx);
            }

            j++;
        }

        return shortestDist;
    }

    public static int findShortDistDuplicate(String[] wordDict, int idx, String wordToFind){
        int j = idx + 1;
        int shortestDist = Integer.MAX_VALUE;

        while(j < wordDict.length){
            String currWord = wordDict[j];

            if(currWord.equals(wordToFind)){
                shortestDist = Math.min(shortestDist, j-idx);
            }

            j++;
        }

        return shortestDist;
    }

    public static void main(String[] args) {
        String[] wordsDict = {"practice", "makes", "perfect", "coding", "practice"};
        String word1 = "coding";
        String word2 = "practice";

        System.out.println(findShorDist(wordsDict, word1, word2));
    }
}
