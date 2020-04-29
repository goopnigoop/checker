package com.goonigoop;

import java.util.Arrays;

import static com.goonigoop.Sort.arr;
import static com.goonigoop.Sort.quickSort;

public class Search {

    public static void main(String[] args) {
        System.out.println(find(arr, 15));
        int[] a = Arrays.copyOf(arr, arr.length);
        a = quickSort(a);
        System.out.println(binaryFind(a, 756));
    }

    private static boolean binaryFind(int[] arr, int i) {
        int l = 0;
        int h = arr.length - 1;
        while (l <= h) {
            int m = l + (h - l) / 2;
            if (i == arr[m]) {
                return true;
            }
            if (i < arr[m]) {
                h = m - 1;
            } else {
                l = m + 1;
            }
        }
        return false;
    }

    private static boolean find(int[] a, int j) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == j) {
                return true;
            }
        }
        return false;
    }
}
