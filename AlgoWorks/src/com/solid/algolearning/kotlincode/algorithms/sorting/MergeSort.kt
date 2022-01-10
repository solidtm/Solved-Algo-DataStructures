package com.solid.algolearning.kotlincode.algorithms.sorting

fun main() {

    val array = intArrayOf(20, 35, -15, 7, 55, 1, -22)
    mergeSort(array, 0, array.size)

    println(array.contentToString())
}

fun mergeSort(input: IntArray, start: Int, end: Int){
//    Base case: This method will break out of the recursion when we have a one element array
    if((end - start) < 2){   //ie we have a one element array at this point
        return
    }

// If it's not a one element array then we have work to do thus:
// Partition the array we have been parsed, by just figuring the middle position using the start and end and since the partitioning i logical
    val mid = (start + end) / 2
//  we do a mergeSort on the left and right partitions thus:
    mergeSort(input, start, mid)        //left partition divided, sorted and merged
    mergeSort(input, mid, end)          //right partition divided, sorted and merged

//    merge the sorted partitions
    merge(input, start, mid, end)
}

fun merge(input: IntArray, start: Int, mid: Int, end: Int) {
//    Optimization: if the last element in the left partition is less than or
//    equal to the first element in the right partition,
//    this means that all the elements in the left partition are less than the ones
//    in the right partition and in that case we return...

    if (input[mid - 1] <= input[mid]){
        return
    }

//    But if the above optimization code is not met, we have more work to do thus:
    var i = start
    var j = mid
    var tempIndex = 0       //variable to keep track of where we are in the temporary array when we do the copy
    val temp = intArrayOf(end - start)      //temporary array to do the copying

//    step through the left and right arrays and compare the elements for which is greater and copy to the temp array and keep track of the copuy
    while (i < mid && j < end){ //as long as we are still traversing the left or right array, we drop out of the loop
        temp[tempIndex++] = if (input[i] <= input[j]) input[i++] else input[j++]     //compare the current element in the left and right arrays and assign it to the current index in temp
//   Optimization:  if we have elements remaining in the left partition, we copy then into the temp array but if we have elements remaining in the right partition, we don't have to do anything
//   this is because we will be doing needless work by copying those elements back into the same positions in the input array where they occupied before
         System.arraycopy(input, i, input, start + tempIndex, mid - i) //handles only the left array leftovers
         System.arraycopy(temp, 0, input, start, tempIndex)     //copy the elements added to temp back to the input array
    }
}















