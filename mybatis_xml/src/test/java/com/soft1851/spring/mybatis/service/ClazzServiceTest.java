package com.soft1851.spring.mybatis.service;

import com.soft1851.spring.mybatis.entity.Clazz;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring-mybatis.xml"})
public class ClazzServiceTest {
    @Resource
    private ClazzService clazzService;

    @Test
    public void getClazzStudent() {
        clazzService.getClazzStudent(1).forEach(System.out::println);
    }

    @Test
    public void getClazzOneToMany(){
        System.out.println(clazzService.getClazzOneToMany(1));
    }

}