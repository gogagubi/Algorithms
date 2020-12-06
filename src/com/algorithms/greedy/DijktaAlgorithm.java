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
                    {1, 2, 2},
                    {1, 3, 4},
                    {2, 3, 1},
                    {2, 4, 7},
                    {3, 5, 3},
                    {4, 6, 1},
                    {5, 4, 2},
                    {5, 6, 5}
            };

            System.out.println("Result " + s.shortestPath(n, start, graph));
        }

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

            System.out.println("Result " + s.shortestPath(n, start, graph));
        }
    }

    private int shortestPath(int n, int start, int[][] graph) {
        //build map for directed graph
        Map<Integer, List<int[]>> map = buildMap(graph);

        Map<Integer, Integer> values = new HashMap<>();
        Set<Integer> selected = new HashSet<>();
        selected.add(start);

        return dfs(start, 0, map, values, selected);
    }

    private int dfs(int key, int val, Map<Integer, List<int[]>> map, Map<Integer, Integer> values, Set<Integer> selected) {
        int[] minEdge = null;
        int minCost = Integer.MAX_VALUE;
        if (!map.containsKey(key)) return val;

        for (int[] i : map.get(key)) {
            if (!selected.contains(i[1])) {
                int potentialMin = Math.min(val + i[2], values.getOrDefault(i[1], Integer.MAX_VALUE));
                if (potentialMin < minCost) {
                    minEdge = i;
                    minCost = potentialMin;
                }

                values.put(i[1], potentialMin);
            }
        }

        if (minEdge != null) {
            selected.add(minEdge[1]);
            val = dfs(minEdge[1], minCost, map, values, selected);
        }

        return val;
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
