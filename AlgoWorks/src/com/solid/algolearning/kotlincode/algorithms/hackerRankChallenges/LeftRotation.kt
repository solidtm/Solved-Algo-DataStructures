package com.solid.algolearning.kotlincode.algorithms.hackerRankChallenges

import java.util.*

fun main() {
    val array = intArrayOf(1, 2, 3, 4, 5)
    println(Arrays.toString(rotateLeft(array, 4)))
}

fun rotateLeft(array: IntArray, numOfRotations: Int): IntArray? {
    val result = IntArray(array.size) //result array
    var rotatedIndex = 0
    var mainCounter = numOfRotations
//  If there's zero rotations
    if (numOfRotations == 0) {
        return array
    }

//   If there is empty array (assuming the array can contain zeros)
    if (array.isEmpty()) {
        return array
    }
//        If all other requirements above are met:
//        Loop through from the index of numOfRotations in the array to the end of the array
//        and copy it into the result array
    while (mainCounter < array.size) {
        result[rotatedIndex] = array[mainCounter]
        rotatedIndex++
        mainCounter++
    }
    mainCounter = 0
    while (mainCounter < numOfRotations) {
        result[rotatedIndex] = array[mainCounter]
        rotatedIndex++
        mainCounter++
    }
    return result
}