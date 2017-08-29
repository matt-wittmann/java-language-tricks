package com.mattwittmann.polyglots.languagetricks;

import java.util.Locale;

/**
 * An homage to
 * <a href="https://thedailywtf.com/articles/The_Brillant_Paula_Bean">The Brilliant Paula Bean</a>.
 */
class NotPaulaBean {
    private String notPaula = "Brilliant";

    public String getNotPaula() {
        // Some business logic
        return "Sheer " + notPaula.toUpperCase(Locale.US).substring(0, notPaula.length() - 1) + "ce!";
    }
}
