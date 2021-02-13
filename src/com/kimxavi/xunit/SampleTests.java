package com.kimxavi.xunit;

public class SampleTests extends TestCase {
    public SampleTests(String name) {
        super(name);
    }

    public static TestSuite suite() {
        TestSuite testSuite = new TestSuite();
        testSuite.add(new SampleTests("testRunning"));
        testSuite.add(new SampleTests("testAssert"));
        testSuite.add(new SampleTests("testResult"));
        testSuite.add(new SampleTests("testFailed"));
        return testSuite;
    }

    public void testRunning() {
        TestResult testResult = new TestResult();
        WasRun wasRun = new WasRun("testRunning");
        wasRun.run(testResult);
        Assert.assertEquals(wasRun.log, "setUp run tearDown");
    }

    public void testAssert() {
        Assert.assertEquals(0, 0);
    }

    public void testResult() {
        TestResult testResult = new TestResult();
        WasRun wasRun = new WasRun("testRunning");
        wasRun.run(testResult);
        Assert.assertEquals(testResult.getSummary(), "run : 1, failed : 0");
    }

    public void testFailed() {
        TestResult testResult = new TestResult();
        WasRun wasRun = new WasRun("testBroken");
        wasRun.run(testResult);
        Assert.assertEquals(testResult.getSummary(), "run : 1, failed : 1");
    }

    public void testSuite() {
        TestResult testResult = new TestResult();
        TestSuite testSuite = new TestSuite();
    }
}
