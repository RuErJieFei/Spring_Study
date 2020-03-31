package com.soft1851.spring.mybatis.service;

import com.soft1851.spring.mybatis.entity.Teacher;

/**
 * @ClassName TeacherService
 * @Description TODO
 * @Author xiaobinggan
 * @Date 2020/3/31 8:38 下午
 * @Version 1.0
 **/
public interface TeacherService {
    /**
     * 根据teacherId一对一关联查询其管理的班级信息
     *
     * @param teacherId
     * @return
     */
    Teacher getTeacherOneToOne(int teacherId);
}
