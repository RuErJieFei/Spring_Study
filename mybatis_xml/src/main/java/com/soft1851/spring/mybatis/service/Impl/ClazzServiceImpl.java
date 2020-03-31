package com.soft1851.spring.mybatis.service.Impl;

import com.soft1851.spring.mybatis.entity.Clazz;
import com.soft1851.spring.mybatis.entity.ClazzVo;
import com.soft1851.spring.mybatis.mapper.ClazzMapper;
import com.soft1851.spring.mybatis.service.ClazzService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName ClazzServiceImpl
 * @Description TODO
 * @Author xiaobinggan
 * @Date 2020/3/31 8:06 下午
 * @Version 1.0
 **/
@Service
public class ClazzServiceImpl implements ClazzService {
    @Resource
    private ClazzMapper clazzMapper;

    @Override
    public List<ClazzVo> getClazzStudent(int clazzId) {
        return clazzMapper.getClazzStudent(clazzId);
    }

    @Override
    public Clazz getClazzOneToMany(int clazzId) {
        return clazzMapper.getClazzOneToMany(clazzId);
    }
}