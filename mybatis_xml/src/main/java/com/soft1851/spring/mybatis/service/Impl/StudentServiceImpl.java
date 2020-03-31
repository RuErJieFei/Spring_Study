package com.soft1851.spring.mybatis.service.Impl;

import com.soft1851.spring.mybatis.entity.MatterDto;
import com.soft1851.spring.mybatis.entity.MatterVo;
import com.soft1851.spring.mybatis.entity.Student;
import com.soft1851.spring.mybatis.mapper.StudentMapper;
import com.soft1851.spring.mybatis.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName StudentServiceImpl
 * @Description TODO
 * @Author xiaobinggan
 * @Date 2020/3/31 1:42 下午
 * @Version 1.0
 **/
@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentMapper studentMapper;

    @Override
    public List<MatterVo> selectLimitFromTeacherInClassByDynamicSql(MatterDto matterDto) {
        return studentMapper.selectLimitFromTeacherInClassByDynamicSql(matterDto);
    }

    @Override
    public void insert(Student student) {
        studentMapper.insert(student);
    }

    @Override
    public int batchInsert(List<Student> students) {
        return studentMapper.batchInsert(students);
    }

    @Override
    public void delete(int studentId) {
        studentMapper.delete(studentId);
    }

    @Override
    public int batchDelete(List<Integer> idList) {
        return studentMapper.batchDelete(idList);
    }

    @Override
    public void update(Student student) {
        studentMapper.update(student);
    }

    @Override
    public int batchUpdate(List<Student> students) {
        return studentMapper.batchUpdate(students);
    }

    @Override
    public List<Student> selectLimit() {
        return studentMapper.selectLimit();
    }

    @Override
    public List<Student> selectLimitByDynamicSql(Student student) {
        return studentMapper.selectLimitByDynamicSql(student);
    }


}
