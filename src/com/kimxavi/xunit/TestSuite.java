package com.kimxavi.xunit;

import java.util.ArrayList;
import java.util.List;

public class TestSuite implements Test {
    List<Test> tests = new ArrayList<>();

    public void add(Test test) {
        tests.add(test);
    }

    @Override
    public void run(TestResult testResult) {
        for (Test test : tests) {
            test.run(testResult);
        }
    }
}
