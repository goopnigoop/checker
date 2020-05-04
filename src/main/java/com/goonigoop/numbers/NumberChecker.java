package com.goonigoop.numbers;

public class NumberChecker {
    public boolean isNumberPrime(int i) {
        if (i == 0) {
            return false;
        }
        for (int j = 2; j < Math.sqrt(i); j++) {
            if (i % j == 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isNumberPalindrome(int i) {
        int iFirst = i;
        if (i / 10 == 0) {
            return true;
        }

        int t = 0;

        while (i > 0) {
            final int i1 = i % 10;
            t = t * 10 + i1;
            i/=10;
        }
        return t==iFirst;
    }

    public boolean isNumberPalindromeString(int i) {
        final String s = String.valueOf(i);
        for (int j = 0; j < s.toCharArray().length/2; j++) {
            if (s.charAt(j) != s.charAt(s.length() - 1 - j)) {
                return false;
            }
        }
        return true;
    }

    public boolean isNumberPrime(long i) {
        if (i<2) {
            return false;
        }

        for (int j = 2; j < Math.sqrt(i)+1; j++) {
            if (i % j == 0) {
                return false;
            }
        }
        return true;
    }
}
