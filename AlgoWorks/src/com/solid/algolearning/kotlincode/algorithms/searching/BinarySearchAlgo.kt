package com.solid.algolearning.kotlincode.algorithms.searching

/*Non recursive solution for Binary search algorithm
    Here we find index of a key in a sorted array
    Implementation of the binarySearch Algo is such that we first look for the key starting from the middle of the sorted array
    If the key is less than the middle value, then the key is at the right side of the list, else if it is greater than the mid
    value, then it is at the right hnd half of the list, else it is equal to the list and we repeat this until the value is found
    from the subsets created afterwards.
    */
fun binarySearch(a: IntArray, key: Int): Int {  //[1, 2, 3, 4, 5] high = 4, low = 0, mid = (0 + (4 - 0))) / 2 = 2
    var low = 0
    var high = a.size - 1
    while (low <= high) {
        val middle = low + (high - low) / 2 //note this very well, middle is low + (high - low) / 2

        if (key < a[middle]) {
            high = middle - 1
        } else if (key > a[middle]) {
            low = middle + 1
        } else return middle
    }
    return -1
}

fun main(args: Array<String>) {
    val stopWatch = StopWatch()
    val array = intArrayOf(6, 13, 14, 25, 33, 43, 51, 64, 72, 84, 93, 95, 96, 97, 99)
    val key = 72
    println(binarySearch(array, key))
    println(stopWatch.elapsedTime())
}