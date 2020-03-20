package com.soft1851.spring.orm.entity;

import com.soft1851.spring.orm.config.AppConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"/beans.xml"})
public class BookTest {
    @Test
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        ctx.scan("com.soft1851.spring.ioc.config");
//        ctx.refresh();
        Book book = (Book) ctx.getBean("book");
        book.setName("java");
        book.setPrice(88.8);
        System.out.println(book);
    }
}