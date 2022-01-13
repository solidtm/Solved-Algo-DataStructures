package com.solid.algolearning.kotlincode.algorithms.sorting

fun main() {
    val input = intArrayOf(2, 5, 9, 8, 7, 10, 4, 3)
    countingSort(input, 1, 10)
}

fun countingSort(input: IntArray, min: Int, max: Int){
    val countArray = intArrayOf((max - min) + 1)

    for (i in input.indices){
        countArray[input[i] - min]++
    }

    var j = 0
    for(i in min until max){
        while(countArray[i - min] > 0){
            input[j++] = i
            countArray[i - min]--
        }
    }
}