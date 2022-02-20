package com.solid.algolearning.javacode.algorithms.patterns.merge_intervals;

import java.util.*;

public class RemoveCoveredIntervals {
    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1,4},{3,6},{2,8}};
        System.out.println(removeCoveredIntervals(intervals));
    }

    public static int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, RemoveCoveredIntervals::compare);
        int i = 0;
        int c = 0;
        //iterate every element
        while (i < intervals.length) {
            //set current element as min and max
            int min = intervals[i][0];
            int max = intervals[i][1];

            while (i < intervals.length - 1 && min <= intervals[i + 1][0] && max >= intervals[i + 1][1]) {
                c++;
                i++;
            }
            i++;
        }
        // length of new array after deletion.
        return intervals.length - c;
    }
    //sort
    private static int compare(int[] a, int[] b) {
        if (a[0] == b[0]) {
            return b[1] - a[1];
        }
        return a[0] - b[0];
    }
}

