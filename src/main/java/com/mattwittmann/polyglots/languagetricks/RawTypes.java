package com.mattwittmann.polyglots.languagetricks;

import java.util.ArrayList;
import java.util.List;

class RawTypes {
    static final class Boom {
        static final Boom BOOM = new Boom();

        private Boom() {
        }
    }

    static List<String> buildParameterizedList() {
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("orange");
        list.add("grape");

        return list;
    }

    static List buildRawList() {
        List list = new ArrayList();
        list.add("apple");
        list.add("orange");
        list.add(Boom.BOOM);
        list.add("grape");

        return list;
    }
}
