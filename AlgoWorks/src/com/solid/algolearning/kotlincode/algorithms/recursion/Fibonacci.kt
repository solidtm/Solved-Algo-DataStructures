package com.solid.algolearning.kotlincode.algorithms.recursion

fun main() {
    println(fibonacciIterative(8))
    println(fibonacciRecursive(43))
}

fun fibonacciIterative(number: Int): Int{
    val array = arrayListOf(0, 1)

    for (i in 2 until number + 1){
        array.add(array[i - 2] + array[i - 1])
    }

    return array[number]
}

fun fibonacciRecursive(number: Int) : Int{
//    base case
    if (number < 2){
         return number
    }

//    recursive case
    return fibonacciRecursive(number - 1) + fibonacciRecursive(number - 2)
}