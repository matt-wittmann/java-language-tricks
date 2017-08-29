package com.mattwittmann.polyglots.languagetricks;

import java.util.HashMap;
import java.util.Map;

class DoubleBraceInitialization {
    static final String KEY = "Example";
    static final String VALUE = "Value";

    static Map<String, String> buildMapWithoutDoubleBraceInitialization() {
        Map<String, String> map = new HashMap<>();
        map.put(KEY, VALUE);

        return map;
    }

    static Map<String, String> buildMapWithDoubleBraceInitialization() {
        return new HashMap<String, String>() {{
            put(KEY, VALUE);
        }};
    }
}
