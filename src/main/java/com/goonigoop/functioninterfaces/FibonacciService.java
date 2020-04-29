package com.goonigoop.functioninterfaces;

public class FibonacciService {
    public long getNValue(int i) {
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
            return 1;
        }
        int a = 0;
        int b = 1;
        int r = 0;
        for (int j = 0; j < i - 2; j++) {
            r = a + b;
            a = b;
            b = r;
        }
        return r;
    }

    public long getNValueRecursion(int i) {

        return 0;
    }

    public long[] getNNumbers(int i) {
        long[] res = new long[i];
        if (i == 0) {
            return res;
        }
        if (i == 1) {
            res[0] = 0;
        }
        if (i == 2) {
            res[0] = 0;
            res[1] = 1;
        }
        long a = res[0] = 0;
        long b = res[1] = 1;
        for (int j = 2; j < i; j++) {
            res[j] = a + b;
            a = b;
            b = res[j];
        }

        return res;
    }
}
