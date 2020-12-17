package com.algorithms.dynamicProgramming;

import java.util.Arrays;

public class AllPairsShortestPath {

    /**
     * OBJECTIVE
     * <p>
     * You are given undirected graph. Find all pairs shortest path. Use Floyd - Warshall Algorithm to perform this operation
     */

    private static int INF = 1001;

    public static void main(String[] args) {
        if (true) {
            AllPairsShortestPath s = new AllPairsShortestPath();
            int n = 4;
            int[][] graph = {
                    {1, 2, 3},
                    {1, 4, 7},
                    {2, 1, 8},
                    {2, 3, 2},
                    {3, 1, 5},
                    {3, 4, 1},
                    {4, 1, 2}
            };

            int[][] res = s.findAllPath(n, graph);
            for (int[] i : res) {
                System.out.println(Arrays.toString(i));
            }
        }


    }

    private int[][] findAllPath(int n, int[][] graph) {
        int[][] matrix = buildMatrix(n, graph);

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                }
            }
        }

        //copy generated matrix into answer
        int[][] ans = new int[n][n];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                ans[i - 1][j - 1] = matrix[i][j];
            }
        }

        return ans;
    }

    private int[][] buildMatrix(int n, int[][] graph) {
        int[][] matrix = new int[n + 1][n + 1];

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++)
                matrix[i][j] = i == j ? 0 : INF;
        }

        for (int[] i : graph) {
            matrix[i[0]][i[1]] = i[2];
        }

        return matrix;
    }


}
