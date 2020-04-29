package com.goonigoop.functioninterfaces.strings;

import java.util.function.Predicate;

public class Palindrome {
    public static void main(String[] args) {
        String s = "qwertrewq";
        Predicate<String> p = st -> new StringBuilder(st).reverse().toString().equals(st);
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



        System.out.println(p.and(pN).and(pR).test(s));

    }

    private static boolean recurs(String st) {
        if (st.length() < 2) {
            return true;
        }
        return st.charAt(0) == st.charAt(st.length() - 1) && recurs(st.substring(1, st.length() - 1));
    }
}
