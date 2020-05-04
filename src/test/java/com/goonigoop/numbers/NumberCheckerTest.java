package com.goonigoop.numbers;

import org.junit.jupiter.api.Test;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class NumberCheckerTest {

    NumberChecker numberChecker = new NumberChecker();

    @Test
    void checkNumberIsPrime() {
        //when
        boolean result = numberChecker.isNumberPrime(19);

        //then
        assertThat(result, is(TRUE));
    }

    @Test
    void checkNumberIsNotPrime() {
        //when
        boolean result = numberChecker.isNumberPrime(256);

        //then
        assertThat(result, is(FALSE));
    }

    @Test
    void isNumberPalindrome() {
        //when
        final boolean result = numberChecker.isNumberPalindrome(345676543);

        //then
        assertThat(result, is(TRUE));
    }

    @Test
    void isNumberNotPalindrome() {
        //when
        final boolean result = numberChecker.isNumberPalindrome(12366);

        //then
        assertThat(result, is(FALSE));
    }

    @Test
    void isNumberPalindromeString() {
        //when
        final boolean result = numberChecker.isNumberPalindrome(345676543);

        //then
        assertThat(result, is(TRUE));
    }
}
