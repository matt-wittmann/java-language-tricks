package com.mattwittmann.polyglots.languagetricks;

import org.junit.Test;

import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;
import static com.mattwittmann.polyglots.languagetricks.RawTypes.*;

public class RawTypesTest {
    @Test
    public void verifyParameterizedListSizeIs3() {
        assertEquals(3, buildParameterizedList().size());
    }

    @Test
    public void verifyRawListSizeIs4() {
        assertEquals(4, buildRawList().size());
    }

    /**
     * Java provides some compile-time checks that the type matches <code>List</code>'s type parameter.
     */
    @Test
    public void verifyTypeSafety() {
        for (String value : buildParameterizedList()) {
            assertNotNull(value);
        }
    }

    /**
     * Sometimes the language tricks you.
     * Java 2 version 1.4 and earlier lacked generic types, so we had to cast to the expected type and hope
     * people weren't stuffing stranger things into the collection.
     * In this case, things went boom!
     */
    @Test(expected = ClassCastException.class)
    public void verifySafetyIsOff() {
        for (Iterator<?> iterator = buildRawList().iterator(); iterator.hasNext();) {
            String value = (String) iterator.next();
            assertNotNull(value);
        }
    }

    /**
     * We can easily circumvent type safety because of type erasure.
     */
    @Test(expected = ClassCastException.class)
    public void verifySafetyCanBeBroken() {
        List<String> list = buildParameterizedList();
        // rawList is a reference to the same object as list now
        List rawList = list;
        // But here the compiler doesn't care about the type parameter!
        rawList.add(Boom.BOOM);

        // So the implicit cast fails!
        for (String value : list) {
            assertNotNull(value);
        }
    }
}
