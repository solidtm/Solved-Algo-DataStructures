package com.solid.algolearning.kotlincode.algorithms.sorting


//we will be using 2 methods for this algorithm
//    one called quickSort and another called partition
fun main() {
    val array = intArrayOf(20, 35, -15, 7, 55, 1, -22)
    quickSort(array, 0, array.size)

    println(array.contentToString())
}
    fun quickSort (input: IntArray, start: Int, end: Int){
        if(end - start < 2){
            return
        }

        val pivotIndex = partition(input, start, end)       //this function returns the sorted position of the pivot where everything in the right is > and left < the pivot.
        quickSort(input, start, pivotIndex)             //handle the left sub array recursively
        quickSort(input, pivotIndex + 1, end)       //handle the right sub array recursively
    }

    private fun partition(input: IntArray, start: Int, end: Int): Int {
        //This is using the first element in the array as pivot

        val pivot = input[start]
        var i = start
        var j = end

        while (i < j){
//            Start with j and traverse from right to left
//            Empty loop body, we are ony using this to continue decrementing j
            while (i < j && input[--j] >= pivot);
                if(i < j){
                    input[i] = input[j]     //we found element > pivot
                }//alternate and go to i moving from left to right
            while(i < j && input[++i] <= pivot); //empty loop body, we are ony using this to continue to increment i
                if (i < j){
                    input[j] = input[i] // we found element < pivot
                }
        }

//        So at this point, the value of j will be the sorted position to insert the pivot
        input[j] = pivot
        return j
    }














