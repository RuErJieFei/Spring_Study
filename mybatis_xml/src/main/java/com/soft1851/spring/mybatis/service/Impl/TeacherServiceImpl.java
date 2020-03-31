package com.soft1851.spring.mybatis.service.Impl;

import com.soft1851.spring.mybatis.entity.Teacher;
import com.soft1851.spring.mybatis.service.TeacherService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName TeacherServiceImpl
 * @Description TODO
 * @Author xiaobinggan
 * @Date 2020/3/31 8:38 下午
 * @Version 1.0
 **/
@Service
public class TeacherServiceImpl implements TeacherService {
    @Resource
    private TeacherService teacherService;

    @Override
    public Teacher getTeacherOneToOne(int teacherId) {
        return teacherService.getTeacherOneToOne(teacherId);
    }
}
