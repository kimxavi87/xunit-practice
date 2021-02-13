package com.kimxavi.xunit;

import java.lang.reflect.Method;

public class TestCase implements Test {
    private String name;
    public TestCase(String name) {
        this.name = name;
    }

    public void setUp() {
    }

    public void tearDown() {
    }

    @Override
    public void run(TestResult testResult) {
        testResult.testStarted();
        setUp();

        try {
            Method method = getClass().getMethod(name);
            method.invoke(this);
        } catch (Exception e) {
            testResult.testFailed();
        }

        tearDown();
    }
}
