package com.kimxavi.xunit;

import java.lang.reflect.Method;
import java.util.List;

public class SampleTests extends TestCase {
    public SampleTests(String name) {
        super(name);
    }

    public static TestSuite suite() {
        TestSuite testSuite = new TestSuite(SampleTests.class);
        testSuite.add(new SampleTests("testXtestMethod"));
        testSuite.add(new SampleTests("testNotXtestMethod"));
        return testSuite;
    }

    public void setUp() {

    }

    @XTest
    public void testRunning() {
        TestResult testResult = new TestResult();
        WasRun wasRun = new WasRun("testRunning");
        wasRun.run(testResult);
        Assert.assertEquals(wasRun.log, "setUp run tearDown");
    }

    @XTest
    public void testAssert() {
        Assert.assertEquals(0, 0);
    }

    @XTest
    public void testResult() {
        TestResult testResult = new TestResult();
        WasRun wasRun = new WasRun("testRunning");
        wasRun.run(testResult);
        Assert.assertEquals(testResult.getSummary(), "run : 1, failed : 0");
    }

    @XTest
    public void testFailed() {
        TestResult testResult = new TestResult();
        WasRun wasRun = new WasRun("testBroken");
        wasRun.run(testResult);
        Assert.assertEquals(testResult.getSummary(), "run : 1, failed : 1");
    }

    @XTest
    public void testDummyMethodXtest() {

    }

    public void testDummyMethodNotXtest() {

    }

    public void testXtestMethod() throws NoSuchMethodException {
        List<Method> methodFromAnnotation = AnnotationUtils.findMethodFromAnnotation(SampleTests.class, XTest.class);
        Method testDummyMethod = getClass().getMethod("testDummyMethodXtest");
        Assert.assertEquals(true, methodFromAnnotation.contains(testDummyMethod));
    }

    public void testNotXtestMethod() throws NoSuchMethodException {
        List<Method> methodFromAnnotation = AnnotationUtils.findMethodFromAnnotation(SampleTests.class, XTest.class);
        Method testDummyMethodNotXtest = getClass().getMethod("testDummyMethodNotXtest");
        Assert.assertEquals(false, methodFromAnnotation.contains(testDummyMethodNotXtest));
    }
}
