package com.solid.algolearning.javacode.algorithms.patterns.modified_binary_search;

//    Time complexity#
//    Since we are reducing the search range by half at every step, this means that the time complexity of our algorithm
//    will be O(logN)O(logN) where ‘N’ is the total elements in the given array.
//
//    Space complexity#
//    The algorithm runs in constant space O(1)O(1).

//    Similar Problems#
//    Problem 1#
//    How do we find the rotation count of a sorted and rotated array that has duplicates too?
//
//    The above code will fail on the following example!
//
//    Example 1:
//
//    Input: [3, 3, 7, 3]
//    Output: 3
//    Explanation: The array has been rotated 3 times

//    Solution
//    We can follow the same approach as discussed in Search in Rotated Array.
//    The only difference is that before incrementing start or decrementing end, we will check if either of them is the smallest number.

public class RotationCountsWithDuplicates {
    public static int countRotations(int[] arr) {
        if (arr == null || arr.length == 0)
            throw new IllegalArgumentException();

        int start = 0, end = arr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (mid < end && arr[mid] > arr[mid + 1]) // if element at mid is greater than the next element
                return mid + 1;
            if (mid > start && arr[mid - 1] > arr[mid]) // if element at mid is smaller than the previous element
                return mid;

            // this is the only difference from the previous solution
            // if numbers at indices start, mid, and end are same, we can't choose a side
            // the best we can do is to skip one number from both ends if they are not the smallest number
            if (arr[start] == arr[mid] && arr[end] == arr[mid]) {
                if (arr[start] > arr[start + 1]) // if element at start+1 is not the smallest
                    return start + 1;
                ++start;
                if (arr[end - 1] > arr[end]) // if the element at end is not the smallest
                    return end;
                --end;
                // left side is sorted, so the pivot is on right side
            } else if (arr[start] < arr[mid] || (arr[start] == arr[mid] && arr[mid] > arr[end])) {
                start = mid + 1;
            } else { // right side is sorted, so the pivot is on the left side
                end = mid - 1;
            }
        }

        return 0; // the array has not been rotated
    }

    public static void main(String[] args) {
        System.out.println(countRotations(new int[] { 3, 3, 7, 3 }));
    }

//    Time complexity
//    This algorithm will run in O(logN)O(logN) most of the times, but since we only skip two numbers in case of duplicates instead of the half of the numbers, therefore the worst case time complexity will become O(N)O(N).
//
//    Space complexity#
//    The algorithm runs in constant space O(1)O(1).
}
