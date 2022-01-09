package com.solid.algolearning.kotlincode.algorithms.sorting

//Bubble sort comes from the idea of bubbling up the largest value eto the right and is 0(n^2) time complexity
fun bubbleSort(arr:IntArray):IntArray{
    var swap = true
    while(swap){
        swap = false
        for(i in 0 until arr.size-1){
             if(arr[i] > arr[i+1]){
                val temp = arr[i]
                arr[i] = arr[i+1]
                arr[i + 1] = temp

                swap = true
            }
        }
    }
    return arr
}

fun main() {
    val list = bubbleSort(intArrayOf(2,15,1,8,4))
    for (k in list) print("$k ")
}