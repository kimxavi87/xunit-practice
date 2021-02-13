package com.kimxavi.xunit;

public class SampleTests extends TestCase {
    public SampleTests(String name) {
        super(name);
    }

    public void testRunning() {
        WasRun wasRun = new WasRun();
        Assert.assertEquals(wasRun.wasRun, false);
        wasRun.run();
        Assert.assertEquals(wasRun.wasRun, true);
    }

    public void testAssert() {
        Assert.assertEquals(0, 0);
    }
}
