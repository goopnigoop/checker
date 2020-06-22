package com.goonigoop.collections;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.not;

class CustomStackImplTest {

    public static final int SIZE = 10;
    CustomStack<String> customStack = new CustomStackImpl(SIZE);

    @BeforeEach
    void setUp() {
        customStack.clear();
    }

    @AfterEach
    void tearDown() {
        customStack.clear();
    }

    @Test
    void popElementFromStack() {
        //given
        customStack.push("1");
        customStack.push("2");
        customStack.push("3");
        customStack.push("4");
        customStack.push("5");

        String first = customStack.pop();
        String second = customStack.pop();
        String third = customStack.pop();
        String fourth = customStack.pop();
        String fifth = customStack.pop();

        assertThat(first, is("5"));
        assertThat(second, is("4"));
        assertThat(third, is("3"));
        assertThat(fourth, is("2"));
        assertThat(fifth, is("1"));
    }

    @Test
    void testThatStackIsFull() {
        //given
        CustomStack<String> customStack = new CustomStackImpl(3);
        customStack.push("1");
        customStack.push("2");
        customStack.push("3");

        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> customStack.push("4"));
        assertThat(exception.getMessage(), is("The stack is full"));
    }

    @Test
    void testThatStackReturnsSameValueByPeek() {
        //given
        CustomStack<String> customStack = new CustomStackImpl(3);
        customStack.push("1");
        customStack.push("2");
        customStack.push("3");

        assertThat(customStack.peek(), is("3"));
        assertThat(customStack.peek(), is("3"));
        assertThat(customStack.peek(), is("3"));
        assertThat(customStack.size(), is(3));
    }

    @Test
    void testThatStackIsClearedAfterPushAndPop() {
        customStack.push("1");
        customStack.push("2");
        customStack.push("3");

        customStack.pop();
        customStack.pop();
        customStack.pop();
        assertThat(customStack.size(), is(0));
    }

    @Test
    void testThatStackIsClearedAfterCrealing() {
        customStack.push("1");
        customStack.push("2");
        customStack.push("3");

        customStack.clear();
        assertThat(customStack.size(), is(0));
    }

    @RepeatedTest(300)
    void threadsTest() throws InterruptedException {
        customStack = new CustomStackImpl(1);
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        IntStream.range(0,3000)
                 .forEach(value -> executorService.submit(() -> {
                     customStack.push("1");
                     System.out.println(customStack.size());
                     customStack.push("2");
                     System.out.println("SIZE:"+customStack.size());
                     customStack.push("3");
                     System.out.println("SIZE:"+customStack.size());
                     customStack.push("4");
                     System.out.println("SIZE:"+customStack.size());
                     assertThat(customStack.size(), not(greaterThanOrEqualTo(1)));
                     customStack.pop();
                     customStack.pop();
                     customStack.pop();
                     customStack.pop();
                     assertThat(customStack.size(), lessThan(3));
                 }));
        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.MINUTES);

        assertThat(customStack.size(), is(0));
    }
}