package com.kimxavi.xunit;

import java.lang.reflect.InvocationTargetException;
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
    public void run() {
        setUp();

        try {
            Method method = getClass().getMethod(name);
            method.invoke(this);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        tearDown();
    }
}
