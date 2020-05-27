package com.goonigoop.service;

import com.google.common.collect.ImmutableMap;

import java.util.Map;

public interface BracketsValidationService {
    Map<Character, Character> bracketsMap = ImmutableMap.of(']', '[', ')', '(', '}', '{');

    boolean validate(String s);
}
