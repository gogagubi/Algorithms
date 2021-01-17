package com.algorithms.sorting;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        if (true) {
            SelectionSort c = new SelectionSort();
            int[] a = {1, 2, 3};

            c.selectionSort(a);
            System.out.println(Arrays.toString(a));
        }

        if (true) {
            SelectionSort c = new SelectionSort();
            int[] a = {3, 2, 1};

            c.selectionSort(a);
            System.out.println(Arrays.toString(a));
        }

        if (true) {
            SelectionSort c = new SelectionSort();
            int[] a = {4, 5, 2, 8, 3, 6};

            c.selectionSort(a);
            System.out.println(Arrays.toString(a));
        }
    }

    private void selectionSort(int[] a) {
        int n = a.length;

        for (int i = 0; i < n - 1; i++) {
            int minValue = a[i];
            int minIndex = i;
            for (int j = i; j < n; j++) {
                if(a[j] < minValue){
                    minValue = a[j];
                    minIndex = j;
                }
            }

            swap(i, minIndex, a);
        }
    }

    private void swap(int l, int r, int[] a) {
        int tmp = a[l];
        a[l] = a[r];
        a[r] = tmp;
    }
}
