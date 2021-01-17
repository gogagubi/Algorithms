package com.algorithms.sorting;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        if (true) {
            BubbleSort c = new BubbleSort();
            int[] a = {1, 2, 3};

            c.bubbleSort(a);
            System.out.println(Arrays.toString(a));
        }

        if (true) {
            BubbleSort c = new BubbleSort();
            int[] a = {3, 2, 1};

            c.bubbleSort(a);
            System.out.println(Arrays.toString(a));
        }

        if (true) {
            BubbleSort c = new BubbleSort();
            int[] a = {4, 5, 2, 8, 3, 6};

            c.bubbleSort(a);
            System.out.println(Arrays.toString(a));
        }
    }

    private void bubbleSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            boolean swapped = false;
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    swap(j, j + 1, a);
                    swapped = true;
                }
            }

            if(!swapped) break;
        }
    }

    private void swap(int l, int r, int[] a) {
        int tmp = a[l];
        a[l] = a[r];
        a[r] = tmp;
    }
}
