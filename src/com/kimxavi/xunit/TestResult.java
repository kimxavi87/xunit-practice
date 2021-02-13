package com.kimxavi.xunit;

public class TestResult {
    private int runCount = 0;
    private int errorCount = 0;

    public String getSummary() {
        return "run : " +  runCount + ", failed : " + errorCount;
    }

    public void testStarted() {
        runCount++;
    }

    public void testFailed() {
        errorCount++;
    }
}
