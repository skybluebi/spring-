package com.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ioc=new ClassPathXmlApplicationContext("springmvc.xml");
        Object student = ioc.getBean("student");
        System.out.println(student);
        Object car = ioc.getBean("car");
        System.out.println(car);
    }
}
