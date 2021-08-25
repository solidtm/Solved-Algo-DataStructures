package com.solid.algolearning.kotlincode.algorithms.googleinterviews

import java.util.*

//  Here I will just write the kotlin equivalent for the most optimized algorithms i solve
fun main() {
    val arr1 = charArrayOf('a', 'b', 'c', 'x')
    val arr2 = charArrayOf('z', 'y', 'a')

    println(checkCommonItems(arr1, arr2))
}

fun checkCommonItems(arr1: CharArray, arr2: CharArray) : Boolean{
//   loop through first array1 and create Hashtable where properties == items in the array
    val table: Hashtable<Char, Boolean> = Hashtable(arr1.size)
    for (c in arr1) {
        if (!table.contains(c)) {
            table[c] = true
        }
    }
//   loop through second array and check if item in second array exists on created object
    for (c in arr2) {
       if (table.contains(c)) return true
    }
    return false
}
