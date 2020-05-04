package com.goonigoop.functioninterfaces;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

class FibonacciServiceTest {

    FibonacciService fibonacciService;

    @BeforeEach
    void setUp() {
        fibonacciService = new FibonacciService();
    }

    @Test
    void get3FibonacciNumber() {
        //when
        final long nValue = fibonacciService.getNValue(3);
        //then
        assertThat(nValue, is(1L));
    }

    @Test
    void get7FibonacciNumber() {
        //when
        final long nValue = fibonacciService.getNValue(7);
        //then
        assertThat(nValue, is(8L));
    }

    @Test
    void get10FibonacciNumber() {
        //when
        final long nValue = fibonacciService.getNValue(10);
        //then
        assertThat(nValue, is(34L));
    }

    @Test
    void get10FibonacciNumberRecursion() {
        //when
        final long nValue = fibonacciService.getNValueRecursion(10);
        //then
        assertThat(nValue, is(34L));
    }

    @Test
    void get10FibonacciNumberRecursionImproved() {
        //when
        final long nValue = fibonacciService.getNValueRecursionImproved(10);
        //then
        assertThat(nValue, is(34L));
    }

    @Test
    void getNFibonacciNumberRecursionAndWithout() {
        //when
        final long nValue = fibonacciService.getNValue(20);
        final long recursion = fibonacciService.getNValueRecursion(20);

        //then
        assertThat(nValue, is(recursion));
    }


    @Test
    void getArrayOfFibonacciNumbers() {
        //when
        long[] arr = fibonacciService.getNNumbers(10);
        //then
        assertThat(arr, equalTo(new long[]{0L, 1L, 1L, 2L, 3L, 5L, 8L, 13L, 21L, 34L}));
    }
}