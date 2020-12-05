package com.algorithms.greedy;

import java.util.PriorityQueue;
import java.util.Queue;

public class OptimalMergePattern {

    /**
     * OBJECTIVE
     * <p>
     * We are given set of items. Each item contains A[i] elements(assume that they are length of array)
     * Find minimal amount of action is required to merge items with each other
     */

    public static void main(String[] args) {
        if (true) {
            OptimalMergePattern s = new OptimalMergePattern();
            int[] A = {20, 30, 10, 5, 30};

            System.out.println("Result " + s.minAction(A));
        }

        if (true) {
            OptimalMergePattern s = new OptimalMergePattern();
            int[] A = {20};

            System.out.println("Result " + s.minAction(A));
        }

        if (true) {
            OptimalMergePattern s = new OptimalMergePattern();
            int[] A = {20, 30};

            System.out.println("Result " + s.minAction(A));
        }
    }

    private int minAction(int[] A) {
        int ans = 0;
        int N = A.length;
        if (N == 0) return 0;

        Queue<Integer> minHeap = new PriorityQueue<>();
        for (int i : A) minHeap.add(i);

        while (minHeap.size() >= 2) {
            int left = minHeap.poll();
            int right = minHeap.poll();

            int merged = left + right;
            minHeap.add(merged);
            ans += merged;
        }

        return ans;
    }

}
