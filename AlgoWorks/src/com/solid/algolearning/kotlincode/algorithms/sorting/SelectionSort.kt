package com.solid.algolearning.kotlincode.algorithms.sorting

import com.solid.algolearning.javacode.algorithms.sorting.SelectionSort
import java.util.*

// Selection sort algorithm works by scanning for the smallest item in the list and replacing them with the item in the first index
fun main() {

    val numbers = intArrayOf(64, 25, 12, 22, 11)

    selectSort(numbers, numbers.size)
}

fun selectSort(numbers: IntArray, n: Int) {
    for (lastUnsortedIndex in n - 1 downTo 1) {
        var largest = 0
        for (i in 1..lastUnsortedIndex) {
            if (numbers[i] > numbers[largest]) {
                largest = i
            }
        }
        swap(numbers, largest, lastUnsortedIndex)
    }
    printOut(numbers)
}

fun swap(array: IntArray, i: Int, j: Int) {
    if (i == j) {
        return
    }
    val temp = array[i]
    array[i] = array[j]
    array[j] = temp
}

fun printOut(array: IntArray?) {
    println(Arrays.toString(array))
}