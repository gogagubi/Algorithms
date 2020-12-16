package com.algorithms.dynamicProgramming;

import java.util.Arrays;

public class MultiStageGraph {

    /**
     * OBJECTIVE
     * <p>
     * Find shortest path between start and end in directed multistage graph
     */


    public static void main(String[] args) {
        if (true) {
            MultiStageGraph s = new MultiStageGraph();
            int n = 12;
            int[][] graph = {
                    {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
                    {-1, -1, 9, 7, 3, 2, -1, -1, -1, -1, -1, -1, -1},
                    {-1, -1, -1, -1, -1, -1, 4, 2, 1, -1, -1, -1, -1},
                    {-1, -1, -1, -1, -1, -1, 2, 7, -1, -1, -1, -1, -1},
                    {-1, -1, -1, -1, -1, -1, -1, -1, 11, -1, -1, -1, -1},
                    {-1, -1, -1, -1, -1, -1, -1, 11, 8, -1, -1, -1, -1},
                    {-1, -1, -1, -1, -1, -1, -1, -1, -1, 6, 5, -1, -1},
                    {-1, -1, -1, -1, -1, -1, -1, -1, -1, 4, 3, -1, -1},
                    {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 5, 6, -1},
                    {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 4},
                    {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 2},
                    {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 5},
                    {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1}
            };

            System.out.println("Result " + s.shortestPath(n, graph)); //
        }


    }

    private int shortestPath(int n, int[][] graph) {
        int[] dp = new int[n + 1]; //Track shortest cost
        int[] path = new int[n + 1]; //Track shortest path
        dp[n] = 0;
        path[n] = 12;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n; j >= 0; j--) {
                if (graph[i][j] != -1) {
                    if (dp[i] == 0 || dp[j] + graph[i][j] < dp[i]) {
                        dp[i] = dp[j] + graph[i][j];
                        path[i] = j;
                    }
                }
            }
        }

        return dp[1];
    }


}
