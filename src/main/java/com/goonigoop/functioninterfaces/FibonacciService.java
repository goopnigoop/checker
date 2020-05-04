package com.goonigoop.functioninterfaces;

import java.util.function.LongSupplier;

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
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
            return 1;
        }
        return getNValueRecursion(i-1) + getNValueRecursion(i-2);
    }

    public LongSupplier getFibSupplier(){
        return new LongSupplier() {
            long prev = 0;
            long next = 1;
            @Override
            public long getAsLong() {
                long t = prev;
                long res = this.prev + this.next;
                this.prev = next;
                this.next = res;
                return t;
            }
        };
    }


    public long getNValueRecursionImproved(int i) {
        long[] cache = new long[i];
        cache[0] = 0;
        cache[1] = 1;
       return fibImpr(i,cache);
    }

    private long fibImpr(int i, long[] cache) {
        if (i == 1 || i == 2) {
            return i-1;
        }
        if(cache[i-1]>0 )
            return cache[i - 1];

        cache[i-1] = fibImpr(i-1, cache) + fibImpr(i-2,cache);
        return cache[i-1];
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
