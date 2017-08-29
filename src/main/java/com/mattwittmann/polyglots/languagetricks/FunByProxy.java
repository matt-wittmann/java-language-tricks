package com.mattwittmann.polyglots.languagetricks;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

class FunByProxy {
    interface Fun {
        String jumpRope();
        String skip();
        String implementAllTheThings();
    }

    interface NotFun {
        double plusFun();
    }

    static class FunInvocationHandler implements InvocationHandler {
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) {
            switch (method.getName()) {
                case "jumpRope":
                case "skip":
                    return "No";
                case "implementAllTheThings":
                    return "Done";
            }

            throw new IllegalArgumentException(method.getName() + " does not exist.");
        }
    }

    static Fun haveFunByProxy() {
        return (Fun) Proxy.newProxyInstance(
                FunByProxy.class.getClassLoader(),
                new Class<?>[] { Fun.class, NotFun.class },
                new FunInvocationHandler()
        );
    }
}
