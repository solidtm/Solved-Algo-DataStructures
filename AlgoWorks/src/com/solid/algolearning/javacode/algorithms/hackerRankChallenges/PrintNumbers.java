package com.solid.algolearning.javacode.algorithms.hackerRankChallenges;

import java.util.*;

public class PrintNumbers {


    public static void printNumbers(int N){
        if(N % 2 != 0){
            System.out.println("Wierd");
        }else if(N % 2 == 0 && (N >=2 && N <=5)){
            System.out.println("Not Wierd");
        }else if(N % 2 == 0 && (N >=6 && N <=20)){
            System.out.println("Wierd");
        }else if(N % 2 == 0 && N > 20 ){
            System.out.println("Not Wierd");
        }
    }

    public static List<Integer> rotateArray(List<Integer> arr, int start, int end){
//        int extra = 0; [1 2 3 4 5] -> [5 2 3 4 1]
        end = arr.size() - 1;
        for (int i = 0; i < end; i++){
            System.out.println("Switching " + arr.get(i) + " and -" + arr.get(end));
            Integer temp = arr.get(i);
            arr.set(i, arr.get(end));
            arr.set(end, temp);
            end--;
        }
//        while(start <= end){
//            System.out.println("Switching " + arr.get(start) + " and " + arr.get(end));
//            Integer temp = arr.get(start);
//            arr.set(start, arr.get(end));
//            arr.set(end, temp);
//
//            start++;
//            end--;
//        }

//        if(end >= arr.size()){
//            extra = end - (arr.size() - 1);
//        }

        return arr;
    }


//    public static String findDay(int month, int day, int year) {
//        Calendar cal = Calendar.getInstance();
//        Date date = new Date(year, month, day);
//    }

    public static void main(String []arg){
        List<Integer> arr = new ArrayList<>(5);
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);


        System.out.println(rotateArray(arr, 0, 2));
//        System.out.println(findDay());
//        Scanner in = new Scanner(System.in);
//        int t=in.nextInt();
//        for(int i=0;i<t;i++){
//            int a = in.nextInt();
//            int b = in.nextInt();
//            int n = in.nextInt();
//            int result = a, count = 0;
//            while(count < n){
//                result += (Math.pow(2.0, count) * b);
//                System.out.print(result + " ");
//                count++;
//            }
//        }
//        in.close();
    }
}
