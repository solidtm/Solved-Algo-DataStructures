package com.solid.algolearning.kotlincode.algorithms.searching

class StopWatch {
    val start: Long = System.currentTimeMillis()

    fun elapsedTime(): Double{
        val now: Long = System.currentTimeMillis()
        return (now - start) / 1000.00
    }
}