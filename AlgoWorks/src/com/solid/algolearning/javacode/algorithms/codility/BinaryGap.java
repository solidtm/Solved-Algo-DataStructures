package com.solid.algolearning.javacode.algorithms.codility;

public class BinaryGap {

    public static int solution(int N) {
        String binaryString = Integer.toBinaryString(N);
        boolean started = false;
        int counter = 0, maxCount = 0;

        for(int i = 0; i < binaryString.length(); i++){
            String c = binaryString.substring(i, i + 1);

            if (c.equals("1")){
                if (started){
                    if (counter > maxCount){
                        maxCount = counter;
                    }
                }
                counter = 0;
                started = true;
            }

            if (c.equals("0")){
                counter++;
            }
        }

        return maxCount;
    }
    public static void main(String[] args) {
        System.out.println(solution(9));;
    }
}
