package com.mattwittmann.polyglots.languagetricks;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.agent.ByteBuddyAgent;
import net.bytebuddy.dynamic.loading.ClassReloadingStrategy;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.matcher.ElementMatchers;

class BytecodeInstrumentation {
    static final String REDEFINED_RETURN_VALUE = "Doing all the things";

    static class ImportantClass {
        String doThings() {
            return "Done";
        }
    }

    static void redefineClass() {
        ByteBuddyAgent.install();
        new ByteBuddy().redefine(ImportantClass.class)
                .method(ElementMatchers.named("doThings"))
                .intercept(FixedValue.value(REDEFINED_RETURN_VALUE))
                .make()
                .load(ImportantClass.class.getClassLoader(), ClassReloadingStrategy.fromInstalledAgent());
    }
}
