package com.mattwittmann.polyglots.languagetricks;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static com.mattwittmann.polyglots.languagetricks.DoubleBraceInitialization.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class DoubleBraceInitializationTest {
    @Test
    public void verifyMapWithoutDoubleBraceInitializationHasExpectedKeyAndValue() {
        Map<String, String> map = buildMapWithoutDoubleBraceInitialization();
        assertEquals(VALUE, map.get(KEY));
    }

    @Test
    public void verifyMapWithDoubleBraceInitializationHasExpectedKeyAndValue() {
        Map<String, String> map = buildMapWithDoubleBraceInitialization();
        assertEquals(VALUE, map.get(KEY));
    }

    @Test
    public void verifyNormalInitializationIsHashMap() {
        Map<String, String> map = buildMapWithoutDoubleBraceInitialization();
        assertEquals(HashMap.class, map.getClass());
    }

    /**
     * Unfortunately, this trick relies on instantiating an anonymous class and using an instance initializer, which is
     * not the same as a constructor, so the type is not equal. JEP-269, released with the forthcoming Java 9, will
     * provide factory methods to alleviate this problem, and Google Guava has similar factory methods.
     */
    @Test
    public void verifyDoubleBraceInitializationIsNotHashMap() {
        Map<String, String> map = buildMapWithDoubleBraceInitialization();
        assertNotEquals(HashMap.class, map.getClass());
    }
}
