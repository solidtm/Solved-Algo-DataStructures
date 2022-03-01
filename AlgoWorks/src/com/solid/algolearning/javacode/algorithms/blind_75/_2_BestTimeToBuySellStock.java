package com.solid.algolearning.javacode.algorithms.blind_75;
//leetcode proble 121
public class _2_BestTimeToBuySellStock {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
    }

    public static int maxProfit(int[] prices) {
        int left = 0;
        int right = left + 1;
        int maxProfit = 0;

        while(right < prices.length){
            if(prices[left] < prices[right]){  //this is where we know we made a valuable profit
                int profit = prices[right] - prices[left];
                maxProfit =  Math.max(maxProfit, profit);
            }else left = right;

            right++;
        }

        return maxProfit;
    }
}
