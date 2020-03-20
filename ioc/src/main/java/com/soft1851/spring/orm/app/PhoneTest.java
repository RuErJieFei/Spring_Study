package com.soft1851.spring.orm.app;

import com.soft1851.spring.orm.entity.Phone;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName PhoneTest
 * @Description TODO
 * @Author xiaobinggan
 * @Date 2020/3/12 10:31 上午
 * @Version 1.0
 **/
public class PhoneTest {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        Phone phone = (Phone) ac.getBean("phone");
        System.out.println(phone);
    }
}
