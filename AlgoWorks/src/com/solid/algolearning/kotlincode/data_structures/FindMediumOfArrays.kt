package com.solid.algolearning.kotlincode.data_structures

import kotlin.math.ceil
/** Median of Two Sorted Arrays
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).

Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.

Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
Example 3:

Input: nums1 = [0,0], nums2 = [0,0]
Output: 0.00000
Example 4:

Input: nums1 = [], nums2 = [1]
Output: 1.00000
Example 5:

Input: nums1 = [2], nums2 = []
Output: 2.00000


Constraints:

nums1.length == m
nums2.length == n
0 <= m <= 1000
0 <= n <= 1000
1 <= m + n <= 2000
-106 <= nums1[i], nums2[i] <= 106
 */
fun main() {
    val nums1 = intArrayOf(1,3)
    val nums2 = intArrayOf(2)

    val sentence  = "I want 200 eggs and all the 300 baskets"
    sumRegex(sentence)
//    println(findMedianSortedArrays(nums1,nums2))
}

private fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
    val num3 = nums1 + nums2;
    val length = num3.size / 2;
    var median: Double

    if(num3.isEmpty()){
        median =  0.00
    }

    if(num3.size == 1){
        median = num3[0].toDouble();
    }else if(num3.size == 2){
        median = ((num3[0] + num3[1]) / 2).toDouble()
    }
    num3.sort();

    median = if((num3.size % 2) == 0){
        ((length + (length + 1)) / 2).toDouble()
    }else{
        (ceil(length.toDouble()) / 2).toInt().toDouble()
    }

    return median
}

fun sumRegex(sentence: String): Int{
    var answer = 0;
    val words = sentence.split(" ")
    val regex = ".*\\d.*".toRegex()
    for (i in words){
        if (i.matches(regex)){
            answer.plus(Integer.parseInt(i.toString()))
        }
    }
    return answer
}















