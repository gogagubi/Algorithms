package com.algorithms.general;

public class FindMedian {

    public static void main(String[] args) {
        if (false) {
            FindMedian s = new FindMedian();
            int[] arr = {6, 7, 3, 2, 1, 9, 4};

            System.out.println("Result " + s.findMedian(arr));
        }

        if (true) {
            FindMedian s = new FindMedian();
            int[] arr = {9, 12, 2, 7, 8, 5};

            System.out.println("Result " + s.findMedian(arr));
        }
    }

    private double findMedian(int[] arr) {
        int max = 0;
        for (int i : arr) max = Math.max(max, i);

        int[] counts = new int[max + 1];
        for(int i = 0; i < arr.length; i ++){
            counts[arr[i]] ++;
        }

        double median = 0;

        //even
        if(arr.length % 2 == 0){
            Integer l = null;
            Integer r = null;

            int count = 0;
            for(int i = 0; i < counts.length; i ++) {
                count += counts[i];
                if (l == null) {
                    if(count >= arr.length / 2){
                        l = i;
                    }
                }
                if (l != null) {
                    if(count > arr.length / 2){
                        r = i;
                        break;
                    }
                }
            }

            median = (l != null && r != null) ? (l + r) / 2.0 : 0;
        }
        //odd
        else{
            int count = 0;
            for(int i = 0; i < counts.length; i ++){
                count += counts[i];
                if(count > arr.length / 2){
                    median = i;
                    break;
                }
            }
        }

        return median;
    }

}
