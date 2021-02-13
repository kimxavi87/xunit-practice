package com.kimxavi.xunit;

public class Main {
    public static void main(String[] args) {
        TestResult testResult = new TestResult();
        TestSuite testSuite = SampleTests.suite();
        testSuite.run(testResult);
        System.out.println(testResult.getSummary());
    }
}
