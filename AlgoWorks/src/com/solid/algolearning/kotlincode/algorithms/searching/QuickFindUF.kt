package com.solid.algolearning.kotlincode.algorithms.searching

fun main() {
    val quickFindUF = QuickFindUF(10)
    quickFindUF.union(4, 3)
    println(quickFindUF.id.contentToString())
    println(quickFindUF.connected(4, 3))
    quickFindUF.union(3, 8)
    println(quickFindUF.id.contentToString())
    println(quickFindUF.connected(3, 8))
    quickFindUF.union(6, 5)
    println(quickFindUF.id.contentToString())
    println(quickFindUF.connected(6, 5))
    quickFindUF.union(9, 4)
    println(quickFindUF.id.contentToString())
    println(quickFindUF.connected(9, 4))
    quickFindUF.union(2, 1)
    println(quickFindUF.id.contentToString())
    println(quickFindUF.connected(2, 1))
    quickFindUF.union(5, 0)
    println(quickFindUF.id.contentToString())
    println(quickFindUF.connected(5, 0))
    quickFindUF.union(7, 2)
    println(quickFindUF.id.contentToString())
    println(quickFindUF.connected(7, 2))
    quickFindUF.union(7, 3)
    println(quickFindUF.id.contentToString())
    println(quickFindUF.connected(7, 3))
}

class QuickFindUF(N: Int) {
    val id: IntArray = IntArray(N)

//    The constructor initializes the data structure(array) id[] with values of the counter.
    init {
        for (i in 0 until N) {
            id[i] = i
        }
    }

    //    Method to check if two objects in the array are connected, this is the quick-find itself.
    //    Checks whether p and q are of the same components
    fun connected(p: Int, q: Int): Boolean {
        return id[p] == id[q]
    }

    //    Union Method to union two objects nd implement the union algorithm above
    //    hence setting the value of all element with the same value(ie connected to) as p_id to value of q_id
    fun union(p: Int, q: Int) {
        val pId = id[p]
        val qId = id[q]
        for (i in id.indices) {
            if (id[i] == pId) {
                id[i] = qId
            }
        }
    }
}
