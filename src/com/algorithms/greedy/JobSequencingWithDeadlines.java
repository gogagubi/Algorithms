package com.algorithms.greedy;


public class JobSequencingWithDeadlines {

    /**
     * OBJECTIVE
     * <p>
     * Find maximum profit that can be made in the given deadlines
     */

    public static void main(String[] args) {
        if (true) {
            JobSequencingWithDeadlines s = new JobSequencingWithDeadlines();
            int[] profits = {35, 30, 25, 20, 15, 12, 5};
            int[] deadlines = {3, 4, 4, 2, 3, 1, 2};

            System.out.println("Result " + s.maxProfit(profits, deadlines));
        }

        if (true) {
            JobSequencingWithDeadlines s = new JobSequencingWithDeadlines();
            int[] profits = {20, 15, 10, 5, 1};
            int[] deadlines = {2, 2, 1, 3, 3};

            System.out.println("Result " + s.maxProfit(profits, deadlines));
        }
    }

    private int maxProfit(int[] profits, int[] deadlines) {
        int N = profits.length;
        int ans = 0;
        int max = 0;
        int counter = 0;

        for (int i : deadlines) max = Math.max(max, i);
        boolean[] used = new boolean[max + 1];
        int L = used.length;

        for (int i = 0; i < N; i++) {
            int profit = profits[i];
            int deadline = deadlines[i];

            while (deadline > 1 && used[deadline]) {
                deadline--;
            }

            if (!used[deadline]) {
                ans += profit;
                used[deadline] = true;

                if (++counter == L) break;
            }
        }

        return ans;
    }

}
