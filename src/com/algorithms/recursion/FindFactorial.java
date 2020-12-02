package com.algorithms.recursion;

public class FindFactorial {

    public static void main(String[] args) {
        if (true) {
            FindFactorial s = new FindFactorial();
            int n = 5;

            System.out.println("Result " + s.findFactorial(n));
        }
    }

    private int findFactorial(int n) {
        if(n == 1) return 1;
        return n * findFactorial(n - 1);
    }

}
