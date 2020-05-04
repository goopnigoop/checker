package com.goonigoop.functioninterfaces.strings;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

class StringCheckerTest {

    StringChecker checker = new StringChecker();

    @Test
    void mapShouldContainAllWords() {
        //when
        final Map<String, Integer> stringIntegerMap = checker.countWordsInString("qwerty asdfg zx dsfaf dsf ds fds har ewg dsfaf fdsaf dsfaf gd f");

        assertThat(stringIntegerMap).contains(entry("dsfaf", 3));


    }
}