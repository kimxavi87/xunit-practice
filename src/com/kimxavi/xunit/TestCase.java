package com.kimxavi.xunit;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
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
    public final void run(TestResult testResult) {
        testResult.testStarted();
        setUp();

        try {
//            Method method = getClass().getMethod(name);
//            method.invoke(this);
            MethodType methodType = MethodType.methodType(void.class);
            MethodHandles.Lookup lookup = MethodHandles.lookup();
            MethodHandle virtual = lookup.findVirtual(getClass(), name, methodType);
            virtual.invoke(this);
        } catch (Throwable e) {
            testResult.testFailed();
        }

        tearDown();
    }
}
