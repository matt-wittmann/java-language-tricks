package com.mattwittmann.polyglots.languagetricks;

import org.junit.Test;

import static com.mattwittmann.polyglots.languagetricks.JavaBeanAlternatives.BeanAlternative;
import static com.mattwittmann.polyglots.languagetricks.JavaBeanAlternatives.JavaBeanExample;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class JavaBeanAlternativesTest {
    private static final String NAME = "Example";

    @Test
    public void demonstrateInstantiationWorksTheSameWay() {
        assertNotNull(new JavaBeanExample());
        assertNotNull(new BeanAlternative());
    }

    @Test
    public void demonstrateBeanPropertyAccess() {
        JavaBeanExample bean = new JavaBeanExample();
        bean.setName(NAME);
        assertEquals(NAME, bean.getName());
    }

    /**
     * There is no encapsulation over field access as with Java Beans, which makes the code a little less verbose.
     * There are a few drawbacks, though:
     * <ul>
     *     <li>The class will not work with tooling that expects JavaBeans</li>
     *     <li>
     *         Since the encapsulation is removed, more changes will need to be made if the implementation or
     *         underlying data representation changes. For example, if <code>name</code> becomes a synthetic property
     *         comprising first and last names concatenated, all direct uses of the <code>name</code>  field
     *         will need to be updated to reflect this
     *     </li>
     *     <li>It is not considered to be idiomatic Java</li>
     * </ul>
     */
    @Test
    public void demonstrateDirectFieldAccess() {
        BeanAlternative alternative = new BeanAlternative();
        alternative.name = NAME;
        assertEquals(NAME, alternative.name);
    }
}
