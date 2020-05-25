package com.goonigoop.strings;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class PermutationServiceImpl {

    public List<String> permuteWithRecursion(String string) {

        if (string.length() == 0) {
            return Lists.newArrayList("");
        }

        char s = string.charAt(0);

        final String restOfString = string.substring(1);

        final List<String> permute = permuteWithRecursion(restOfString);

        final List<String> result = new ArrayList<>();
        for (String st : permute) {
            for (int i = 0; i <= st.length(); i++) {
                String n = st.substring(0,i) + s+ st.substring(i);
                if (!result.contains(n)) {
                    result.add(n);
                }
            }
        }
        return result;
    }

    public void getPermutationSet(String string, int start, int end, Set<String> set) {
        if (start == end) {
            set.add(string);
        }

        for (int i = start; i <=end ; i++) {
            string = swap(string, start, i);
            getPermutationSet(string,start+1, end, set);
            string = swap(string,start,i);
        }
    }

    private String swap(String string, int start, int i) {
        final char[] chars = string.toCharArray();
        char t = chars[start];
        chars[start] = chars[i];
        chars[i] = t;
        return String.copyValueOf(chars);
    }


}
