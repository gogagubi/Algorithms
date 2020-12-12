package com.algorithms.greedy;

import java.util.*;

public class DijkstraAlgorithm {

    /**
     * OBJECTIVE
     * <p>
     * We should find shortest path in the undirected graph. Find shortest distance to each node to each node
     */

    public static void main(String[] args) {
        if (true) {
            DijkstraAlgorithm s = new DijkstraAlgorithm();
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

            System.out.println("Result " + s.shortestPath(n, start, graph)); //expected 9
        }

        if (true) {
            DijkstraAlgorithm s = new DijkstraAlgorithm();
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

            System.out.println("Result " + s.shortestPath(n, start, graph)); //expected 45
        }


        if (true) {
            DijkstraAlgorithm s = new DijkstraAlgorithm();
            int n = 7;
            int start = 1;
            int[][] graph = {
                    {1, 2, 28},
                    {1, 6, 10},
                    {2, 3, 16},
                    {2, 7, 14},
                    {3, 4, 12},
                    {4, 5, 22},
                    {4, 7, 18},
                    {5, 6, 25},
                    {5, 7, 24}
            };

            System.out.println("Result " + s.shortestPath(n, start, graph)); //expected 45
        }
    }

    private Map<Integer, Integer> shortestPath(int n, int start, int[][] graph) {
        //build map for directed graph
        Map<Integer, List<int[]>> map = buildMap(graph);

        Map<Integer, Integer> values = new HashMap<>();
        boolean[] selected = new boolean[n + 1];

        Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        minHeap.add(new int[]{start, 0});

        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            if (!map.containsKey(curr[0])) continue;

            if (selected[curr[0]]) continue;
            selected[curr[0]] = true;

            for (int[] i : map.get(curr[0])) {
                int val = curr[1] + i[1];
                if (values.containsKey(i[0])) val = Math.min(val, values.get(i[0]));
                values.put(i[0], val);

                if (!selected[i[0]]) {
                    minHeap.add(new int[]{i[0], val});
                }
            }
        }

        Map<Integer, Integer> ans = new HashMap<>();
        for (int key : values.keySet()) {
            if (key != start) {
                ans.put(key, values.get(key));
            }
        }

        return ans;
    }

    private Map<Integer, List<int[]>> buildMap(int[][] graph) {
        Map<Integer, List<int[]>> map = new HashMap<>();

        for (int[] i : graph) {
            List<int[]> l = map.getOrDefault(i[0], new ArrayList<>());
            l.add(new int[]{i[1], i[2]});
            map.put(i[0], l);

            List<int[]> r = map.getOrDefault(i[1], new ArrayList<>());
            r.add(new int[]{i[0], i[2]});
            map.put(i[1], r);
        }

        return map;
    }

}
