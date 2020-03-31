package com.soft1851.spring.mybatis.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring-mybatis.xml"})
public class CourseMapperTest {
    @Resource
    private CourseMapper courseMapper;

    @Test
    public void getCourseById() {
        System.out.println(courseMapper.getCourseById(20001));
    }
}