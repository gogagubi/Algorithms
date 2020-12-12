package com.algorithms.general;

public class AvailableConnections {

    /**
     * Algorithm calculates all available connections count among elements.
     * e.g. If we have array [3, 2, 3]. This means that there are
     * 3 elements in first item
     * 2 in second
     * and 3 in third
     * <p>
     * First items can connect to second items 6 times and to third items 9 times. total is 15
     * Second items can connect to third items 6 times
     * Third items don't need to connect nothing because they are connected from first and second items
     * So answer is (First_items_connections + Second_items_connection) = 15 + 6 = 21
     *
     * @param args
     */

    public static void main(String[] args) {
        if (true) {
            AvailableConnections s = new AvailableConnections();
            int[] items = {3, 2, 3};

            System.out.println("Result " + s.countConnections(items));
        }

        if (true) {
            AvailableConnections s = new AvailableConnections();
            int[] items = {3, 2, 2, 1, 1};

            System.out.println("Result " + s.countConnections(items));
        }
    }

    private int countConnections(int[] items) {
        int sum = 0;
        int ans = 0;

        for (int i : items) {
            ans += i * sum;
            sum += i;
        }

        return ans;
    }

}
