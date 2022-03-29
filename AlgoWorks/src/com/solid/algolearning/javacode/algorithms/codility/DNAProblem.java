package com.solid.algolearning.javacode.algorithms.codility;


import java.util.*;
public class DNAProblem {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("CAGCCTA", new int[]{2,5,0}, new int[]{4,5,6})));
    }

    //this algorithm is O(n^2)
    public static int[] solution(String s, int[] p, int[] q) {
        Map<Character, Integer> freqMap = new HashMap<>();
        freqMap.put('A', 1);
        freqMap.put('C', 2);
        freqMap.put('G', 3);
        freqMap.put('T', 4);

        int[] result = new int[p.length];

        int k = 0;
        for(int i = 0; i < p.length; i++){
            String str = s.substring(p[i], q[i] + 1);

            int min = Integer.MAX_VALUE;
            for(char c : str.toCharArray()){
                min = Math.min(min, freqMap.get(c));
            }

            result[k++] = min;
        }

        return result;
    }


    //this algorithm is O(n)
    public static int[] solution2(String s, int[] p, int[] q) {
        Map<Character, Integer> freqMap = new HashMap<>();
        freqMap.put('A', 1);
        freqMap.put('C', 2);
        freqMap.put('G', 3);
        freqMap.put('T', 4);

        // 0 1 2 3 4 5
        //S = CAGCCTA,  G G G T A C ->
        // res:

        int[] result = new int[p.length];

        int k = 0;
        for(int i = 0; i < p.length; i++){
            String str = s.substring(p[i], q[i] + 1);

            if(str.contains("A")){
                result[k++] = freqMap.get('A');
            }else if(!str.contains("A") && str.contains("C")){
                result[k++] = freqMap.get('C');
            }else if(!str.contains("A") && !str.contains("C") && str.contains("G")){
                result[k++] = freqMap.get('G');
            }else {
                result[k++] = freqMap.get('T');
            }

        }

        return result;
    }


    public static int[] solution3(String s, int[] p, int[] q) {
       int[][] counters = new int[3][s.length() + 1];

       int aCounter = 0, cCounter = 0, gCounter = 0;

        for (int i = 0; i < s.length(); i++) {
            String ch = s.substring(i, i + 1);
            switch (ch) {
                case "A":
                    aCounter++;
                    break;
                case "C":
                    cCounter++;
                    break;
                case "G":
                    gCounter++;
                    break;
            }


            counters[0][i + 1] = aCounter;
            counters[1][i + 1] = cCounter;
            counters[2][i + 1] = gCounter;
        }
        
        int[] result = new int[p.length];

        for (int i = 0; i < result.length; i++) {
            int startIndex = p[i];
            int endIndex = q[i] + 1;

            int res = 4;
            for (int j = 0; j < 3; j++) {
                if (counters[j][startIndex] != counters[j][endIndex]){
                    res = j + 1;
                    break;
                }
            }

            result[i] = res;
        }
        return result;
    }

}














