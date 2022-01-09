package com.solid.algolearning.kotlincode.algorithms.sorting

import java.util.*

/* ShellSort is a variation of Insertion sort and aims at reducing the number of shifting to be done before the Insertion sort
* Some preliminary work is done before Insertion sort is carried out.
* ShellSort starts out by using a larger gap value (in this case calculated using array.size / 2) or Knuth sequence
* formula of (3^k -1) / 2.
*
*  */
fun main() {
    val array = intArrayOf(20, 35, -15, 7, 55, 1, -22)
    println(shellSort(array).contentToString())
}

fun shellSort(array: IntArray): IntArray {

    var gap = array.size / 2
    while (gap > 0) {
        for(i in gap until array.size){
            val newElement = array[i]       //save the element to be inserted
            var j = i
            while (j >= gap && array[j - gap] > newElement){
                array[j] = array[j - gap]
                j -= gap        //decrease j by gap to compare only values gap apart
            }
            //we have found the insertion point here
            array[j] = newElement       //insert the value at that point after we hit the end of the array
        }
        gap /= 2
    }
    return array
}
