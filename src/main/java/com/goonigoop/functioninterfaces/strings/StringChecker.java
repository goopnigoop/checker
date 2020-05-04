package com.goonigoop.functioninterfaces.strings;

import org.apache.commons.lang3.StringUtils;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.isNull;

public class StringChecker {
    public Map<String, Integer> countWordsInString(String inputString){
        if (StringUtils.isEmpty(inputString)) {
            return Collections.emptyMap();
        }

        final String[] s = inputString.split(" ");
        final HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length; i++) {
            final Integer integer = map.get(s[i]);
            if (isNull(integer)) {
                map.put(s[i], 1);
            } else {
                map.put(s[i], integer + 1);
            }
        }
        return map;
    }
}
