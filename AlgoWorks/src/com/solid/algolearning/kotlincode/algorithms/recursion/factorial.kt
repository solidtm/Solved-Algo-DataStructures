package com.solid.algolearning.kotlincode.algorithms.recursion

fun main() {
//        println(findFactorialIterative(5))
//        println(findFactorialRecursive(8))
    println(factorialIterative(5))
    println(fact(5))
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

fun findFactorialRecursive(_number: Int): Int {

//    base case
    if (_number == 0 || _number == 1) {
        return 1
    }

//    recursive case
    return _number * findFactorialRecursive(_number - 1)
}


fun factorialIterative(num: Int): Int{
    if(num == 0){
        return 1
    }

    var factorial = 1
    for (i in 1 until num){
        factorial *= i
    }

    return factorial
}

fun factorialRecursive(num: Int): Int{
    if(num == 0 || num == 1){
        return 1
    }

    return num * factorialRecursive(num - 1)
}

// A tail recursive function
// to calculate factorial
fun factTR(n: Int, a: Int): Int {
    return if (n == 0) a else factTR(n - 1, n * a)
}

// A wrapper over factTR
fun fact(n: Int): Int {
    return factTR(n, 1)
}



//fact (5) ->> factTR(4, 5 * 1) ->> factTR(4, 5)
//factTR(4, 4*5) ->> factTR(3, 20)
//factTR(3, 3*20) ->> factTR(2, 60)
//factTR(2, 2 * 60) ->> factTR(1, 120)
//fact(1, 120 * 1) ->> factTR(0, 120)
//factTR(0, 120) ->> returns 1, so we go up the call stack again
