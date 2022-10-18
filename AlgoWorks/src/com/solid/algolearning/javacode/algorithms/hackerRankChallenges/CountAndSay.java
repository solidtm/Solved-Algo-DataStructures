package com.solid.algolearning.javacode.algorithms.hackerRankChallenges;

import java.util.*;

public class CountAndSay {
    public static void main(String[] args) {
        System.out.println(countAndSay(4));
        System.out.println(countAndSay(10));
        System.out.println(countAndSay(30));
    }

    public static String countAndSay(int n) {
        StringBuilder sb = new StringBuilder();
        Map<Integer, String> map = new HashMap<>();

        //add values for 1 and 2
        map.put(1, "1");
        map.put(2, "11");
        int i = 0, j = 0;

        if (n == 1) return map.get(n);


        for (int x = 3; x <= n; x++) {
            String prevVal = map.get(x - 1);

            //using two pointers (i & j)
            while (j <= prevVal.length() - 1 && i <= j) {
                if (prevVal.charAt(i) != prevVal.charAt(j)) {  //if found violation, values aren't same
                    int length = j - i;
                    sb.append(length).append(prevVal.charAt(i));
                    i = j;
                }

                if (j == prevVal.length() - 1) {  //if j pointer has reached the end of the string
                    int length = j - i + 1;
                    sb.append(length).append(prevVal.charAt(i));
                }

                j++;
            }

            //store value and reset pointers
            map.put(x, sb.toString());
            sb = new StringBuilder();
            i = 0; j = 0;
        }

        return map.get(n);
    }
}


