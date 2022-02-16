package com.solid.algolearning.javacode.algorithms.recursion.permutations;

import java.util.ArrayList;
import java.util.Arrays;

//Here we are asked to print all the permutations of a given String
//note that string substring method end index is exclusive
public class Permutations {
    public static void main(String[] args) {
        permutations("", "abc");
        System.out.println(permutationsList("", "abc"));
        System.out.println(permutationsCount("", "abcd"));
    }

    static void permutations(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        
        char ch = up.charAt(0);   //get the first element

        for (int i = 0; i <= p.length(); i++) {  //each function call is dependent on the processed length
            String f = p.substring(0, i);  //get the number
            String s = p.substring(i);  // get from current index to length

            permutations(f + ch + s, up.substring(1));
        }
    }

    static ArrayList<String> permutationsList(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList<String> ans = new ArrayList<>();  //local to this call and new arraylist is not created.
        char ch = up.charAt(0);   //get the first element

        for (int i = 0; i <= p.length(); i++) {  //each function call is dependent on the processed length
            String f = p.substring(0, i);  //get the value at first index of p
            String s = p.substring(i);  // get from current index to length of p

            ans.addAll(permutationsList(f + ch + s, up.substring(1)));
        }

        return ans;
    }

    //Sometimes you may be asked to return the count of the permutations

    static int permutationsCount(String p, String up){
        if(up.isEmpty()){
            return 1;
        }

        int count = 0;
        char ch = up.charAt(0);   //get the first element

        for (int i = 0; i <= p.length(); i++) {  //each function call is dependent on the processed length
            String f = p.substring(0, i);  //get the number
            String s = p.substring(i);  // get from current index to length

            count = count + permutationsCount(f + ch + s, up.substring(1));
        }
        return count;
    }
}
