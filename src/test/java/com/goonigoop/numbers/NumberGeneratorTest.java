package com.goonigoop.numbers;

import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;


public class NumberGeneratorTest {
    NumberGenerator numberGenerator = new NumberGenerator();

    @Test
    void generateOnlyPrimeNumbers() {
        //when
        Iterable<Long> result = numberGenerator.generate(7);

        assertThat(result).containsAll(asList(3L, 5L, 7L, 11L, 13L, 17L, 19L));
    }

}
