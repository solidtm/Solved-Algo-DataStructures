package com.solid.algolearning.javacode.algorithms.patterns.merge_intervals;
//Problems#
//        Problem 1: Given a set of intervals, find out if any two intervals overlap.
//
//        Example:
//        Intervals: [[1,4], [2,5], [7,9]]
//        Output: true
//        Explanation: Intervals [1,4] and [2,5] overlap

import java.util.*;
public class MergeIntervals2 {

    static boolean merge2(List<MergeIntervals.Interval> intervals){
        //Sort with the interval starts thus:
        intervals.sort((a, b) -> Integer.compare(a.start, b.start));

//        we get the first interval thus
        Iterator<MergeIntervals.Interval> intervalItr = intervals.iterator();
        MergeIntervals.Interval interval = intervalItr.next();
        int start = interval.start;
        int end = interval.end;

        while(intervalItr.hasNext()){
            interval = intervalItr.next();

            if(interval.start <= end) return true;  //we have overlapping
            else {
                start = interval.start;
                end = interval.end;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        List<MergeIntervals.Interval> input = new ArrayList<>();
        input.add(new MergeIntervals.Interval(1, 4));
        input.add(new MergeIntervals.Interval(2, 5));
        input.add(new MergeIntervals.Interval(7, 9));
        System.out.print("Merged intervals: ");
        System.out.print("Interval exists: " + merge2(input));
        System.out.println();

        input = new ArrayList<>();
        input.add(new MergeIntervals.Interval(6, 7));
        input.add(new MergeIntervals.Interval(2, 4));
        input.add(new MergeIntervals.Interval(5, 9));
        System.out.print("Interval exists: " + merge2(input));
        System.out.println();

        input = new ArrayList<>();
        input.add(new MergeIntervals.Interval(1, 4));
        input.add(new MergeIntervals.Interval(2, 6));
        input.add(new MergeIntervals.Interval(3, 5));
        System.out.print("Merged intervals: ");
        System.out.print("Interval exists: " + merge2(input));
        System.out.println();
    }

}
