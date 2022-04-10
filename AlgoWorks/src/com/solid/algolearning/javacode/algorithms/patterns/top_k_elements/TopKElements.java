package com.solid.algolearning.javacode.algorithms.patterns.top_k_elements;

//Given an integer array nums and an integer k,
// return the k most frequent elements. You may return the answer in any order.
//
//        Example 1:
//        Input: nums = [1,1,1,2,2,3], k = 2
//        Output: [1,2]

//        Example 2:
//        Input: nums = [1], k = 1
//        Output: [1]


import java.util.*;
public class TopKElements {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i : map.keySet()) {
            pq.offer(new int[]{map.get(i), i});
            if (pq.size() > k) {
                pq.poll();
            }
        }


        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = pq.poll()[1];
        }

        return ans;
    }
}
