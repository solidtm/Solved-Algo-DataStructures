package com.solid.algolearning.javacode.algorithms.recursion.strings;

//Given a string, remove all a in the string
public class Stream {
    public static void main(String[] args) {
        skip("", "baccdah");
        System.out.println(skip2("baccdah"));
        System.out.println(skipApple("bacapplecdah"));
        System.out.println(skipAppNotApple("bacapplecdah"));
    }

    static void skip(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);

        if (ch == 'a'){
            skip(p, up.substring(1));
        }else {
            skip(p + ch, up.substring(1));
        }
    }

    static String skip2( String up){
        if(up.isEmpty()){
            return "";
        }

        char ch = up.charAt(0);

        if (ch == 'a'){
            return skip2(up.substring(1));
        }else {
          return ch + skip2(up.substring(1));
        }
    }

    //Some questions may require you to skip an entire substring in a given string thus:
    static String skipApple( String up){
        if(up.isEmpty()){
            return "";
        }

        if (up.startsWith("apple")){
            return skipApple(up.substring(5));
        }else {
            return up.charAt(0) + skipApple(up.substring(1));
        }
    }

    //Some questions may require you to skip an entire substring in a given string thus:
    static String skipAppNotApple( String up){
        if(up.isEmpty()){
            return "";
        }

        if (up.startsWith("app") && !up.startsWith("apple")){
            return skipAppNotApple(up.substring(3));
        }else {
            return up.charAt(0) + skipAppNotApple(up.substring(1));
        }
    }
}
