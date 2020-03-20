package com.soft1851.spring.orm.entity;


import com.soft1851.spring.orm.config.AppConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"/beans.xml"})
@ContextConfiguration(classes = AppConfig.class)
public class PhoneTestTest {
    @Autowired
    private Phone phone;

    @Autowired
    private Student student;

    @Test
    public void print() {
        System.out.println(phone);
        System.out.println(student);
    }
}