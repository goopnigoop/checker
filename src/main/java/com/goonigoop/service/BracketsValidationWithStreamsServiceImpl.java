package com.goonigoop.service;

import java.util.Deque;
import java.util.LinkedList;

import static java.util.Objects.nonNull;
import static org.apache.commons.lang3.StringUtils.isEmpty;

public class BracketsValidationWithStreamsServiceImpl implements BracketsValidationService {
    @Override
    public boolean validate(String s) {
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
