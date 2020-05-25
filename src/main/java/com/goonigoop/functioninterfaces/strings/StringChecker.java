package com.goonigoop.functioninterfaces.strings;

import org.apache.commons.lang3.StringUtils;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class StringChecker {
    public Map<String, Integer> countWordsInString(String inputString){
        if (StringUtils.isEmpty(inputString)) {
            return Collections.emptyMap();
        }

        final String[] s = inputString.split(" ");
        final HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length; i++) {
            map.merge(s[i],1, Integer::sum);
        }
        return map;
    }
}
