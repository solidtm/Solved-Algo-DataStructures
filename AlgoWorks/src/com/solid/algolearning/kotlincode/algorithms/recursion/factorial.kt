package com.solid.algolearning.kotlincode.algorithms.recursion

fun main() {
//        println(findFactorialIterative(5))
        println(findFactorialRecursive(8))
}

fun findFactorialIterative(_number: Int) : Int{
    var answer = 1
    var number = _number

    if (number == 2){
        answer = 2
    }

    while (number > 0){
        answer *= number
        number--
    }

    return answer
}

fun findFactorialRecursive(_number: Int): Int{
    var number = _number

//    base case
    if (number == 0 || number == 1){
        return 1
    }

//    recursive case
    return number * findFactorialRecursive(number - 1)
}