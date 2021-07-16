package com.solid.algolearning.javacode.data_structures.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class ArrayInterviewQuestions {
//    Question 1:
//    Create a function that reverses a string:
//    "Hi My name is Andrei"  should be:
//    "ierdnA si eman iH"

//    Question 2:
//    Given two arrays that are sorted, can you merge the two arrays together so that we have one si

    public static void main(String[] args) {
//      Question 1 tests:
        String word = "Hi, My name is ";
        int  word2 = 123;
        String word3 = "I";
        reverse(word);
//        reverse(word2);             //error
        System.out.println();
        reverse(word3);


//      Question 2 tests:
        int[] arr1 = {3, 3};
        int[] arr2 = {4, 6, 30};

        mergeSortedArrays(arr1, arr2);

        System.out.println(Arrays.toString(twoSum(arr1, 6)));
        System.out.println("============================");
        System.out.println("============================");
        int[] newArray = {0,1,0,3,12};
        moveZeroes2(newArray);
        System.out.println(Arrays.toString(newArray));

        String sentence = "a b c dee";
        System.out.println(LongestWord(sentence));

        int[] nonDecreasingArray = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nonDecreasingArray));
    }



    //    Question 1 solution:
    public static void reverse(String args) {
//        First thing to do is to always check the inputs:
//        If args is empty, or args is just one letter, there is no need for any reversal simply printout the letter
//        We can also add some input validation to the string to make sure it is an instance of/typeof String class.
//        But in this case its not necessary because the input is always a String as stated
        if (args.isEmpty() || args.length() < 2){
            System.out.println("Hmm, that's not good for reversal");
        }else {
            String[] arr = args.split("");
            for (int i = arr.length - 1; i >= 0; i--) {
                System.out.print(arr[i]);
            }
        }
    }

//    Question 2 solution:
    private static void mergeSortedArrays(int[] arr1, int[] arr2) {
//        First we check for the inputs thus:
//        Ask interviewer if the input arrays will always be sorted and if the input arrays will always be integers
//        if yes we carry on thus:
        if (arr1.length == 0 || arr2.length == 0){
            System.out.println("Invalid array values for merge");
        }else{
            System.out.println(Arrays.toString(mergeArrays(arr1, arr2)));
        }
    }

    private static int[] mergeArrays(int[] arr1, int[] arr2) {
//        create arr3 of size arr1.length + arr2.length
        int i = 0, j = 0, k = 0;
        int length1 = arr1.length, length2 = arr2.length;
        int[] arr3 = new int[length1 + length2];

//        Traverse both arrays
        while(i < length1 && j < length2){
//            Check if current element of first
//            array is smaller than current element
//            of the second array. If yes, store the first array element
//            and increment first array index. Otherwise do same with second array

            if (arr1[i] < arr2[j])
                arr3[k++] = arr1[i++];
            else
                arr3[k++] = arr2[j++];
        }

//        Store remaining elements of first array
        while(i < length1)
            arr3[k++] = arr1[i++];
//        Store remaining elements of second array
        while(j < length2)
            arr3[k++] = arr2[j++];

        return arr3;
    }


//    To sum problem that returns the index of the two array elements that add up to the sum.
    public static int[] twoSum(int[] nums, int target) {
        ArrayList<Integer> numArray = new ArrayList();
        ArrayList<Integer> returnArray = new ArrayList();
        ArrayList<Integer> holdArray = new ArrayList(nums.length);

//        holdArray holds the value of the initial array nums
        for (int num : nums) {
            holdArray.add(num);         //nums = [3, 3]  target = 6    numArray = [3, ]    holderArray - [3, 3]    returnArray = []
        }

//        check for and add conjugate to the arraylist
        for (int num = 0; num < nums.length; num++) {
            if (!numArray.contains(nums[num])) {
                numArray.add(target - nums[num]);
            } else {
                System.out.println("[" + "]");
                returnArray.add(num);
                returnArray.add(holdArray.indexOf(target - nums[num]));   //index here is 0;
            }
        }

        return returnArray.stream().flatMapToInt(num -> IntStream.of(num)).toArray();
    }


//    moveZeroes problem to move all zeros in an array to the end of the array while still maintaining the order of the non zero elements in the array
//    Sub-optimal approach
    public void moveZeroes(int[] nums) {
        int lastIndexOfNonZero = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                nums[lastIndexOfNonZero] = nums[i];
                lastIndexOfNonZero++;
            }
        }

        for(int i = lastIndexOfNonZero; i < nums.length; i++){
            nums[i] = 0;
        }
      }

 //    moveZeroes problem to move all zeros in an array to the end of the array while still maintaining the order of the non zero elements in the array
//    Optimal approach
    private static void moveZeroes2(int[] nums) {
        for (int lastIndexOfNonZero = 0, current = 0; current < nums.length; current++){
            if (nums[current] != 0){
                int temp = nums[current];       //{0,1,0,3,12}  lastNonZeroIndex = 0, current = 1;  temp = 1,
                nums[current] = nums[lastIndexOfNonZero];
                nums[lastIndexOfNonZero] = temp;
                lastIndexOfNonZero++;
            }
        }
    }

//    containsDuplicate problem to check if a given array contains any duplicate values and return true if it does and false otherwise
    public boolean containsDuplicate(int[] nums) {
//        First of all sort the array elements in ascending order
        Arrays.sort(nums);

        for(int current = 0; current < nums.length - 1; ++current){
            if (nums[current] == nums[current + 1]) return true;

        }
        return false;
    }

//    rotate array problem to rotate a specified number of elements in a specified order.
    public void rotate(int[] nums, int k) {        // [5, 6, 7, 1, 2, 3, 4]
        k %= nums.length;
//        reverse the whole array
        reverse(nums, 0, nums.length - 1);
//        reverse the specified number of arrays
        reverse(nums, 0, k - 1);
//        reverse the rest of the array
        reverse(nums, k, nums.length - 1);
    }
//    Method to reverse the array
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }


    public static String LongestWord(String sen) {
        // code goes here
        String longestWord = "";
        String[] sentenceArray = sen.split(" ");
        Pattern p = Pattern.compile("[^a-z0-9]", Pattern.CASE_INSENSITIVE);

        for(String word : sentenceArray){
            Matcher m = p.matcher(word);
            if(!m.find()){
                if(longestWord.length() < word.length()){
                    longestWord = word;
                }
            }
        }
        return longestWord;
    }


//    Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once.
//    The relative order of the elements should be kept the same.
//    Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums.
//    More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result.
//    It does not matter what you leave beyond the first k elements.
//    Return k after placing the final result in the first k slots of nums.

    public static int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;      //We first check if the array is empty
        int i = 0, j = 1;

//        Traverse through the array
        while(j < nums.length){
            if(nums[j] != nums[i]){     //if the numbers are not the same, move one step forward for i and set that value of i to that of j
                i++;
                nums[i] = nums[j];
            }
            j++;
        }
        return i + 1;
    }

    private static void swap(int[] nums, int start, int end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

        System.out.println(Arrays.toString(nums));
    }
}

