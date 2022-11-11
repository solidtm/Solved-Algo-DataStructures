package com.solid.algolearning.kotlincode

fun main() {
//    println(getUniqueNoOfPairs(arrayOf(1,2,3,4,5,6,7,8,9,10), 12))
    println(fib(5))
}

fun getUniqueNoOfPairs( p: Array<Int>, c: Int ): Int {
    var res  = 0  //result to be returned.
    val numSet: HashSet<Int> = hashSetOf()

//for each number in p check if the set contains the
//conjugate of the number and c

    for(num in p){
        if(numSet.contains(c - num)){  //there is a conjugate
            res++   //increment result
        }else numSet.add(c - num)   //else add the conjugate
    }

    return res;   //return the result.
}

fun checkSet(): Int{
    val numSet: HashSet<Int> = hashSetOf()
    val p = 10
    var res = 0

//for each number in p check if the set contains the
//conjugate of the number and c

    for(num in 1..p){
        if(numSet.contains(num)){  //there is a conjugate
            res++   //increment result
        }else numSet.add(p - num)   //else add the conjugate
    }
    return res
}




fun fib(num : Int): Int{
    val cache = hashMapOf(Pair(1, 1), Pair(2, 1))

    calcFib(3, num, cache)

    return cache[num]!!
}

fun calcFib(start: Int, num: Int, cache: HashMap<Int, Int>){
    //base case
    if(start > num) return

    if(cache.containsKey(start - 1) && cache.containsKey(start - 2)){
        cache[start] = cache[start - 1]!! + cache[start - 2]!!
    }

    calcFib(start + 1, num, cache)
}
