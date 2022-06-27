package com.solid.algolearning.javacode.data_structures.strings;

public class AddBinary {
    public static void main(String[] args) {
        System.out.println(addBinary("1010", "1011"));
    }

    public static String addBinary(String a, String b) {
        if(a.isEmpty() && b.isEmpty()){
            return "";
        }

        int n = a.length() - 1;
        int m = b.length() - 1;

        if(n + 1 == 1 && m + 1 == 1 && a.charAt(n) == '0' && b.charAt(m) == '0') {
            return "0";
        }

        int f, s;
        int c1 = n, c2 = m;
        int carry = 0;
        StringBuilder sb = new StringBuilder();

        while(c1 >= 0 || c2 >= 0){
            int sum;

            if(a.isEmpty() || b.isEmpty()){
                if(a.isEmpty()) return b;
                else return a;
            }else if(c1 < 0 || c2 < 0){
                if(c1 < 0){
                    s = Integer.parseInt(Character.toString(b.charAt(c2)));
                    sum = s + carry;
                }else{
                    f = Integer.parseInt(Character.toString(a.charAt(c1)));
                    sum = f + carry;
                }
            }else{
                f = Integer.parseInt(Character.toString(a.charAt(c1)));
                s = Integer.parseInt(Character.toString(b.charAt(c2)));

                sum = f + s + carry;
            }

           if(sum == 0){
               sb.append(sum); // => 10101
               carry = 0;
           }else if(sum == 1){
                sb.append(sum); // => 10101
                carry = 0;
            }else if(sum == 2){
                sb.append("0");
                carry = 1;
            }else if(sum == 3){
                sb.append("1");
                carry = 1;
            }

            c1--;
            c2--;
        }

        if(carry > 0){
            sb.append("1");
        }

        return sb.reverse().toString();
    }
}
