package com.soft1851.spring.mybatis.service;

import com.soft1851.spring.mybatis.entity.Clazz;
import com.soft1851.spring.mybatis.entity.ClazzVo;

import java.util.List;

/**
 * @ClassName ClazzService
 * @Description TODO
 * @Author xiaobinggan
 * @Date 2020/3/31 8:05 下午
 * @Version 1.0
 **/
public interface ClazzService {
    /**
     * 获取指定班课所有学生信息
     *
     * @param clazzId
     * @return
     */
    List<ClazzVo> getClazzStudent(int clazzId);

    /**
     * 根据clazzId一对多关联查询本班所有学生
     *
     * @param clazzId
     * @return
     */
    Clazz getClazzOneToMany(int clazzId);
}
