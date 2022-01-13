package com.solid.algolearning.kotlincode.algorithms.googleinterviews


fun main() {
        val input = intArrayOf(-2, -1, 0, 2, 3)
        println(squareSort(input))
}


fun squareSort(input: IntArray): IntArray{
    if(input.isEmpty()){
        return intArrayOf()
    }

    var a = 0
    var b = input.count() - 1
    val result = intArrayOf(input.size)

    for(i in input.indices){
        input[i] *= input[i]
    }// we have all elements squared


    for (i in input.indices){
        if (a < b){
            if(input[a] >= input[b]){
                result[i] = input[a++]
            }else{
                result[i] = input[b--]
            }
        }

    }
    return result
}
