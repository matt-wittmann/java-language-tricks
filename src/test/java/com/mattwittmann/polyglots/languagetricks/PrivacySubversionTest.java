package com.mattwittmann.polyglots.languagetricks;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.assertEquals;

public class PrivacySubversionTest {
    private NotPaulaBean notPaulaBean;

    @Before
    public void setUp() {
        notPaulaBean = new NotPaulaBean();
    }

    @Test
    public void verifyThatBrilliantBusinessLogic() {
        assertEquals("Sheer BRILLIANce!", notPaulaBean.getNotPaula());
    }

    /**
     * The code declared this field's visibility to be private, but we can just ignore that with reflection.
     * This can be stopped with a
     * <code><a href="https://docs.oracle.com/javase/8/docs/api/java/lang/SecurityManager.html">SecurityManager</a></code>.
     */
    @Test
    public void accessCanBeForced() throws NoSuchFieldException, IllegalAccessException {
        Field field = notPaulaBean.getClass().getDeclaredField("notPaula");
        field.setAccessible(true);
        assertEquals("Brilliant", field.get(notPaulaBean));
    }
}