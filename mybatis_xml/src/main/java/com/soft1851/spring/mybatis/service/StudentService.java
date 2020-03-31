package com.soft1851.spring.mybatis.service;

import com.soft1851.spring.mybatis.entity.MatterDto;
import com.soft1851.spring.mybatis.entity.MatterVo;
import com.soft1851.spring.mybatis.entity.Student;

import java.util.List;

/**
 * @ClassName StudentService
 * @Description TODO
 * @Author xiaobinggan
 * @Date 2020/3/31 1:38 下午
 * @Version 1.0
 **/

public interface StudentService {
    /**
     * 新增student，并返回自增主键
     *
     * @param student
     */
    void insert(Student student);

    /**
     * 批量插入
     *
     * @param students
     * @return
     */
    int batchInsert(List<Student> students);

    /**
     * 根据学生ID删除学生
     *
     * @param studentId
     */
    void delete(int studentId);

    /**
     * 根据学生id批量删除
     *
     * @param idList
     * @return
     */
    int batchDelete(List<Integer> idList);

    /**
     * 修改学生信息
     *
     * @param student
     */
    void update(Student student);

    /**
     * 批量修改学生信息
     *
     * @param students
     * @return
     */

    int batchUpdate(List<Student> students);

    /**
     * 单表（带两个指定条件）查询
     *
     * @return
     */
    List<Student> selectLimit();

    /**
     * 单表指定条件查询（结合动态SQL）
     *
     * @param student
     * @return
     */

    List<Student> selectLimitByDynamicSql(Student student);

    /**
     * 查询某位老师的某个班级上面的某个学生
     *
     * @param matterDto
     * @return
     */
    List<MatterVo> selectLimitFromTeacherInClassByDynamicSql(MatterDto matterDto);
}
