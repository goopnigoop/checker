package com.goonigoop.service;

import java.util.Deque;
import java.util.LinkedList;

import static java.util.Objects.nonNull;
import static org.apache.commons.lang3.StringUtils.isEmpty;

public class BracketsValidationServiceImpl implements BracketsValidationService {

    @Override
    public boolean validate(String s) {
        if (isEmpty(s)) {
            return true;
        }
        final Deque<Character> characters = new LinkedList<>();
        final char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (BracketsValidationService.bracketsMap.containsKey(aChar) || BracketsValidationService.bracketsMap.containsValue(aChar)) {
                final Character character = BracketsValidationService.bracketsMap.get(aChar);
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
}
