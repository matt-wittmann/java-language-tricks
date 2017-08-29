package com.mattwittmann.polyglots.languagetricks;

import org.junit.Test;

import static com.mattwittmann.polyglots.languagetricks.BytecodeInstrumentation.*;
import static org.junit.Assert.assertEquals;

public class BytecodeInstrumentationTest {
    @Test
    public void verifyClassRedefinition() {
        redefineClass();
        ImportantClass object = new ImportantClass();
        assertEquals(REDEFINED_RETURN_VALUE, object.doThings());
    }
}
