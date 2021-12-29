package com.solid.algolearning.kotlincode.algorithms.sorting

import java.util.*

fun main() {
    val letters = ArrayList<String>()
    letters.add("a")
    letters.add("d")
    letters.add("z")
    letters.add("e")
    letters.add("r")
    letters.add("b")
    letters.add("q")

    println(Arrays.toString(letters.stream().sorted().toArray()))


    val basket = ArrayList<Int>()
    basket.add(2)
    basket.add(65)
    basket.add(34)
    basket.add(2)
    basket.add(1)
    basket.add(7)
    basket.add(8)
    println(Arrays.toString(basket.stream().sorted().toArray()))
}