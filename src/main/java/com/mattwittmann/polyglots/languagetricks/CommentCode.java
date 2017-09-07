package com.mattwittmann.polyglots.languagetricks;

class CommentCode {
    static int biggerThanExpected() {
        int i = 0;
        // Is it really just a comment?
        // \u000A while (i < 5)
        i++;

        return i;
    }
}
