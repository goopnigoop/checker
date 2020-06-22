package com.goonigoop.collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.is;

class CustomQueueImplTest {

    private CustomQueue cq;

    @BeforeEach
    void setUp() {
        cq = new CustomQueueImpl(5);
    }

    @Test
    void testThatQueueIsFull() {
        cq.add(1);
        cq.add(2);
        cq.add(3);
        cq.add(4);
        assertThat(cq.isFull(), is(FALSE));
        cq.add(5);
        assertThat(cq.isFull(), is(TRUE));
    }

    @Test
    void testThatCouldNotAddElementToQueue() {
        cq.add(1);
        cq.add(2);
        cq.add(3);
        cq.add(4);
        boolean fifth = cq.add(5);
        boolean sixth = cq.add(6);
        assertThat(fifth, is(TRUE));
        assertThat(sixth, is(FALSE));
    }

    @Test
    void testThatReturnsMinusOneWhenPollFromE() {
        cq.add(1);
        cq.add(2);
        cq.add(3);
        cq.add(4);
        boolean fifth = cq.add(5);
        boolean sixth = cq.add(6);
        assertThat(fifth, is(TRUE));
        assertThat(sixth, is(FALSE));
    }

    @Test
    void testThatReturnsAllElements() {
        cq.add(1);
        cq.add(2);
        cq.add(3);
        cq.add(4);
        cq.add(5);
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            integers.add(cq.poll());
        }

        assertThat(integers, contains(1,2,3,4,5));
    }

    @Test
    void testThatCurrentSizeDoesntChangeAfterShowFirstOrLast() {
        cq.add(1);
        cq.add(2);
        cq.add(3);
        cq.add(4);
        cq.add(5);
        assertThat(cq.currentSize(), is(5));
        int first = cq.showFirst();
        int last = cq.showLast();
        assertThat(cq.currentSize(), is(5));
        assertThat(first, is(1));
        assertThat(last, is(5));
    }


}