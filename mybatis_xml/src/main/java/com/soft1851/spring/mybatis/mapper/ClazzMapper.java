package com.soft1851.spring.mybatis.mapper;

import com.soft1851.spring.mybatis.entity.Clazz;
import com.soft1851.spring.mybatis.entity.ClazzVo;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName ClazzMapper
 * @Description TODO
 * @Author xiaobinggan
 * @Date 2020/3/31 7:59 下午
 * @Version 1.0
 **/
@Transactional(rollbackFor = Exception.class)
public interface ClazzMapper {
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