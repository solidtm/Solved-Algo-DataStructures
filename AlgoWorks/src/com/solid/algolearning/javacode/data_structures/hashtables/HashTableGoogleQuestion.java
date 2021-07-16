package com.solid.algolearning.javacode.data_structures.hashtables;

import java.util.HashSet;
import java.util.Set;

public class HashTableGoogleQuestion {
    //Google question
//    Given an array = [2, 5, 1, 2, 3, 5, 1, 2, 4]:
//    Find the first recurring character
//    Above array should return 2

//    Given an array = [2, 1, 1, 2, 3, 5, 1, 2, 4]:
//    should return 1

//    Given array = [2, 3, 4, 5]
//    It should return undefined


    public static void main(String[] args) {
        int[] array1 = {2, 1, 1, 2, 3, 5, 1, 2, 4};
        int[] array2 = {2, 5, 1, 2, 3, 5, 1, 2, 4};
        int[] array3 = {2, 3, 4, 5};

        System.out.println(findRecurringNumber(array1));
        System.out.println(findRecurringNumber(array2));
        System.out.println(findRecurringNumber(array3));

    }

    public static int findRecurringNumber(int[] array){
        int result = 0;
        if(array.length < 1){
            System.out.println("Null element array");
            return 0;
        }

        Set<Integer> elementSet = new HashSet<>();
        for(int element : array){
            if (!elementSet.contains(element)){
                elementSet.add(element);
                System.out.println(elementSet.toString());
            }else{
                result = element;
                break;
            }
        }
        return result;
    }
}
