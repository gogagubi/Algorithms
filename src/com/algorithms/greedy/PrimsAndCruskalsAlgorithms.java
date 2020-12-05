package com.algorithms.greedy;

import java.util.*;

public class PrimsAndCruskalsAlgorithms {

    /**
     * OBJECTIVE
     * <p>
     * We are given graph. We should find min cost of spanning tree
     */

    public static void main(String[] args) {
        if (true) {
            PrimsAndCruskalsAlgorithms s = new PrimsAndCruskalsAlgorithms();
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

            System.out.println("Prim's Algorithm Says " + Prims.minCost(n, graph));
        }

        if (true) {
            PrimsAndCruskalsAlgorithms s = new PrimsAndCruskalsAlgorithms();
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

            System.out.println("Kruskal's Algorithm Says " + Kruskals.minCost(n, graph));
        }
    }

    static class Prims {
        //Finds Min cost of Spanning Tree using Prim's Algorithm
        static int minCost(int n, int[][] graph) {
            int ans = 0;
            if (graph.length == 0) return ans;

            int minCost = Integer.MAX_VALUE;
            int[] minEdge = null;

            //find edge with min cost
            for (int[] i : graph) {
                if (i[2] <= minCost) {
                    minCost = i[2];
                    minEdge = i;
                }
            }

            //add initial cost to the answer
            boolean[] visited = new boolean[n + 1];
            visited[minEdge[0]] = true;
            visited[minEdge[1]] = true;
            ans += minEdge[2];

            //build connection map
            Map<Integer, List<int[]>> map = buildMap(graph);

            //continue checking minimum connected edge until we tackle with cycle
            while (minEdge != null) {
                int src = minEdge[0];
                int dest = minEdge[1];

                minCost = Integer.MAX_VALUE;
                minEdge = null;

                //check from left side
                for (int[] i : map.get(src)) {
                    if (!visited[i[1]] && i[2] < minCost) {
                        minCost = i[2];
                        minEdge = i;
                    }
                }

                //check from right side
                for (int[] i : map.get(dest)) {
                    if (!visited[i[1]] && i[2] < minCost) {
                        minCost = i[2];
                        minEdge = i;
                    }
                }

                if (minEdge != null) {
                    visited[minEdge[0]] = true;
                    visited[minEdge[1]] = true;
                    ans += minEdge[2];
                }
            }

            return ans;
        }

        static Map<Integer, List<int[]>> buildMap(int[][] graph) {
            Map<Integer, List<int[]>> map = new HashMap<>();
            for (int[] i : graph) {
                List<int[]> l = map.getOrDefault(i[0], new ArrayList<>());
                l.add(new int[]{i[0], i[1], i[2]});
                map.put(i[0], l);

                List<int[]> s = map.getOrDefault(i[1], new ArrayList<>());
                s.add(new int[]{i[1], i[0], i[2]});
                map.put(i[1], s);
            }

            return map;
        }
    }


    static class Kruskals {
        //Finds Min cost of Spanning Tree using Prim's Algorithm
        static int minCost(int n, int[][] graph) {
            int ans = 0;

            Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[2] - b[2]);
            for (int[] i : graph) minHeap.add(i);

            List<int[]> edges = new ArrayList<>();

            while (!minHeap.isEmpty()) {
                int[] minEdge = minHeap.poll();
                if (!hasCycle(n, edges, minEdge)) {
                    ans += minEdge[2];
                    edges.add(minEdge);
                }
            }

            return ans;
        }

        static boolean hasCycle(int n, List<int[]> edges, int[] edge) {
            if (edges.size() == 0) return false;

            Map<Integer, List<Integer>> map = new HashMap<>();

            List<Integer> l = map.getOrDefault(edge[0], new ArrayList<>());
            l.add(edge[1]);
            map.put(edge[0], l);

            List<Integer> r = map.getOrDefault(edge[1], new ArrayList<>());
            r.add(edge[0]);
            map.put(edge[1], r);

            for (int[] i : edges) {
                l = map.getOrDefault(i[0], new ArrayList<>());
                l.add(i[1]);
                map.put(i[0], l);

                r = map.getOrDefault(i[1], new ArrayList<>());
                r.add(i[0]);
                map.put(i[1], r);
            }

            return dfs(edge[0], 0, new boolean[n + 1], map);
        }

        static boolean dfs(int key, int exKey, boolean[] visited, Map<Integer, List<Integer>> map) {
            if (visited[key]) return true;
            visited[key] = true;

            for (int node : map.get(key)) {
                if (node != exKey) {
                    boolean res = dfs(node, key, visited, map);
                    if (res) return res;
                }
            }

            return false;
        }
    }


}
