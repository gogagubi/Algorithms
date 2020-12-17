package com.algorithms.dynamicProgramming;

public class MultiStageGraph {

    /**
     * OBJECTIVE
     * <p>
     * Find shortest path between start and end in directed multistage graph
     */

    private static final int INF = 1001;

    public static void main(String[] args) {
        if (true) {
            MultiStageGraph s = new MultiStageGraph();
            int n = 12;
            int[][] graph = {
                    {1, 2, 9},
                    {1, 3, 7},
                    {1, 4, 3},
                    {1, 5, 2},
                    {2, 6, 4},
                    {2, 7, 2},
                    {2, 8, 1},
                    {3, 6, 2},
                    {3, 7, 7},
                    {4, 8, 11},
                    {5, 7, 11},
                    {5, 8, 8},
                    {6, 9, 6},
                    {6, 10, 5},
                    {7, 10, 3},
                    {8, 10, 5},
                    {8, 11, 6},
                    {9, 12, 4},
                    {10, 12, 2},
                    {11, 12, 5},
            };

            System.out.println("Result " + s.shortestPath(n, graph)); //
        }


    }

    private int shortestPath(int n, int[][] graph) {
        int[][] matrix = buildMatrix(n, graph);
        int[] dp = new int[n + 1]; //Track shortest cost
        int[] path = new int[n + 1]; //Track shortest path
        dp[n] = 0;
        path[n] = 12;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n; j >= 0; j--) {
                if (matrix[i][j] != -1) {
                    if (dp[i] == 0 || dp[j] + matrix[i][j] < dp[i]) {
                        dp[i] = dp[j] + matrix[i][j];
                        path[i] = j;
                    }
                }
            }
        }

        return dp[1];
    }

    private int[][] buildMatrix(int n, int[][] graph) {
        int[][] matrix = new int[n + 1][n + 1];

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                matrix[i][j] = INF;
            }
        }

        for (int[] i : graph) {
            matrix[i[0]][i[1]] = i[2];
        }

        return matrix;
    }


}
