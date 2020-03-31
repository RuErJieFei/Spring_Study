package com.soft1851.spring.mybatis.mapper;

import com.soft1851.spring.mybatis.entity.Course;

/**
 * @ClassName CourseMapper
 * @Description TODO
 * @Author xiaobinggan
 * @Date 2020/3/31 9:25 下午
 * @Version 1.0
 **/
public interface CourseMapper {
    /**
     * 根据班课id查询班课详情(班课自身信息、学生列表)
     *
     * @param courseId
     * @return
     */
    Course getCourseById(int courseId);
}
