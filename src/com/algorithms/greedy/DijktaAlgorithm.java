package com.algorithms.greedy;

import java.util.*;

public class DijktaAlgorithm {

    /**
     * OBJECTIVE
     * <p>
     * We should find shortest path in the directed graph
     */

    public static void main(String[] args) {
        if (true) {
            DijktaAlgorithm s = new DijktaAlgorithm();
            int n = 6;
            int start = 1;
            int[][] graph = {
                    {1, 2, 50},
                    {1, 3, 45},
                    {1, 4, 10},
                    {2, 3, 10},
                    {3, 5, 30},
                    {4, 1, 10},
                    {4, 5, 15},
                    {5, 2, 20},
                    {5, 3, 35},
                    {6, 5, 3},
            };

            System.out.println("Prim's Algorithm Says " + s.shortestPath(n, start, graph));
        }

    }

    private int shortestPath(int n, int start, int[][] graph) {
        int ans = 0;

        //build map for directed graph
        Map<Integer, List<int[]>> map = buildMap(graph);

        Map<Integer, Integer> paths = new HashMap<>();
        Set<Integer> selected = new HashSet<>();

        selected.add(start);

        return ans;
    }

    private int dfs(){
        return 0;
    }

    private Map<Integer, List<int[]>> buildMap(int[][] graph) {
        Map<Integer, List<int[]>> map = new HashMap<>();


        for (int[] i : graph) {
            List<int[]> l = map.getOrDefault(i[0], new ArrayList<>());
            l.add(i);
            map.put(i[0], l);
        }

        return map;
    }

}
