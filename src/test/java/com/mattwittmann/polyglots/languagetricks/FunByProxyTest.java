package com.mattwittmann.polyglots.languagetricks;

import org.junit.Before;
import org.junit.Test;

import static com.mattwittmann.polyglots.languagetricks.FunByProxy.*;
import static org.junit.Assert.assertEquals;

public class FunByProxyTest {
    private Fun fun;
    private NotFun notFun;

    @Before
    public void setUp() {
        fun = haveFunByProxy();
        notFun = (NotFun) fun;
    }

    @Test
    public void doWeWantToJumpRope() {
        assertEquals("No", fun.jumpRope());
    }

    @Test
    public void doWeWantToSkip() {
        assertEquals("No", fun.skip());
    }

    @Test
    public void verifyWeHaveImplementedAllTheThings() {
        assertEquals("Done", fun.implementAllTheThings());
    }

    @Test(expected = IllegalArgumentException.class)
    public void errorsAreNotFun() {
        notFun.plusFun();
    }
}
