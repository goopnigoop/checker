package com.goonigoop.functioninterfaces.strings;

import java.util.Deque;
import java.util.LinkedList;
import java.util.function.Predicate;

public class Palindrome {
    public static void main(String[] args) {
        String s = "qwertrewq";
        Predicate<String> p = st -> new StringBuilder(st)
                .reverse()
                .toString()
                .equals(st);
        Predicate<String> pN = st -> {

            final char[] chars = st.toCharArray();
            for (int i = 0; i < chars.length / 2; i++) {
                if (chars[i] != chars[chars.length - 1 - i]) {
                    return false;
                }
            }
            return true;
        };

        Predicate<String> pR = Palindrome::recurs;
        Predicate<String> stackPredicate = Palindrome::stackCheck;


        System.out.println(p
                .and(pN)
                .and(pR)
                .and(stackPredicate)
                .test(s));

    }

    private static boolean stackCheck(String stringToCheck) {
        Deque<Character> deq = new LinkedList<>();
        stringToCheck
                .chars()
                .mapToObj(i -> (char) i)
                .forEach(deq::push);
        final char[] chars = new char[deq.size()];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = deq.pop();
        }
        return stringToCheck.equals(new String(chars));
    }

    private static boolean recurs(String st) {
        if (st.length() < 2) {
            return true;
        }
        return st.charAt(0) == st.charAt(st.length() - 1) && recurs(st.substring(1, st.length() - 1));
    }
}
