package com.kimxavi.xunit;

public class Main {
    public static void main(String[] args) {
        new SampleTests("testRunning").run();
        new SampleTests("testAssert").run();
    }
}
