package com.mattwittmann.polyglots.languagetricks;

class JavaBeanAlternatives {
    static class JavaBeanExample {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    static class BeanAlternative {
        String name;
    }
}
