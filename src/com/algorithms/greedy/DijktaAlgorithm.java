package com.algorithms.greedy;

import java.util.*;

public class DijktaAlgorithm {

    /**
     * OBJECTIVE
     * <p>
     * We are given graph. We should find min cost of spanning tree
     */

    public static void main(String[] args) {
        if (true) {
            DijktaAlgorithm s = new DijktaAlgorithm();
            int n = 7;
            int[][] graph = {
                    {1, 2, 28},
                    {1, 6, 10},
                    {2, 3, 16},
                    {2, 7, 14},
                    {3, 4, 12},
                    {4, 5, 22},
                    {4, 7, 18},
                    {5, 6, 25},
                    {5, 7, 24},
            };

            System.out.println("Prim's Algorithm Says " + s.shortestPath(n, graph));
        }

    }

    static int shortestPath(int n, int[][] graph) {
        int ans = 0;

        return ans;
    }


}
