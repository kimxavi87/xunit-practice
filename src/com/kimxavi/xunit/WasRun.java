package com.kimxavi.xunit;

public class WasRun extends TestCase {
    public String log;

    public WasRun(String name) {
        super(name);
    }

    public void setUp() {
        log = "setUp";
    }

    public void tearDown() {
        log += " tearDown";
    }

    public void testRunning() {
        log += " run";
    }

    public void testBroken() {
        throw new RuntimeException("Failed");
    }
}
