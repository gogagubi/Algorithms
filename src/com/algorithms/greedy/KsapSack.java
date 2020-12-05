package com.algorithms.greedy;

import java.util.PriorityQueue;
import java.util.Queue;

public class KsapSack {

    /**
     * OBJECTIVE
     * <p>
     * We are bag which size is M unit(assume kg). Find the maximum price of objects
     * that can carry in the given bag
     */

    public static void main(String[] args) {
        if (true) {
            KsapSack s = new KsapSack();
            int M = 15;
            int[] prices = {10, 5, 15, 7, 6, 18, 3};
            int[] weights = {2, 3, 5, 7, 1, 4, 1};

            System.out.println("Result " + s.maxPrice(M, prices, weights));
        }
    }

    class Pair {
        double unitPrice;
        int pieces;

        Pair(double unitPrice, int pieces) {
            this.unitPrice = unitPrice;
            this.pieces = pieces;
        }
    }

    private double maxPrice(int M, int[] prices, int[] weights) {
        double ans = 0;
        int N = prices.length;

        Queue<Pair> unitPrices = new PriorityQueue<>((a, b) -> a.unitPrice < b.unitPrice ? 1 : -1);
        for (int i = 0; i < N; i++) {
            unitPrices.add(new Pair(prices[i] / (double) weights[i], weights[i]));
        }

        while (!unitPrices.isEmpty() && M > 0) {
            Pair currPair = unitPrices.poll();
            int minPieces = Math.min(currPair.pieces, M);

            ans += minPieces * currPair.unitPrice;
            M -= minPieces;
        }

        return ans;
    }

}
