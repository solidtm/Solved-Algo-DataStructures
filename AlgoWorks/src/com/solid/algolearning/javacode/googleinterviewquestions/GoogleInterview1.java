package com.solid.algolearning.javacode.googleinterviewquestions;

import java.util.Hashtable;

public class GoogleInterview1 {
//  Given two arrays, create a function that lets a user know (true/false) whether these two
//    arrays contain any common items
//    For example:
//    array1 = ['a', 'b', 'c', 'x']
//    array2 = ['z', 'y', 'i']
//    should return false
//    -------------------
//    array1 = ['a', 'b', 'c', 'x']
//    array2 = ['z', 'y', 'x']
//    should return true

    public static void main(String[] args) {
        char[] arr1 = {'a', 'b', 'c', 'x'};
        char[] arr2 = {'z', 'y', 'a'};
        char[] arr3 = {0};
        System.out.println(containsCommonItems(arr1, arr2));
    }

//    Rule 1: Don't just dive into coding!!!

//    Rule 2: Always double check:  Ask questions on the inputs and outputs, and in our case we have:
//    Our 2 inputs - always arrays - no size limits
//    return true or false

//   Rule 3: What is the most important goal of the problem? Do we have space? time? etc...
//   In this case how large is the arrays gonna get?
//   Is our goal here to be more efficient with our programs time complexity or space complexity?
//   Let's say the interviewer is trying to know the most efficient function you can come up with

//   Rule 4: Don't be annoying while asking questions, know you usually have a time limit for your interviews, keep time in mind
//   Rule 5: Start with the naive brute force approach, first thing that comes to mind
//   This solution below is O(n^2) and is not very efficient but is the first thing tht comes to mind
//   You don't need to write this code, you just need to talk about it and how it works in the interview.
//    public static boolean containsCommonItems(char[] arr1, char[] arr2){
//        for(char val1 : arr1){
//            for (char val2 : arr2){
//                if (val1 == val2){
//                    return true;
//                }
//            }
//        }
//        return false;
//    }

//   Tell them the reason why the above brute force approach is not the best:
//   In this case we will have a code that has 2 for loops nested together O(a*b) which can be really slow as input increases

//   Think about how to better the code: Do this in steps
//   What if we had a fxn tht takes the array1 and convert it to a Hashtable containing thus:
//   array1 --> Hashtable{
//   a: true
//   b: true
//   x: true
//   }
//   We can now use this object with our array2 and say: can we check (loop through) each item in this array2 to this object and see if any item exists
//   array2[index] == object.properties()

//   loop through first array1 and create Hashtable where its properties == items in the array
//   loop through second array and check if item in second array exists on created object
//   The above postulated solution will then have a time complexity of O(n + m) which is more efficient.
//    Implementation in code:
//    public static boolean containsCommonItems(char[] arr1, char[] arr2){
////   loop through first array1 and create Hashtable where properties == items in the array
//        Hashtable<Character, Boolean> table = new Hashtable(arr1.length);
//        for (int i = 0; i < arr1.length; i++) {
//            if (!table.contains(arr1[i])){
//                table.put(arr1[i], true);
//            }
//        }
////   loop through second array and check if item in second array exists on created object
//       for (int j = 0; j < arr2.length; j++){
//           if (table.containsKey(arr2[j])){
//               return true;
//           }
//       }
//       return false;
//    }
//   The above postulated solution will then have a time complexity of O(n + m) which is more efficient.

//   The next step is to think about error checks:
//    What if there are repeating values in the array? will the above solution still work?
//    What if there is a number in the array instead of a character?
//    What is we have an empty array index?
//    What if the array is called with just one array?
//    What if the second array is passed as 0?

//    At this point, you now have to ask the interviewer some questions such as:
//    Can we always assume two parameters?
//    You now have to start to discussing with the interviewer how you may be able to break this function and how you may improve it
//    by doing checks such as if statements to make sure that the inputs coming in are the inputs you are expecting.
//    You don't actually need to code it down you can just state them.

//    Using bad and confusing names such as i n j for variables is not good. In the loops it's ok because its conventional.
//    You might wanna talk to the interviewer about if they are okay with those things to show them that you are actually thinking bout them.

//    We test our code/function as we checked above for inputs.
//    This is where you say that you are going to test your code and run some unit tests

//    Finally start talking to the interviewer about the downside of the code:
//    In our code, the downside to the solution is that only booleans and Strings and numbers can be used correctly
//    The way we are using the Hashtable may not work when we may be using an expression instead
//    And we might argue that this our code solution can be a bit  more readable and cleaner way of doing it.
//    For example i can tell the interviewer that i can google specific methods for arrays
//    to see if i can clean up the code and make it more readable.
//    eg using lambda expressions, forEach or streams or chained function calls thus:


    public static boolean containsCommonItems(char[] arr1, char[] arr2){
//   loop through first array1 and create Hashtable where properties == items in the array
        Hashtable<Character, Boolean> table = new Hashtable(arr1.length);
        for (char c : arr1) {
            if (!table.contains(c)) {
                table.put(c, true);
            }
        }
//   loop through second array and check if item in second array exists on created object
        for (char c : arr2) {
            if (table.containsKey(c)){
                return true;
            }
        }
        return false;
    }

//    For space complexity, if we are not creating a new array in memory then we have O(1) constant space
//    In our first loop, we are actually creating another Hashtable collection and that's O(n) space complexity
//    so this solution, although faster in terms of time complexity is heavier in terms of space complexity

//    Never Forget: Modularize your code from the beginning. Separate your code into bits and tiny pieces
//    Eg: we can for our first loop, create a function mapArrayToTable() that handles it, and probably another function compareArrayToTable()
//    to handle the second loop.
//    Tou really don't necessarily have to do this in coding interviews but it's good to talk about them
//    cos if a function is doing too many to many things it will make sense to modularize them.

}
