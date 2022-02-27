package com.solid.algolearning.javacode.algorithms.patterns.bitwise_xor;

//This is leetcode question number: 832
public class FlipImage {
    public int[][] flipAndInvertImage(int[][] image) {
        //We can first reverse the array adn then take the 1s compliment and that si totally okay.

        //But also we can apply bitwise xor in the problem thus:
        //if we xor any number with 1, we get the inverse of that number
        //so what we can do is: while we are reversing the numbers in the array
        // we can apply xor immediately.

       for(int[] row : image){
           //reverse this array
           for (int i = 0; i < (image[0].length + 1) / 2; i++) {
               //swap
               int temp = row[i] ^ 1;
               row[i] = row[image[0].length - i - 1] ^ 1;
               row[image[0].length] = temp;
           }
       }

       return image;
    }
}
