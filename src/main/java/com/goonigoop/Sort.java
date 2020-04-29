package com.goonigoop;

import java.util.Arrays;

public class Sort {
    public final static int[] arr = {1, 5, 3, 7, 56, 3, 23, 756, 345, 345, 346, 75, 1, 5343, 56, 3, 2};
    private static int[] a;
    private static int[] res;

    public static void main(String[] args) {
        a = Arrays.copyOf(arr, arr.length);
        res = sort(a);
        System.out.println(Arrays.toString(res));
        a = Arrays.copyOf(arr, arr.length);
        res = sortB(a);
        System.out.println(Arrays.toString(res));
        a = Arrays.copyOf(arr, arr.length);
        res = sortInsert(a);
        System.out.println(Arrays.toString(res));
        a = Arrays.copyOf(arr, arr.length);
        res = quickSort(a);
        System.out.println(Arrays.toString(res));

    }

    public static int[] quickSort(int[] a) {
        int l = 0;
        int h = a.length - 1;
        qs(a, l, h);
        return a;
    }

    private static void qs(int[] a, int low, int high) {
        int l = low;
        int h = high;
        int medium = l + (h - l) / 2;
        int m = a[medium];
        while (l <= h) {
            while (a[l] < m) {
                l++;
            }
            while (m < a[h]) {
                h--;
            }
            if (l <= h) {
                swap(a, l, h);
                l++;
                h--;
            }
        }
        if (l < high) {
            qs(a, l, high);
        }
        if (h > low) {
            qs(a, low,h);
        }
    }

    private static int[] sortInsert(int[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if (a[j] < a[j - 1]) {
                    swap(a, j, j - 1);
                }
            }
        }
        return a;
    }

    private static int[] sortB(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    swap(a, i, j);
                }
            }
        }
        return a;
    }

    private static int[] sort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            boolean c = false;
            for (int j = 0; j < a.length - 1; j++) {
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                    c = true;
                }
            }
            if (!c) {
                break;
            }
        }
        return a;
    }

    private static void swap(int[] a, int j, int i) {
        int t = a[j];
        a[j] = a[i];
        a[i] = t;
    }
}
