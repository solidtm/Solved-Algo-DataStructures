package com.solid.algolearning.javacode.data_structures.strings;

//Quetion:
//Have the function EquivalentKeypresses(strArr) read the array of strings stored in strArr which will contain 2 strings
//        representing two comma separated lists of keypresses.
//        Your goal is to return the string true if the keypresses produce the same printable string and the string false if they do not.
//        A keypress can be either a printable character or a backspace represented by -B.
//        You can produce a printable string from such a string of keypresses by having backspaces erase one preceding character.

import java.util.*;
public class EquivalentKeyPresses {
    public static void main(String[] args) {
        System.out.println(EquivalentKeypresses(new String[]{"p,o,i,n,-B,t", "-B,p,o,i,t"}));
        System.out.println(EquivalentKeypresses(new String[]{"q,w,e,r,t,y", "-B,-B,q,w,w,-B,e,r,t,y"}));
        System.out.println(EquivalentKeypresses(new String[]{"", "-B,-B,-B"}));
        System.out.println(EquivalentKeypresses(new String[]{"s,t,r,e,e,t", "-B,s,s,-B,t,r,e,e,t"}));
    }

    public static String EquivalentKeypresses(String[] strArr) {

        String first = strArr[0], second = strArr[1];
        Stack<Character> charStack1 = new Stack<>();
        Stack<Character> charStack2 = new Stack<>();


        for(int i = 0; i < first.length(); i++){
            char ch = first.charAt(i);

            if(ch == 'B'){
                charStack1.pop();
                if(!charStack1.isEmpty()){
                    charStack1.pop();
                }
            }else if(ch == '-' || Character.isLetter(ch)) {
                charStack1.push(ch);
            }
        }

        for(int i = 0; i < second.length(); i++){
            char ch = second.charAt(i);

            if(ch == 'B'){
                charStack2.pop();
                if(!charStack2.isEmpty()){
                    charStack2.pop();
                }
            }else if(ch == '-' || Character.isLetter(ch)){
                charStack2.push(ch);
            }
        }

        while(!charStack1.isEmpty() || !charStack2.isEmpty()){
            if(charStack1.isEmpty() || charStack2.isEmpty()) return "false";

            char one = charStack1.pop();
            char two = charStack2.pop();

            if(one != two) return "false";
        }

        return "true";
    }
}
