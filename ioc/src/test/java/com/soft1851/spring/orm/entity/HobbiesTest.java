package com.soft1851.spring.orm.entity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/beans.xml"})
public class HobbiesTest {
    @Autowired
    private Hobbies hobbies;

    @Test
    public void setHobbies(){
        System.out.println(hobbies.getHobbies());
        System.out.println(hobbies.getPhones());
    }
}