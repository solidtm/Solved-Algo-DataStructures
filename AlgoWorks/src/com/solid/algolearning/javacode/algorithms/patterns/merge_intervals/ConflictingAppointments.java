package com.solid.algolearning.javacode.algorithms.patterns.merge_intervals;

import java.util.*;

//Problem Statement #
//        Given an array of intervals representing ‘N’ appointments, find out if a person can attend all the appointments.
//
//        Example 1:
//
//        Appointments: [[1,4], [2,5], [7,9]]
//        Output: false
//        Explanation: Since [1,4] and [2,5] overlap, a person cannot attend both of these appointments.
//        Example 2:
//
//        Appointments: [[6,7], [2,4], [8,12]]
//        Output: true
//        Explanation: None of the appointments overlap, therefore a person can attend all of them.
//        Example 3:
//
//        Appointments: [[4,5], [2,3], [3,6]]
//        Output: false
//        Explanation: Since [4,5] and [3,6] overlap, a person cannot attend both of these appointments.

public class ConflictingAppointments {

    static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }


        public static boolean canAttendAllAppointments(Interval[] intervals) {
            // sort the intervals by start time
            Arrays.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));

            // find any overlapping appointment
            for (int i = 1; i < intervals.length; i++) {
                if (intervals[i].start < intervals[i - 1].end) {
                    // please note the comparison above, it is "<" and not "<="
                    // while merging we needed "<=" comparison, as we will be merging the two
                    // intervals having condition "intervals[i].start == intervals[i - 1].end" but
                    // such intervals don't represent conflicting appointments as one starts right
                    // after the other
                    return false;
                }
            }
            return true;
        }

        public static void main(String[] args) {
            Interval[] intervals = {new Interval(1, 4), new Interval(2, 5), new Interval(7, 9)};
            boolean result = canAttendAllAppointments(intervals);
            System.out.println("Can attend all appointments: " + result);

            Interval[] intervals1 = {new Interval(6, 7), new Interval(2, 4), new Interval(8, 12)};
            result = canAttendAllAppointments(intervals1);
            System.out.println("Can attend all appointments: " + result);

            Interval[] intervals2 = {new Interval(4, 5), new Interval(2, 3), new Interval(3, 6)};
            result = canAttendAllAppointments(intervals2);
            System.out.println("Can attend all appointments: " + result);
        }
    }
}
