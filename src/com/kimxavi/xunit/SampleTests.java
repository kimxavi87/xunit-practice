package com.kimxavi.xunit;

public class SampleTests extends TestCase {
    public SampleTests(String name) {
        super(name);
    }

    public void testRunning() {
        WasRun wasRun = new WasRun("testRunning");
        wasRun.run();
        Assert.assertEquals(wasRun.log, "setUp run tearDown");
    }

    public void testAssert() {
        Assert.assertEquals(0, 0);
    }
}
