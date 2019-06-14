package com.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> aClass = Class.forName("com.reflect.Student");
        Constructor<?>[] constructors = aClass.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor.getName());
        }
        Method[] declaredMethods = aClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod.getName());
        }
        new HashMap<>();


        int i = 8;
        if (i == 8)
            System.out.println("i=" + 8);
        else if (i==9)
            System.out.println("i="+9);
        else {
            System.out.println("ibu");
        }

    }
}
