package com.goonigoop.service;

import com.google.common.collect.ImmutableMap;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;

import static java.util.Objects.nonNull;
import static org.apache.commons.lang3.StringUtils.isEmpty;

public class BracketService {

    private final static Map<Character, Character> bracketsMap = initMap();

    private static Map<Character, Character> initMap() {
        return ImmutableMap.of(']', '[', ')', '(', '}', '{');
    }


    public boolean validate(String s) {
        if (isEmpty(s)) {
            return true;
        }
        final Deque<Character> characters = new LinkedList<>();
        final char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (bracketsMap.containsKey(aChar) || bracketsMap.containsValue(aChar)) {
                final Character character = bracketsMap.get(aChar);
                if (nonNull(character)) {
                    if (characters.isEmpty() || !character.equals(characters.pop())) {
                        return false;
                    }
                } else {
                    characters.push(aChar);
                }
            }
        }
        return characters.isEmpty();

    }

    public boolean validateWithStreams(String s) {

        if (isEmpty(s)) {
            return true;
        }
        final Deque<Character> characters = new LinkedList<>();
        final boolean allMatch = s
                .chars()
                .mapToObj(g -> (char) g)
                .filter(ch -> bracketsMap.containsKey(ch) || bracketsMap.containsValue(ch))
                .allMatch(ch -> {
                    final Character character = bracketsMap.get(ch);
                    if (nonNull(character)) {
                        return !characters.isEmpty() && character.equals(characters.pop());
                    } else {
                        characters.push(ch);
                    }
                    return true;
                });

        return allMatch && characters.isEmpty();
    }
}
