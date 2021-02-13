package com.kimxavi.xunit;

public class Main {
    public static void main(String[] args) {
        TestResult testResult = new TestResult();
        new SampleTests("testRunning").run(testResult);
        new SampleTests("testAssert").run(testResult);
        new SampleTests("testResult").run(testResult);
        new SampleTests("testFailed").run(testResult);
        System.out.println(testResult.getSummary());
    }
}
