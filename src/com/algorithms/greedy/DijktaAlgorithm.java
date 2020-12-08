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

            System.out.println("Result " + s.shortestPath(n, start, graph)); //expected 9
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

            System.out.println("Result " + s.shortestPath(n, start, graph)); //expected 45
        }
    }

    private int shortestPath(int n, int start, int[][] graph) {
        //build map for directed graph
        Map<Integer, List<int[]>> map = buildMap(graph);

        Map<Integer, Integer> values = new HashMap<>();
        boolean[] selected = new boolean[n + 1];

        Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        minHeap.add(new int[]{start, 0});

        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            if(!map.containsKey(curr[0])) return values.get(curr[0]);

            if (selected[curr[0]]) continue;
            selected[curr[0]] = true;

            int routes = 0;
            for (int[] i : map.get(curr[0])) {
                int val = curr[1] + i[1];
                if (values.containsKey(i[0])) val = Math.min(val, values.get(i[0]));
                values.put(i[0], val);

                if(!selected[i[0]]) {
                    minHeap.add(new int[]{i[0], val});
                    routes ++;
                }
            }

            if(routes == 0){
                return curr[1];
            }
        }

        return 0;
    }

    private Map<Integer, List<int[]>> buildMap(int[][] graph) {
        Map<Integer, List<int[]>> map = new HashMap<>();

        for (int[] i : graph) {
            List<int[]> l = map.getOrDefault(i[0], new ArrayList<>());
            l.add(new int[]{i[1], i[2]});
            map.put(i[0], l);
        }

        return map;
    }

}
