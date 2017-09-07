package com.mattwittmann.polyglots.languagetricks;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CommentCodeTest {
    @Test
    public void verifyNumberIsBiggerThanExpected() {
        assertEquals(5, CommentCode.biggerThanExpected());
    }
}
