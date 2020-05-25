package com.goonigoop.strings;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

public class WordsPermutations {

    private final PermutationServiceImpl permutationService = new PermutationServiceImpl();

    @Test
    void testPermutationServiceGivesAllWords() {

        List<String> result = permutationService.permuteWithRecursion("cat");
        assertThat(result,hasSize(6));
        assertThat(result, Matchers.containsInAnyOrder("cat", "tac", "cta", "tca", "act", "atc"));
        assertThat(result, Matchers.hasItems("cat", "tac", "cta", "tca", "act", "atc"));
    }

    @Test
    void testPermutationServiceGivesAllWordsFor5Letters() {

        List<String> result = permutationService.permuteWithRecursion("kater");
        assertThat(result,hasSize(120));
        assertThat(result, Matchers.hasItems("eatrk", "retak"));
    }

    @Test
    void testPermutationServiceGivesAllWordsForSet() {

        Set<String> set = new HashSet<>();
        permutationService.getPermutationSet("cat",0,2,set);
        assertThat(set,hasSize(6));
        assertThat(set, Matchers.containsInAnyOrder("cat", "tac", "cta", "tca", "act", "atc"));
        assertThat(set, Matchers.hasItems("cat", "tac", "cta", "tca", "act", "atc"));

    }
}
