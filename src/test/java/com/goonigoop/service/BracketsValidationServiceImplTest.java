package com.goonigoop.service;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class BracketsValidationServiceImplTest {

    @ParameterizedTest
    @MethodSource("getBracketsValidationService")
    void testThatBracketServiceValidatesString(BracketsValidationService validationService){
        boolean result = validationService.validate(" public boolean validate(String s) {\n" + "        if (isEmpty(s)) {\n" + "            return true;\n" + "        }\n" + "        final Deque<Character> characters = new LinkedList<>();\n" + "        final boolean allMatch = s\n" + "                .chars()\n" + "                .mapToObj(g -> (char) g)\n" + "                .filter(ch -> bracketsMap.containsKey(ch) || bracketsMap.containsValue(ch))\n" + "                .allMatch(ch -> {\n" + "                    final Character character = bracketsMap.get(ch);\n" + "                    if (nonNull(character)) {\n" + "                        return !characters.isEmpty() && character.equals(characters.pop());\n" + "                    } else {\n" + "                        characters.push(ch);\n" + "                    }\n" + "                    return true;\n" + "                });\n" + "\n" + "        return allMatch && characters.isEmpty();\n" + "    }\n" + "\n" + "    public boolean validateWithStreams(String s) {\n" + "        if (isEmpty(s)) {\n" + "            return true;\n" + "        }\n" + "        final Deque<Character> characters = new LinkedList<>();\n" + "        final char[] chars = s.toCharArray();\n" + "        for (char aChar : chars) {\n" + "            if (bracketsMap.containsKey(aChar) || bracketsMap.containsValue(aChar)) {\n" + "                final Character character = bracketsMap.get(aChar);\n" + "                if (nonNull(character)) {\n" + "                    if (characters.isEmpty() || !character.equals(characters.pop())) {\n" + "                        return false;\n" + "                    }\n" + "                } else {\n" + "                    characters.push(aChar);\n" + "                }\n" + "            }\n" + "        }\n" + "        return characters.isEmpty();\n" + "    }");
        assertThat(result, is(Boolean.TRUE));
    }

    @ParameterizedTest
    @MethodSource("getBracketsValidationService")
    void testThatBracketServiceValidatesBadStringWithTwoBrackets(BracketsValidationService validationService){
        boolean result = validationService.validate(" public boolean( validate(String s) {\n" + "        if (isEmpty(s)) {\n" + "            return true;\n" + "        }\n" + "        final Deque<Character> characters = new LinkedList<>();\n" + "        final boolean allMatch = s\n" + "                .chars()\n" + "                .mapToObj(g -> (char) g)\n" + "                .filter(ch -> bracketsMap.containsKey(ch) || bracketsMap.containsValue(ch))\n" + "                .allMatch(ch -> {\n" + "                    final Character character = bracketsMap.get(ch);\n" + "                    if (nonNull(character)) {\n" + "                        return !characters.isEmpty() && character.equals(characters.pop());\n" + "                    } else {\n" + "                        characters.push(ch);\n" + "                    }\n" + "                    return true;\n" + "                });\n" + "\n" + "        return allMatch && characters.isEmpty();\n" + "    }\n" + "\n" + "    public boolean validateWithStreams(String s) {\n" + "        if (isEmpty(s)) {\n" + "            return true;\n" + "        }\n" + "        final Deque<Character> characters = new LinkedList<>();\n" + "        final char[] chars = s.toCharArray();\n" + "        for (char aChar : chars) {\n" + "            if (bracketsMap.containsKey(aChar) || bracketsMap.containsValue(aChar)) {\n" + "                final Character character = bracketsMap.get(aChar);\n" + "                if (nonNull(character)) {\n" + "                    if (characters.isEmpty() || !character.equals(characters.pop())) {\n" + "                        return false;\n" + "                    }\n" + "                } else {\n" + "                    characters.push(aChar);\n" + "                }\n" + "            }\n" + "        }\n" + "        return characters.isEmpty();\n" + "    }");
        assertThat(result, is(Boolean.FALSE));
    }

    @ParameterizedTest
    @MethodSource("getBracketsValidationService")
    void testThatBracketServiceValidatesBadString(BracketsValidationService validationService){
        boolean result = validationService.validate(" public boolean valid)ate(String s) {\n" + "        if (isEmpty(s)) {\n" + "            return true;\n" + "        }\n" + "        final Deque<Character> characters = new LinkedList<>();\n" + "        final boolean allMatch = s\n" + "                .chars()\n" + "                .mapToObj(g -> (char) g)\n" + "                .filter(ch -> bracketsMap.containsKey(ch) || bracketsMap.containsValue(ch))\n" + "                .allMatch(ch -> {\n" + "                    final Character character = bracketsMap.get(ch);\n" + "                    if (nonNull(character)) {\n" + "                        return !characters.isEmpty() && character.equals(characters.pop());\n" + "                    } else {\n" + "                        characters.push(ch);\n" + "                    }\n" + "                    return true;\n" + "                });\n" + "\n" + "        return allMatch && characters.isEmpty();\n" + "    }\n" + "\n" + "    public boolean validateWithStreams(String s) {\n" + "        if (isEmpty(s)) {\n" + "            retur(n true;\n" + "        }\n" + "        final Deque<Character> characters = new LinkedList<>();\n" + "        final char[] chars = s.toCharArray();\n" + "        for (char aChar : chars) {\n" + "            if (bracketsMap.containsKey(aChar) || bracketsMap.containsValue(aChar)) {\n" + "                final Character character = bracketsMap.get(aChar);\n" + "                if (nonNull(character)) {\n" + "                    if (characters.isEmpty() || !character.equals(characters.pop())) {\n" + "                        return false;\n" + "                    }\n" + "                } else {\n" + "                    characters.push(aChar);\n" + "                }\n" + "            }\n" + "        }\n" + "        return characters.isEmpty();\n" + "    }");
        assertThat(result, is(Boolean.FALSE));
    }

    static Stream<BracketsValidationService> getBracketsValidationService() {
        return Stream.of(
                new BracketsValidationServiceImpl(),
                new BracketsValidationWithStreamsServiceImpl());
    }
}
