package com.soft1851.spring.orm.entity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/beans.xml"})
public class HelloTest {
    @Test
    public void sayHello() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("/beans.xml");
        Hello hello = (Hello) ac.getBean("hello");
        hello.sayHello();
    }
}