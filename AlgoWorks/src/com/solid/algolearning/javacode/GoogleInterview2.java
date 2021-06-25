package com.solid.algolearning.javacode;

import java.util.HashSet;
import java.util.Set;

public class GoogleInterview2 {
//    The question was to check if two values in an array equal to a given sum
//    We are assuming that the inputs (both array and sum) must always be integers and -ve numbers involved
//    Our function will always return true or false and not the pairs
//    The main goal of this is to know the most efficient function you can come up with
//    Started with the naive approach
//    Obviously for the brute force approach, the time complexity is O{n^2) because of the nested loop
//    and is inefficient because it becomes slow as the inputs become larger the more.

//    and then afterwards thought of a better approach
//    The steps for this better approach is thus:
//    We used a Set, and we store the compliment of any element we find in the Set if we have not seen that compliment before
//    If we have seen the compliment before (which of course will be looked from from the Set), we return true
//    else if we haven't seen the compliment before, we keep adding the compliments in the set until we loop through the whole set
//    and return.
//   The above postulated solution will then have a time complexity of O(n) which is linear time and more efficient.

//   The next step is to think about error checks:
//    What if there are repeating values in the array? will the above solution still work?
//    What if there is a number in the array instead of a character?
//    What is we have an empty array index?


    public static void main(String[] args) {
        System.out.println(hasPairWithSum(new int[]{6, 4, -2, 3, 1, 7}, 9));
    }                                       //{}

//    Naive approach
//    public static boolean hasPairWithSum(int[] arr, int sum){
//        int len = arr.length;
//        for(int i =0; i<len-1; i++){
//            for(int j = i+1;j<len; j++){
//                if (arr[i] + arr[j] == sum)
//                    return true;
//            }
//        }
//        return false;
//    }
    
//    Better approach
    public static boolean hasPairWithSum(int[] arr, int sum){
        int len = arr.length;
        Set<Integer> elementSet= new HashSet<>(len);
        for (int i : arr) {
            if (elementSet.contains(i)) {
                return true;
            }
            elementSet.add(sum - i);
        }
        return false;
      }
}
