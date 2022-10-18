package com.solid.algolearning.javacode.algorithms.hackerRankChallenges;

import java.util.*;
public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        if (intervals.length < 2) return intervals;
        ArrayList<int[]> res = new ArrayList<>();

        for(int[] interval : intervals){
            if(!res.isEmpty()){
                int a = res.get(res.size() - 1)[0];
                int b = res.get(res.size() - 1)[1];
                int c = interval[0];
                int d = interval[1];

                if(c <= b){
                    interval[0] = Math.min(a, c);
                    interval[1] = Math.max(b, d);
                    res.remove(res.size() - 1);
//                    res.add(interval);
                }
            }
            res.add(interval);
        }

        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        //[[1,3],[2,6],[8,10],[15,18]]
        int[][] intervals = new int[][]{{1,3}, {2,6}, {8,10}, {15,18}};
        System.out.println(Arrays.deepToString(merge(intervals)));
    }
}
