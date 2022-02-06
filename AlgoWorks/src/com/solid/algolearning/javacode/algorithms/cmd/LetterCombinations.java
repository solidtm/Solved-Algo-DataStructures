package com.solid.algolearning.javacode.algorithms.cmd;

import java.util.*;
public class LetterCombinations {
    public static List<String> letterCombinations(String digits) {
        //HashMap -> each number to the letter reps
        //O(26) // 2 -> a, b, c; 3 -> d, e, f

//        if(digits.equals("")) return new ArrayList<>();
//
//        List<String[]> stringList = new ArrayList<>();
//        List<String> result = new ArrayList<>();
//        Map<Character, String> numberMap = new HashMap<>();
//        numberMap.put('2', "abc");
//        numberMap.put('3', "def");
//        numberMap.put('4', "ghi");
//        numberMap.put('5', "jkl");
//        numberMap.put('6', "mno");
//        numberMap.put('7', "pqrs");
//        numberMap.put('8', "tuv");
//        numberMap.put('9', "wxyz");
//
//
//        for(int i = 0; i < digits.length(); i++){ //23     O(d) -> O(n)
//            char c = digits.charAt(i);
//            String[] stringArr = numberMap.get(c).split("");
//            stringList.add(stringArr);
//        }
//
//        //arraylist: [[a, b, c], [d, e, f]]
//        //loop through the arraylist and make possible combinations
//        StringBuilder sb = new StringBuilder(); //O(1)
//
//        for(int i = 0; i < stringList.size() - 1; i++){ //O(s)
//            String[] arr1 = stringList.get(i);
//
//            for(int j = 1; j < stringList.size(); j++){ //O(s)
//                String[] arr2 = stringList.get(j);
//
//                int start1 = 0;
//                int start2 = 0;
//
//                while(start1 < arr1.length){  //O(4)
//                    while (start2 < arr2.length){ //O(4)    -> O(s^2) + O(n) -> O(n + s^2)quadratic
//                        sb.append(arr1[start1]);
//                        sb.append(arr2[start2]);
//                        result.add(new String(sb));
//                        sb = new StringBuilder();
//                        start2++;
//                    }
//                    start2 = 0;
//                    start1++;
//                }
//            }
//        }
//
//        return result;

        List<String> result = new ArrayList<>();
        String map[] = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        helper(result, map, 0, new StringBuilder(), digits);
        return result;
    }

    static void helper(List<String> result, String[] map, int index, StringBuilder sb, String digits)
    {
        //base condt.
        if(digits.length() == 0) return;   // this means that we have no digits to process

        if(index == digits.length())     // we have gotten values to add to result list
        {
            result.add(sb.toString());
            return;
        }

        //body
        int num = digits.charAt(index) - '0';
        String s = map[num];

        for(int i=0; i<s.length(); i++)
        {
            sb.append(s.charAt(i));
            helper(result,map,index+1,sb,digits);   // recursively call the helper function to aend and remove values appropriately
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
        System.out.println(letterCombinations("54"));
        System.out.println(letterCombinations("76"));
        System.out.println(letterCombinations("432"));
    }
}
