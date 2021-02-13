package com.kimxavi.xunit;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class AnnotationUtils {
    public static List<Method> findMethodFromAnnotation(Class targetClass, Class<? extends Annotation> annotation) {
        List<Method> methods = new ArrayList<>();

        for (Method method : targetClass.getMethods()) {
            Annotation xTest = method.getAnnotation(annotation);
            if (xTest != null) {
                methods.add(method);
            }
        }
        return methods;
    }
}
