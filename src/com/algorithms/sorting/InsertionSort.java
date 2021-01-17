package com.algorithms.sorting;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        if (true) {
            InsertionSort c = new InsertionSort();
            int[] a = {1, 2, 3};

            c.insertionSort(a);
            System.out.println(Arrays.toString(a));
        }

        if (true) {
            InsertionSort c = new InsertionSort();
            int[] a = {3, 2, 1};

            c.insertionSort(a);
            System.out.println(Arrays.toString(a));
        }

        if (true) {
            InsertionSort c = new InsertionSort();
            int[] a = {4, 5, 2, 8, 3, 6};

            c.insertionSort(a);
            System.out.println(Arrays.toString(a));
        }
    }

    private void insertionSort(int[] a) {
        int n = a.length;

        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0; j--) {
                if (a[j] < a[j - 1]) swap(j, j - 1, a);
                else break;
            }
        }
    }

    private void swap(int l, int r, int[] a) {
        int tmp = a[l];
        a[l] = a[r];
        a[r] = tmp;
    }
}
