package com.soft1851.spring.mybatis.mapper;

import com.soft1851.spring.mybatis.entity.MatterDto;
import com.soft1851.spring.mybatis.entity.MatterVo;
import com.soft1851.spring.mybatis.entity.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName StudentMapper
 * @Description TODO
 * @Author xiaobinggan
 * @Date 2020/3/31 1:33 下午
 * @Version 1.0
 **/
@Transactional(rollbackFor = Exception.class)
public interface StudentMapper {
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
    int batchInsert(@Param("students") List<Student> students);

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
    int batchDelete(@Param("idList") List<Integer> idList);

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

    int batchUpdate(@Param("students") List<Student> students);

    /**
     * 查询所有学生，按生日排序,多对一关联查询学生所在班级信息
     *
     * @return List<Student>
     */
    List<Student> selectAll();

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
