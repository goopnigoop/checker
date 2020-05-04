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
