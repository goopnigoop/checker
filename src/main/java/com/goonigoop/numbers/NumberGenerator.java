package com.goonigoop.numbers;

import java.util.function.LongUnaryOperator;
import java.util.stream.LongStream;

import static java.util.stream.Collectors.toList;

public class NumberGenerator {
    public Iterable<Long> generate(int i) {
        NumberChecker numberChecker = new NumberChecker();

        final LongUnaryOperator longUnaryOperator = n -> n + 1;
        return LongStream
                .iterate(0, longUnaryOperator)
                .filter(numberChecker::isNumberPrime)
                .limit(i)
                .boxed()
                .collect(toList());
    }
}
