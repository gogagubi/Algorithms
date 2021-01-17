package com.algorithms.sorting;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        if (false) {
            MergeSort c = new MergeSort();
            int[] a = {1, 2, 3};

            c.mergeSort(a);
            System.out.println(Arrays.toString(a));
        }

        if (false) {
            MergeSort c = new MergeSort();
            int[] a = {3, 2, 1};

            c.mergeSort(a);
            System.out.println(Arrays.toString(a));
        }

        if (true) {
            MergeSort c = new MergeSort();
            int[] a = {4, 5, 2, 8, 3, 6};

            c.mergeSort(a);
            System.out.println(Arrays.toString(a));
        }
    }

    private void mergeSort(int[] a) {
        int n = a.length;
        if (n < 2) return;

        int middle = n / 2;

        int[] leftArr = new int[middle];
        int[] rightArr = new int[n - middle];

        for (int i = 0; i < n; i++) {
            if (i < middle) leftArr[i] = a[i];
            else rightArr[i - middle] = a[i];
        }

        mergeSort(leftArr);
        mergeSort(rightArr);

        int k = 0, l = 0, r = 0;
        while (l < leftArr.length && r < rightArr.length) {
            if (leftArr[l] < rightArr[r]) a[k++] = leftArr[l++];
            else a[k++] = rightArr[r++];
        }

        while (l < leftArr.length) a[k++] = leftArr[l++];
        while (r < rightArr.length) a[k++] = rightArr[r++];
    }

}
