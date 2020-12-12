package com.algorithms.general;

public class reverseInteger {

    public static void main(String[] args) {
        if (true) {
            reverseInteger s = new reverseInteger();
            int x = 123;

            System.out.println("Result " + s.reverse(x));
        }

        if (true) {
            reverseInteger s = new reverseInteger();
            int x = 120;

            System.out.println("Result " + s.reverse(x));
        }

        if (true) {
            reverseInteger s = new reverseInteger();
            int x = -128;

            System.out.println("Result " + s.reverse(x));
        }
    }

    private int reverse(int x) {
        int ans = 0;

        while (x != 0) {
            int reminder = x % 10;
            ans = ans * 10 + reminder;
            x /= 10;
        }

        return ans;
    }

}
