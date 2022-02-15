package com.solid.algolearning.javacode.algorithms.patterns.merge_intervals;

import java.util.*;

public class InsertInterval {

    public static List<MergeIntervals.Interval> insert(List<MergeIntervals.Interval> intervals, MergeIntervals.Interval newInterval) {
        List<MergeIntervals.Interval> mergedIntervals = new ArrayList<>();

        int i = 0;
        //skip all intervals that end before newInterval starts
        while (i < intervals.size() && intervals.get(i).end < newInterval.start){
            mergedIntervals.add(intervals.get(i++));
        }

        // check for overla in intervals that doesn't satisfy the above condition
        while(i < intervals.size() && intervals.get(i).start <= newInterval.end){
            newInterval.start = Math.min(intervals.get(i).start, newInterval.start);
            newInterval.end = Math.min(intervals.get(i).end, newInterval.end);
            mergedIntervals.add(newInterval);

            i++;
        }

        //add the remaining intervals that are not overlapping
        while (i < intervals.size()){
            mergedIntervals.add(intervals.get(i++));
        }

        return mergedIntervals;
    }

    public static void main(String[] args) {
        List<MergeIntervals.Interval> input = new ArrayList<>();
        input.add(new MergeIntervals.Interval(1, 3));
        input.add(new MergeIntervals.Interval(5, 7));
        input.add(new MergeIntervals.Interval(8, 12));
        System.out.print("Intervals after inserting the new interval: ");
        for (MergeIntervals.Interval interval : InsertInterval.insert(input, new MergeIntervals.Interval(4, 6)))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<>();
        input.add(new MergeIntervals.Interval(1, 3));
        input.add(new MergeIntervals.Interval(5, 7));
        input.add(new MergeIntervals.Interval(8, 12));
        System.out.print("Intervals after inserting the new interval: ");
        for (MergeIntervals.Interval interval : InsertInterval.insert(input, new MergeIntervals.Interval(4, 10)))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<>();
        input.add(new MergeIntervals.Interval(2, 3));
        input.add(new MergeIntervals.Interval(5, 7));
        System.out.print("Intervals after inserting the new interval: ");
        for (MergeIntervals.Interval interval : InsertInterval.insert(input, new MergeIntervals.Interval(1, 4)))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();
    }
}
