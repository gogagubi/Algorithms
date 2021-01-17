package com.algorithms.sorting;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        if (true) {
            QuickSort c = new QuickSort();
            int[] a = {1, 2, 3};

            c.quickSort(a);
            System.out.println(Arrays.toString(a));
        }

        if (true) {
            QuickSort c = new QuickSort();
            int[] a = {3, 2, 1};

            c.quickSort(a);
            System.out.println(Arrays.toString(a));
        }

        if (true) {
            QuickSort c = new QuickSort();
            int[] a = {4, 5, 2, 8, 3, 6};

            c.quickSort(a);
            System.out.println(Arrays.toString(a));
        }

        if (true) {
            QuickSort c = new QuickSort();
            int[] a = {2, 7, 1, 6, 3, 9, 5, 8, 4};

            c.quickSort(a);
            System.out.println(Arrays.toString(a));
        }
    }

    private void quickSort(int[] a) {
        quickSort(a, 0, a.length - 1);
    }

    private void quickSort(int[] a, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(a, low, high);
            quickSort(a, low, partitionIndex - 1);
            quickSort(a, partitionIndex + 1, high);
        }
    }

    private int partition(int[] a, int low, int high) {
        int pivot = a[high];

        int i = low;
        int j = high;

        while (i < j) {
            while (i < j && a[i] < pivot) i++;
            while (i < j && a[j] >= pivot) j--;

            if (i != j) swap(i, j, a);
        }

        swap(high, j, a);
        return j;
    }

    private void swap(int l, int r, int[] a) {
        int tmp = a[l];
        a[l] = a[r];
        a[r] = tmp;
    }


}
