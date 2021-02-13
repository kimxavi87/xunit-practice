package com.kimxavi.xunit;

public class Assert {
    public static void assertEquals(Object expected, Object value) {
        if (!expected.equals(value)) {
            throw new RuntimeException("expected : " + expected + " but " + value);
        }
    }
}
