package com.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

@MyAnnotation
public class Test {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
        Annotation[] annotations =
                Test.class.getAnnotations();
        for (Annotation annotation : annotations) {
            if (annotation instanceof MyAnnotation) {
                String[] value = ((MyAnnotation) annotation).value();
                Arrays.stream(value).forEach((x) -> System.out.println(x));
            }
        }


        Method[] declaredMethods =
                Test.class.getDeclaredMethods();
        Test test = Test.class.newInstance();
        Method fun = Test.class.getMethod("fun");
        fun.invoke(test);

        Map<Object, Object> objectObjectMap = Collections.synchronizedMap(new HashMap<>());
//        Map<Object, Object> objectObjectMap=new HashMap<>();

        for (int i = 0; i < 1000; i++) {
            int z=i;
            new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    objectObjectMap.put(j+z, j);
                }
            }).start();
        }

//            System.out.println(objectObjectMap);
//        for (int i = 0; i < 100; i++) {
//            new Thread(() -> {
//                for (int j = 100; j < 200; j++) {
//                    objectObjectMap.put(j, 2);
//                }
//            }).start();
//        }
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println(objectObjectMap);
    }

    public void fun() {
        System.out.println("fasj");
    }
}
