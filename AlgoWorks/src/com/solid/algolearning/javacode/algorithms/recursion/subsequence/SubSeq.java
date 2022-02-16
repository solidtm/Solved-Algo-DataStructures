package com.solid.algolearning.javacode.algorithms.recursion.subsequence;

import java.util.ArrayList;
import java.util.List;

//given a string print all subsequence containing the combination of the letters of the string
public class SubSeq {

    public static void main(String[] args) {
        subSeq("", "abc");
        System.out.println(subSeqList("", "abc"));
        System.out.println(subSeqAscii("", "abc"));
    }

    static void subSeq(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);
        subSeq(p + ch, up.substring(1));  //either take it
        subSeq(p, up.substring(1));          //or ignore it
    }

    static ArrayList<String> subSeqList(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        char ch = up.charAt(0);
       ArrayList<String> left = subSeqList(p + ch, up.substring(1));  //either take it
       ArrayList<String> right = subSeqList(p, up.substring(1));          //or ignore it

        left.addAll(right);
        return left;
    }

    static ArrayList<String> subSeqAscii(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        char ch = up.charAt(0);
        ArrayList<String> left = subSeqAscii(p + ch, up.substring(1));  //either take it
        ArrayList<String> right = subSeqAscii(p, up.substring(1));  //or ignore it
        ArrayList<String> ascii = subSeqAscii(p + (ch + 0), up.substring(1));

        left.addAll(right);
        left.addAll(ascii);
        return left;
    }
}
