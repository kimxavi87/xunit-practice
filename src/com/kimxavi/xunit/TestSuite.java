package com.kimxavi.xunit;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TestSuite implements Test {
    List<Test> tests = new ArrayList<>();

    public TestSuite(Class<? extends TestCase> testClass) {
        List<Method> methodFromAnnotation = AnnotationUtils.findMethodFromAnnotation(SampleTests.class, XTest.class);
        try {
            for (Method method : methodFromAnnotation) {
                add(testClass.getConstructor(String.class).newInstance(method.getName()));
            }
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException("Cannot find constructor");
        }
    }

    public void add(Test test) {
        tests.add(test);
    }

    @Override
    public final void run(TestResult testResult) {
        for (Test test : tests) {
            test.run(testResult);
        }
    }
}
