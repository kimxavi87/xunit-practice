package com.kimxavi.xunit;

public class Main {
    public static void main(String[] args) {
        TestResult testResult = new TestResult();
        TestSuite testSuite = new TestSuite();
        testSuite.add(new SampleTests("testRunning"));
        testSuite.add(new SampleTests("testAssert"));
        testSuite.add(new SampleTests("testResult"));
        testSuite.add(new SampleTests("testFailed"));
        testSuite.run(testResult);
        System.out.println(testResult.getSummary());
    }
}
