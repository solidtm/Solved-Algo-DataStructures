package com.solid.algolearning.javacode.algorithms.patterns.merge_intervals;

//Employee Free Time (hard)#
//        For ‘K’ employees, we are given a list of intervals representing the working hours of each employee. Our goal is to find out if there is a free interval that is common to all employees. You can assume that each list of employee working hours is sorted on the start time.
//
//        Example 1:
//        Input: Employee Working Hours=[[[1,3], [5,6]], [[2,3], [6,8]]]
//        Output: [3,5]
//        Explanation: Both the employees are free between [3,5].

//        Example 2:
//        Input: Employee Working Hours=[[[1,3], [9,12]], [[2,4]], [[6,8]]]
//        Output: [4,6], [8,9]
//        Explanation: All employees are free between [4,6] and [8,9].

//        Example 3:
//        Input: Employee Working Hours=[[[1,3]], [[2,4]], [[3,5], [7,9]]]
//        Output: [5,7]
//        Explanation: All employees are free between [5,7].

//    One simple solution can be to put all employees’ working hours in a list
//        and sort them on the start time. Then we can iterate through the list to find the gaps.
//        Let’s dig deeper. Sorting the intervals of the above example will give us:
//
//        [1,3], [2,4], [6,8], [9,12]
//        We can now iterate through these intervals, and whenever we find non-overlapping intervals (e.g., [2,4] and [6,8]),
//        we can calculate a free interval (e.g., [4,6]). This algorithm will take O(N * logN)O(N∗logN) time, where ‘N’ is the total number of intervals.
//        This time is needed because we need to sort all the intervals. The space complexity will be O(N)O(N), which is needed for sorting.
//        Can we find a better solution?
//
//        Using a Heap to Sort the Intervals#
//        One fact that we are not utilizing is that each employee list is individually sorted!
//
//        How about we take the first interval of each employee and insert it in a Min Heap.
//        This Min Heap can always give us the interval with the smallest start time. Once we have the smallest start-time interval,
//        we can then compare it with the next smallest start-time interval (again from the Heap) to find the gap.
//        This interval comparison is similar to what we suggested in the previous approach.
//
//        Whenever we take an interval out of the Min Heap, we can insert the same employee’s next interval.
//        This also means that we need to know which interval belongs to which employee.

import java.util.*;
class EmployeeFreeTime {
    static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    static class EmployeeInterval {
        Interval interval; // interval representing employee's working hours
        int employeeIndex; // index of the list containing working hours of this employee
        int intervalIndex; // index of the interval in the employee list

        public EmployeeInterval(Interval interval, int employeeIndex, int intervalIndex) {
            this.interval = interval;
            this.employeeIndex = employeeIndex;
            this.intervalIndex = intervalIndex;
        }
    }

    public static List<Interval> findEmployeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> result = new ArrayList<>();
        // PriorityQueue to store one interval from each employee
        PriorityQueue<EmployeeInterval> minHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare(a.interval.start, b.interval.start));

        // insert the first interval of each employee to the queue
        for (int i = 0; i < schedule.size(); i++)
            minHeap.offer(new EmployeeInterval(schedule.get(i).get(0), i, 0));

        Interval previousInterval = minHeap.peek().interval;
        while (!minHeap.isEmpty()) {
            EmployeeInterval queueTop = minHeap.poll();
            // if previousInterval is not overlapping with the next interval, insert a free interval
            if (previousInterval.end < queueTop.interval.start) {
                result.add(new Interval(previousInterval.end, queueTop.interval.start));
                previousInterval = queueTop.interval;
            } else { // overlapping intervals, update the previousInterval if needed
                if (previousInterval.end < queueTop.interval.end)
                    previousInterval = queueTop.interval;
            }

            // if there are more intervals available for the same employee, add their next interval
            List<Interval> employeeSchedule = schedule.get(queueTop.employeeIndex);
            if (employeeSchedule.size() > queueTop.intervalIndex + 1) {
                minHeap.offer(new EmployeeInterval(employeeSchedule.get(queueTop.intervalIndex + 1), queueTop.employeeIndex,
                        queueTop.intervalIndex + 1));
            }
        }

        return result;
    }

    public static void main(String[] args) {

        List<List<Interval>> input = new ArrayList<>();
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(1, 3), new Interval(5, 6))));
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(2, 3), new Interval(6, 8))));
        List<Interval> result = EmployeeFreeTime.findEmployeeFreeTime(input);
        System.out.print("Free intervals: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + ", " + interval.end + "] ");
        System.out.println();

        input = new ArrayList<>();
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(1, 3), new Interval(9, 12))));
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(2, 4))));
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(6, 8))));
        result = EmployeeFreeTime.findEmployeeFreeTime(input);
        System.out.print("Free intervals: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + ", " + interval.end + "] ");
        System.out.println();

        input = new ArrayList<>();
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(1, 3))));
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(2, 4))));
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(3, 5), new Interval(7, 9))));
        result = EmployeeFreeTime.findEmployeeFreeTime(input);
        System.out.print("Free intervals: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + ", " + interval.end + "] ");
    }
}