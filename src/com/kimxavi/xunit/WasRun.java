package com.kimxavi.xunit;

public class WasRun implements Test {
    public boolean wasRun = false;

    public void run() {
        wasRun = true;
    }

    public void testRunning() {
        run();
    }
}
