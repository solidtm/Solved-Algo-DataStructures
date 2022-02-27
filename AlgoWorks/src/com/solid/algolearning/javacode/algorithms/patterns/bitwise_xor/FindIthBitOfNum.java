package com.solid.algolearning.javacode.algorithms.patterns.bitwise_xor;
//Given a number, find it's ith bit
public class FindIthBitOfNum {
    public static void main(String[] args) {
        int num = 86;
        System.out.println(findIthBit(num, 5));
        System.out.println(setIthBit(num, 5));
        System.out.println(resetIthBit(num, 5));
    }

    //here we know that if we just &(AND) any number with 1, we get back the number
    //the same way, we will & the ith bit with 1 and get the ith bit
    //to get the mask to use for the & with the ith bit, we use left shift so that the
    // 1 will call into the ith bit after t
    private static int findIthBit(int num, int i) {
        return (num & (1 << i - 1));
    }

    //similar question can be to set the ith bit of the number ie(if ith bit is 0 make it 1 and vice versa)
    //here we know that if we OR a number with 1, it will give me 1
    //so we create a mask in the same way as above and do the bitwise operation
    private static int setIthBit(int num, int i) {
        return (num | (1 << i - 1));
    }

    //similar question can be to reset the ith bit of the number ie(if ith bit is 1 make it 0 and  if it is 0 still make it 0)
    //here we know that if we AND a number with 1, it will give me 1
    //but if we AND a number with 0, we get the opposite of that number
    // we do this AND with 0 by getting the mask and taking its one's complement
    //so we create a mask in the same way as above and do the bitwise operation
    private static int resetIthBit(int num, int i) {
        int mask = ~(1 << i - 1);
        return (num & mask);
    }
}
