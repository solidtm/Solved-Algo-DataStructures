package com.solid.algolearning.kotlincode.algorithms.sorting

import java.util.*

// Insertion sort is very useful in cases where the list is almost or already sorted, and we can have almost linear time(On) sorting in that case.
// Insertion sort works by shifting elements by inserting them in the positions where they are meant to be comparison starts from the 2nd element

//    Insertion sort implementation
//    We don't swap elements in this implementation, we shift elements

fun main() {
//    println("How many products do you want to buy?: ")
//    val num = readLine()
//    val number = num?.toDouble()?.times(29.99)?:1
//    println("Total cost of purchase is: $number" )

    val numbers = intArrayOf(20, 35, -15, 7, 55, 1, -22)   //firstUnsortedIndex = 2, newElement = -15, i = 1,
    insertSort(numbers, numbers.size)
}

//    Insertion sort assumes that the first element in the list is in its correct sorted position and starts from the second to sort,
//    Comparing from then on and inserting in the appropriate position/index

//    Insertion sort assumes that the first element in the list is in its correct sorted position and starts from the second to sort,
//    Comparing from then on and inserting in the appropriate position/index
private fun insertSort(numbers: IntArray, length: Int) {
    for (firstUnsortedIndex in 1 until length) {
        val newElement = numbers[firstUnsortedIndex]      //(20, 35, -15, 7, 55, 1, -22)
        //        This is where the shifting is done
//        loop through the sorted partition with condition that we have not hit the end of the array, and that the number at i-1 is greater than the newElement
        var i = firstUnsortedIndex
        while (i > 0 && numbers[i - 1] > newElement) {
            numbers[i] = numbers[i - 1]
            i--
        }
//   When we hit the end of the loop or the number is not greater than the newElement, we simply assign that index to the new value
        numbers[i] = newElement
    }
    println(numbers.contentToString())
}

