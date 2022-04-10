package com.solid.algolearning.javacode.algorithms.prep_problems;


import java.util.*;

public class DecodePassword {
    public static void main(String[] args) {
//        System.out.println(decryptPassword("1Bl*Kg*u0"));
//        System.out.println(decryptPassword("51Pa*0Lp*0e"));
//        System.out.println(decryptPassword("6UDTy*n0Hm*Bq*Bp*ur"));   //"poTaTo" pT0*Ta*o
//        System.out.println(decryptPassword("487RESx*Fp*d0Xu*kr0m0Du"));
        System.out.println(decryptPassword("T5Wm*sh0Vm*TIDAJ0BHWn*Ye*Lp*Bp*MZd"));
//        System.out.println(decryptPassword("pTo*Ta*o"));
    }

    public static String decryptPassword(String s) {
        if (s.isEmpty()) return null;

        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            boolean nextIsUpperCase = i + 1 < s.length()
                    && s.charAt(i + 1) == Character.toUpperCase(s.charAt(i + 1))
                    && Character.isLetter(s.charAt(i + 1));
            if (ch == '*') {
                char val1 = stack.pop();
                char val2 = stack.pop();

                sb.append(val1).append(val2);
            } else if (ch == '0') {
                while (!Character.isDigit(stack.peek())) {
                    sb.append(stack.pop());
                }
                char digit = stack.pop();
                sb.append(digit);
            } else if ((Character.isLetter(ch) && ch != Character.toUpperCase(ch) && nextIsUpperCase)
                       || (Character.isLetter(ch) && ch != Character.toLowerCase(ch) && nextIsUpperCase)) {
                sb.append(ch);
            } else {
                stack.add(ch);
            }
        }

        while (stack.size() > 0) {
            sb.append(stack.pop());
        }


        return sb.toString();
    }


//    function decryptPassword(s) {
//   / /remove *
//                let find= '*';
//        let replace = '';
//        while( s.indexOf(find) > -1)
//        {
//            var s = s.replace(find, replace);
//        }
//        //replace the number
//        let i=0, r=s.slice(0,2);
//        while( s.indexOf('0') > -1)
//        {
//            var s = s.replace('0', r[i]);
//            r=r[i+1]
//            console.log(s)
//        }
//        //reverse letters back
//        s = s.slice(2,9);
//        console.log(s)
//        s=s.split('', 2).reverse().join("");
//
//        console.log(s)
//    }
//    var s="51Pa*0Lp*0e"
//    decryptPassword(s)


//    [illegal, legal, legal, legal, legal, legal, legal, legal, legal, legal, legal, legal, legal, legal, illegal, illegal, legal, legal, illegal, legal, legal, legal, legal, illegal, legal, illegal, legal, legal, legal, legal, legal, illegal, illegal, legal, legal, legal, legal, illegal, legal, illegal, illegal, legal, legal, legal, legal, legal, legal, legal, legal, legal]
//            [34, 60, 10, 81, 28, 2, 49, 64, 59, 61, 85, 82, 77, 14, 81, 6, 76, 37, 86, 99, 11, 92, 85, 95, 78, 13, 57, 59, 46, 93, 38, 35, 22, 68, 92, 17, 61, 34, 53, 87, 57, 89, 32, 74, 70, 42, 28, 35, 24, 14]
//            7
}
